package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathValiable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RequiredArgsConstructor
@Controller
public class EmployeeController {
	
	private final EmployeeRepository repository;
	
	@GetMapping("/")
	public String snowform(Model model) {
		model.addAttribute("memories",repository.findAll());
	return "form";
	}
	
	
}
