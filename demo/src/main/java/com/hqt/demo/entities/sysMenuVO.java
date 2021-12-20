package com.hqt.demo.entities;

import java.util.Date;

public class sysMenuVO {
	private Integer id;
	private String menu_name;
	private String menu_des;
	private String menu_url;
	private Integer menu_parent;
	private String menu_role;
	private Integer menu_disabled;
	private String created_user;
	private Date created_date;
	private String updated_user;
	private Date updated_date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_des() {
		return menu_des;
	}
	public void setMenu_des(String menu_des) {
		this.menu_des = menu_des;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public Integer getMenu_parent() {
		return menu_parent;
	}
	public void setMenu_parent(Integer menu_parent) {
		this.menu_parent = menu_parent;
	}
	public String getMenu_role() {
		return menu_role;
	}
	public void setMenu_role(String menu_role) {
		this.menu_role = menu_role;
	}
	public Integer getMenu_disabled() {
		return menu_disabled;
	}
	public void setMenu_disabled(Integer menu_disabled) {
		this.menu_disabled = menu_disabled;
	}
	public String getCreated_user() {
		return created_user;
	}
	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getUpdated_user() {
		return updated_user;
	}
	public void setUpdated_user(String updated_user) {
		this.updated_user = updated_user;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	
	
}
