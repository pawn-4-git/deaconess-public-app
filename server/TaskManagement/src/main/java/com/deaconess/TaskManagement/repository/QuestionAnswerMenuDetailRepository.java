package com.deaconess.TaskManagement.repository;

import com.deaconess.TaskManagement.entity.ApiSetting;
import com.deaconess.TaskManagement.entity.QuestionAnswerMenuDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerMenuDetailRepository extends CrudRepository<QuestionAnswerMenuDetail, Long> {

    @Query(name = "QuestionAnswerMenuDetail.findPath")
    List<QuestionAnswerMenuDetail> findPath(String urlPath);
}
