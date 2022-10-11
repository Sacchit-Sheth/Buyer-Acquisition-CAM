package com.data.form.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.form.DTO.FormDTO;
import com.data.form.exception.FormCollectionException;
import com.data.form.repository.FormRepo;

@RestController
public class FormController {
	
	@Autowired
	private FormRepo formRepo;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveForm(@RequestBody FormDTO form, @RequestParam(required = false) String submissionId) throws FormCollectionException
	{
		if(submissionId!=null)
		{
			Optional<FormDTO> formOptional=formRepo.findById(submissionId);
			if(formOptional.get().isSubmitted())
			{
				throw new FormCollectionException(FormCollectionException.FormSubmitted()); 
			}
			if(formOptional.isPresent()) {
			FormDTO updatedForm=formOptional.get();
			updatedForm.setSubmissionId(submissionId);
			formRepo.save(updatedForm);}
			else
			{
				throw new FormCollectionException(FormCollectionException.NotFoundException(submissionId));
			}
		}
		else
		{
			formRepo.save(form);
		}
		return new ResponseEntity<FormDTO>(form, HttpStatus.OK);
	}
	
	@PostMapping("/submit")
	public ResponseEntity<?> submitForm(@RequestBody FormDTO form, @RequestParam(required = false) String submissionId) throws FormCollectionException
	{
		if(submissionId!=null)
		{
			Optional<FormDTO> formOptional=formRepo.findById(submissionId);
			if(formOptional.get().isSubmitted())
			{
				throw new FormCollectionException(FormCollectionException.FormSubmitted()); 
			}
			if(formOptional.isPresent())
			{
				FormDTO updatedForm=formOptional.get();
				updatedForm.setSubmitted(true);
				formRepo.save(updatedForm);
			}
			else
			{
				throw new FormCollectionException(FormCollectionException.NotFoundException(submissionId));
			}
		}
		else
		{
			form.setSubmitted(true);
			formRepo.save(form);
		}
		return new ResponseEntity<FormDTO>(form, HttpStatus.OK);
	}
}
