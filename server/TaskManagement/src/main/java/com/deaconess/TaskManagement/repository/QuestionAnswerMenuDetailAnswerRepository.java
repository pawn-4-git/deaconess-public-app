package com.deaconess.TaskManagement.repository;

import com.deaconess.TaskManagement.entity.QuestionAnswerMenuDetail;
import com.deaconess.TaskManagement.entity.QuestionAnswerMenuDetailAnswer;
import com.deaconess.TaskManagement.entity.QuestionAnswerMenuDetailAnswerId;
import com.deaconess.TaskManagement.entity.TopMenu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerMenuDetailAnswerRepository extends CrudRepository<QuestionAnswerMenuDetailAnswer, QuestionAnswerMenuDetailAnswerId> {
    @Query(name = "QuestionAnswerMenuDetailAnswer.findDetailNo")
    List<QuestionAnswerMenuDetailAnswer> findDetail(String urlPath,Integer detailNo);
}
