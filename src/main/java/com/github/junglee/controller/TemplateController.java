package com.github.junglee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.junglee.domain.Template;
import com.github.junglee.domain.TemplateDto;
import com.github.junglee.jpa.TemplateService;

@RestController
@RequestMapping(value = "/fmg/template")
public class TemplateController
{
	@Autowired
	TemplateService service;
	
	@GetMapping(value = "/getAllTemplates", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Template> getAllTemps(){
		return service.getAllTemps();
	}
	
	@PostMapping(value = "/createTemplates", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public List<Template> createTemplates(@RequestBody TemplateDto dto){
		return service.createTemplates(dto);
	}
	
	@GetMapping(value = "/getTemplate/{tempId}", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Template getTemplatebyId(@PathVariable("tempId") long tempId){
		return service.getTemplateById( tempId );
	}
	
	@GetMapping(value = "/getTemplateId", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Long getTempIdByCriteria(@RequestParam int prizeType, @RequestParam int size, @RequestParam int format,@RequestParam int entryFee){
		return service.getTempIdByCriteria( prizeType, size, format, entryFee);
	}
}
