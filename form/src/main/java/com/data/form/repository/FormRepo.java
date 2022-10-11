package com.data.form.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.data.form.DTO.FormDTO;

@Repository
public interface FormRepo extends MongoRepository<FormDTO,String> {

}
