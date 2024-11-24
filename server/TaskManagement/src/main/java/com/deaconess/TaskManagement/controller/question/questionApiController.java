package com.deaconess.TaskManagement.controller.question;

import com.deaconess.TaskManagement.baen.view.question.Question;
import com.deaconess.TaskManagement.baen.view.question.QuestionAnswer;
import com.deaconess.TaskManagement.entity.*;
import com.deaconess.TaskManagement.repository.*;
import com.google.gson.Gson;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class questionApiController {

    private final ApiSettingRepository repository;
    private final TopMenuRepository topMenuRepository;
    private final QuestionAnswerMenuDetailRepository questionAnswerMenuDetailRepository;
    private final QuestionAnswerMenuDetailAnswerRepository questionAnswerMenuDetailAnswerRepository;
    private final ResponseTypeRepository responseTypeRepository ;

    public questionApiController(ApiSettingRepository repository, TopMenuRepository topMenuRepository, QuestionAnswerMenuDetailRepository questionAnswerMenuDetailRepository, QuestionAnswerMenuDetailAnswerRepository questionAnswerMenuDetailAnswerRepository, ResponseTypeRepository responseTypeRepository) {
        this.repository = repository;
        this.topMenuRepository = topMenuRepository;
        this.questionAnswerMenuDetailRepository = questionAnswerMenuDetailRepository;
        this.questionAnswerMenuDetailAnswerRepository = questionAnswerMenuDetailAnswerRepository;
        this.responseTypeRepository = responseTypeRepository;
    }

    @RequestMapping(value = "/get_answer_for_answer",
            method = RequestMethod.POST)
    public ResponseEntity<Question> getAnswerForQuestion(@RequestBody String payload) {
        Gson gson = new Gson();
        Question question = gson.fromJson(payload, Question.class);
        try {
            Optional<ApiSetting> apiSetting = repository.findById(1L);
            List<Message> messageList = new ArrayList<>();
            System.out.println(question.getUrlPath());
            System.out.println(Integer.valueOf(question.getDetailNo()));
            System.out.println(Integer.valueOf(question.getAnswerNo()));
            QuestionAnswerMenuDetailAnswerId questionAnswerMenuDetailAnswerId = new QuestionAnswerMenuDetailAnswerId();
            questionAnswerMenuDetailAnswerId.setUrlPath(question.getUrlPath());
            questionAnswerMenuDetailAnswerId.setDetailNo(Integer.valueOf(question.getDetailNo()));
            questionAnswerMenuDetailAnswerId.setAnswerNo(Integer.valueOf(question.getAnswerNo()));
            Optional<QuestionAnswerMenuDetailAnswer> questionAnswerMenuDetailAnswer = questionAnswerMenuDetailAnswerRepository.findById(questionAnswerMenuDetailAnswerId);
            Iterable<QuestionAnswerMenuDetailAnswer> questionAnswerMenuDetailAnswerList = questionAnswerMenuDetailAnswerRepository.findAll();

            Optional<ResponseType> responseType = responseTypeRepository.findById(questionAnswerMenuDetailAnswer.get().getResponseType().longValue());
            Message systemMessage = new SystemMessage(responseType.get().getResponseSystem());
            Message userMessageText = new UserMessage(question.getInputText());

            messageList.add(systemMessage);
            if (question.getBeforeAnswer() != null) {
                for (Question.BeforeAnswer beforeAnswer : question.getBeforeAnswer()) {
                    Message beforeMessageText = new UserMessage(beforeAnswer.getInputText());
                    Message beforeAnswerText = new AssistantMessage(beforeAnswer.getAnswerText());
                    messageList.add(beforeMessageText);
                    messageList.add(beforeAnswerText);
                }
            }
            messageList.add(userMessageText);
            OpenAiApi openAiApi = new OpenAiApi(apiSetting.get().getOpenaiApiKey());
            ChatModel chatModel = new OpenAiChatModel(openAiApi);
            ChatResponse response = chatModel.call(
                    new Prompt(
                            messageList,
                            OpenAiChatOptions.builder()
                                    .withModel("gpt-4o")
                                    .build()
                    ));
            question.setResponseText(response.getResults().getFirst().getOutput().getContent());
            return ResponseEntity.ok(question);
        }catch (Exception e){
            question.setResponseText("エラーが発生しました");
            return ResponseEntity.ok(question);
        }

    }
}
