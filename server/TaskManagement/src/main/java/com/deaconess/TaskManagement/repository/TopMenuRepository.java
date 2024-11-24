package com.deaconess.TaskManagement.repository;

import com.deaconess.TaskManagement.entity.ApiSetting;
import com.deaconess.TaskManagement.entity.TopMenu;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopMenuRepository extends CrudRepository<TopMenu, Long> {

    @Query(name = "TopMenu.findAllTopMenuId")
    List<TopMenu> findTopMenu();

    @Query(name= "TopMenu.urlPath")
    TopMenu findMenu(String urlPath);

}
