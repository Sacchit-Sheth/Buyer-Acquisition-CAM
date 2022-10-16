package com.data.form.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.form.DTO.FormDTO;
import com.data.form.controller.FormController;
import com.data.form.exception.FormCollectionException;
import com.data.form.repository.FormRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FormServiceImpl implements FormService {

	@Autowired
	private FormRepo formRepo;
	
	@Override
	public void saveCAMForm(FormDTO form, String submissionId) throws FormCollectionException {
		log.info("Entering into [FormServiceImpl → saveCAMForm] for Submission Id {}", submissionId);
		if(submissionId!=null)
		{
			Optional<FormDTO> formOptional=formRepo.findById(submissionId);
			if(formOptional.isPresent()) {
				
				if(formOptional.get().isSubmitted())
				{
					throw new FormCollectionException(FormCollectionException.DataAlreadyPresentException()); 
				}
				else
				{
					form.setSubmissionId(submissionId);
					CommonDao.save(form);
				}
			}
			else
			{
				throw new FormCollectionException(FormCollectionException.ResourceNotFoundException(submissionId));
			}
		}
		else
		{
			CommonDao.save(form);
		}
	}

	@Override
	public void submitCAMForm(FormDTO form, String submissionId) throws FormCollectionException {
		log.info("Entering into [FormServiceImpl → submitCAMForm] for Submission Id {}", submissionId);
		if(submissionId!=null)
		{
			Optional<FormDTO> formOptional=formRepo.findById(submissionId);
			if(formOptional.isPresent())
			{
				if(formOptional.get().isSubmitted())
				{
					throw new FormCollectionException(FormCollectionException.DataAlreadyPresentException()); 
				}
				form.setSubmitted(true);
				CommonDao.save(form);
			}
			else
			{
				throw new FormCollectionException(FormCollectionException.ResourceNotFoundException(submissionId));
			}
		}
		else
		{
			form.setSubmitted(true);
			CommonDao.save(form);
		}
	}
	
	
}
