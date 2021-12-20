package com.hqt.demo.entities;

import java.util.Date;

public class SysConfig {
	
	private Integer id;
	private String config_key;
	private String config_value;
	private String def_val;
	private String typ_var;
	private String config_used;
	private Date created_date;
	private String created_user;
	private Date update_date; 
	private String updated_user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConfig_key() {
		return config_key;
	}
	public void setConfig_key(String config_key) {
		this.config_key = config_key;
	}
	public String getConfig_value() {
		return config_value;
	}
	public void setConfig_value(String config_value) {
		this.config_value = config_value;
	}
	public String getDef_val() {
		return def_val;
	}
	public void setDef_val(String def_val) {
		this.def_val = def_val;
	}
	public String getTyp_var() {
		return typ_var;
	}
	public void setTyp_var(String typ_var) {
		this.typ_var = typ_var;
	}
	public String getConfig_used() {
		return config_used;
	}
	public void setConfig_used(String config_used) {
		this.config_used = config_used;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getCreated_user() {
		return created_user;
	}
	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getUpdated_user() {
		return updated_user;
	}
	public void setUpdated_user(String updated_user) {
		this.updated_user = updated_user;
	}
	

}
