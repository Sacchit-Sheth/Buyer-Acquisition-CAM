package com.data.form.common;

import java.util.List;

public class GenericResponse {

	private Integer code;

	private String message;
	private Object data;
	private List<String> errors;

	public GenericResponse(Object data) {
		this.data = data;

	}

	public GenericResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @param value
	 * @param string
	 * @param errors
	 */
	public GenericResponse(int value, String string, List<String> errors) {
		this.code = value;
		this.message = string;
		this.errors = errors;
	}
}