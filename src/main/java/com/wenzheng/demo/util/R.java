package com.wenzheng.demo.util;

public class R<T> {
	public int code;
	public T data;
	public String msg;
	public int count;
	
	public int getCode(){
		return this.code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
