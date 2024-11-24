package com.deaconess.TaskManagement.controller.question;

import com.deaconess.TaskManagement.baen.view.question.Question;
import com.deaconess.TaskManagement.baen.view.question.QuestionAnswer;
import com.deaconess.TaskManagement.entity.*;
import com.deaconess.TaskManagement.repository.*;
import com.google.gson.Gson;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class questionViewController {

    private final ApiSettingRepository repository;
    private final TopMenuRepository topMenuRepository;
    private final QuestionAnswerMenuDetailRepository questionAnswerMenuDetailRepository;
    private final QuestionAnswerMenuDetailAnswerRepository questionAnswerMenuDetailAnswerRepository;
    private final ResponseTypeRepository responseTypeRepository ;

    public questionViewController(ApiSettingRepository repository, TopMenuRepository topMenuRepository, QuestionAnswerMenuDetailRepository questionAnswerMenuDetailRepository, QuestionAnswerMenuDetailAnswerRepository questionAnswerMenuDetailAnswerRepository, ResponseTypeRepository responseTypeRepository) {
        this.repository = repository;
        this.topMenuRepository = topMenuRepository;
        this.questionAnswerMenuDetailRepository = questionAnswerMenuDetailRepository;
        this.questionAnswerMenuDetailAnswerRepository = questionAnswerMenuDetailAnswerRepository;
        this.responseTypeRepository = responseTypeRepository;
    }

    @RequestMapping("/question_and_answer/{pathParam}")
    public String setting(Model model,@PathVariable("pathParam") String pathParam) {
        System.out.println(pathParam);
        String path="/question_and_answer/"+pathParam;
        TopMenu topMenu=topMenuRepository.findMenu(path);
        List<QuestionAnswerMenuDetail> detailList=questionAnswerMenuDetailRepository.findPath(path);
        List<QuestionAnswer> questionAnswerList=new ArrayList<>();
        for(QuestionAnswerMenuDetail questionAnswerMenuDetail:detailList){
            System.out.println(questionAnswerMenuDetail.getDetailName());
            List<QuestionAnswerMenuDetailAnswer> questionAnswerMenuDetailAnswerList=questionAnswerMenuDetailAnswerRepository.findDetail(path,questionAnswerMenuDetail.getDetailNo());
            QuestionAnswer questionAnswer=new QuestionAnswer();
            questionAnswer.setQuestionAnswerMenuDetail(questionAnswerMenuDetail);
            questionAnswer.setQuestionAnswerMenuDetailAnswerList(questionAnswerMenuDetailAnswerList);
            questionAnswerList.add(questionAnswer);
        }
        model.addAttribute("topMenu",topMenu);
        model.addAttribute("questionAnswerList",questionAnswerList);
        return "questionAnswer";
    }

}
