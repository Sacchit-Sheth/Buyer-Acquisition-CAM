package com.data.form.service;

import com.data.form.DTO.FormDTO;
import com.data.form.exception.FormCollectionException;

public interface FormService {

	void saveCAMForm(FormDTO form, String submissionId) throws FormCollectionException;

	void submitCAMForm(FormDTO form, String submissionId) throws FormCollectionException;

}
