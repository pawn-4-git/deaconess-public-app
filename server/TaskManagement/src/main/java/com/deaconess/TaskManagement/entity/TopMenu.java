package com.deaconess.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "top_menu")
@NamedQuery(name = "TopMenu.findAllTopMenuId", query = "FROM TopMenu t ORDER BY t.topMenuId")
@NamedQuery(name = "TopMenu.urlPath", query = "FROM TopMenu t WHERE t.urlPath = :urlPath")
public class TopMenu {

    @Id
    private int topMenuId;
    private String urlPath;
    private String menuName;

    public int getTopMenuId() {
        return topMenuId;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setTopMenuId(int topMenuId) {
        this.topMenuId = topMenuId;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
