package com.data.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.form.DTO.FormDTO;
import com.data.form.common.GenericResponse;
import com.data.form.exception.FormCollectionException;
import com.data.form.service.FormService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FormController {
	
	@Autowired
	private FormService formService;
	
	@PostMapping("/saveCAM")
	public GenericResponse saveCAMForm(@RequestBody FormDTO form, @RequestParam(required = false) String submissionId) throws FormCollectionException
	{
		log.info("Entering into [FormController → saveCAMForm] for Submission Id {}", submissionId);
		try {
			formService.saveCAMForm(form,submissionId);
			return new GenericResponse(submissionId);
		} catch (FormCollectionException  e) {
			return new GenericResponse(422,e.getMessage());
		}
	}
	
	@PostMapping("/submitCAM")
	public GenericResponse submitCAMForm(@RequestBody FormDTO form, @RequestParam(required = false) String submissionId) throws FormCollectionException
	{
		log.info("Entering into [FormController → submitCAMForm] for Submission Id {}", submissionId);
		try {
			formService.submitCAMForm(form,submissionId);
			return new GenericResponse(submissionId);
		} catch (FormCollectionException  e) {
			return new GenericResponse(422,e.getMessage());
		}
	}
}
