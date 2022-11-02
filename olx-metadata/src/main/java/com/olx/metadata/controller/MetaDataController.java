package com.olx.metadata.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.metadata.entity.Category;
import com.olx.metadata.entity.Status;

@RestController
@RequestMapping("/advertise")
public class MetaDataController {

//	/advertise/category
	List<Category> categories =  Stream.of(new Category(1,"shoes"), new Category(2,"gadgets")).collect(Collectors.toList());
	List<Status> statuses =  Stream.of(new Status(1,true), new Status(2,false)).collect(Collectors.toList());

	// get category
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getCategories(@PathVariable int id){
		//index starts with 0
		--id;
		return new ResponseEntity<Category>(categories.get(id),HttpStatus.OK);
	}
	
	//get status
	@GetMapping("/status/{id}")
	public ResponseEntity<?> getStatus(@PathVariable int id){
		--id;
		return new ResponseEntity<Status>(statuses.get(id),HttpStatus.OK);
	}
	
}
