package com.github.junglee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.junglee.domain.Template;
import com.github.junglee.jpa.TemplateService;

@RestController
@RequestMapping(value = "/fmg/template")
public class TemplateController
{
	@Autowired
	TemplateService service;
	
	@GetMapping(value = "/getAllTemplates", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Template> getAllTemp(){
		service.createTemplates();
		return null;
	}

}
