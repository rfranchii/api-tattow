package com.sqav.tattow.vo;

import java.io.Serializable;

public class StandardObjectReturn implements Serializable {

	private static final long serialVersionUID = -3068206033991841284L;
	
	private Integer status = 200;
	private String msg;
	private Object object;
	private Long timestamp;
	
	public StandardObjectReturn() {
		// TODO Auto-generated constructor stub
	}
	
	public StandardObjectReturn(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	
	public StandardObjectReturn(Integer status, String msg, Object object) {
		super();
		this.status = status;
		this.msg = msg;
		this.object = object;
	}

	public StandardObjectReturn(Integer status, String msg, Object object, Long timestamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.object = object;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}