package com.deaconess.TaskManagement.controller.common;

import com.deaconess.TaskManagement.baen.api.ApiKey;
import com.deaconess.TaskManagement.controller.BaseController;
import com.deaconess.TaskManagement.entity.ApiSetting;
import com.deaconess.TaskManagement.repository.ApiSettingRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class environmentContoroller  extends BaseController {

    private final ApiSettingRepository repository;

    @Autowired
    public environmentContoroller(ApiSettingRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value="/setting",
            method =  RequestMethod.POST)
    public String setting(@RequestBody String payload){

        ApiSetting apiSetting=new ApiSetting();
        Gson gson = new Gson();
        apiSetting=gson.fromJson(payload, ApiSetting.class);
        Optional<ApiSetting> apiSettingExist= repository.findById(apiSetting.getEnvId());
        if(apiSettingExist.isEmpty()){
            repository.save(apiSetting);
        }
        return String.valueOf(apiSetting.getEnvId());
    }

}
