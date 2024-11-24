package com.deaconess.TaskManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.deaconess.TaskManagement.entity.*;

@Repository
public interface ApiSettingRepository extends CrudRepository<ApiSetting, Long> {
}
