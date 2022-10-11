package com.data.form.exception;

public class FormCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FormCollectionException(String message)
	{
		super(message);
	}
	public static String NotFoundException(String id) {
		return "Form with "+id+" not found.";
	}
	
	public static String FormSubmitted() {
		return "This form is already submitted.";
	}
}
