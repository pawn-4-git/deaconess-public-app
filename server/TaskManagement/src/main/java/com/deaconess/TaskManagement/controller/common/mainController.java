package com.deaconess.TaskManagement.controller.common;

import com.deaconess.TaskManagement.baen.api.ApiKey;
import com.deaconess.TaskManagement.controller.BaseController;
import com.deaconess.TaskManagement.entity.ApiSetting;
import com.deaconess.TaskManagement.entity.TopMenu;
import com.deaconess.TaskManagement.repository.ApiSettingRepository;
import com.deaconess.TaskManagement.repository.TopMenuRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequestMapping("")
@Controller
public class mainController {

    private final ApiSettingRepository repository;
    private final TopMenuRepository topMenuRepository;

    public mainController(ApiSettingRepository repository,TopMenuRepository topMenuRepository) {
        this.repository = repository;
        this.topMenuRepository = topMenuRepository;
    }

    @RequestMapping("")
    public String index(Model model) {
      List<TopMenu> topMenuList= topMenuRepository.findTopMenu();

        model.addAttribute("topMenuList",topMenuList);

      return "index";
    }
    @RequestMapping("/settingMenu")
    public String setting(Model model) {
        Iterable<ApiSetting> apiSettings= repository.findAll();
        HashMap<String,Long> apiSettingList=new HashMap<>();
        for(ApiSetting apiSetting:apiSettings){
            apiSettingList.put(apiSetting.getEnvName(),apiSetting.getEnvId());
        }
        model.addAttribute("settings",apiSettingList);
        return "settingMenu";
    }
}
