package com.deaconess.TaskManagement.repository;

import com.deaconess.TaskManagement.entity.ResponseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseTypeRepository extends CrudRepository<ResponseType, Long> {
}