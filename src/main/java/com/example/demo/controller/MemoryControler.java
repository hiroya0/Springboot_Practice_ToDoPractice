package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathValiable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.Memory;
import com.example.demo.repository.MemoryRepository;

@RequiredArgsConstructor
@Controller
public class MemoryControler {
	
	private final MemoryRepository repository;
	
	@GetMapping("/")
	public String process(@Validated Memory memories, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		repository.save(memories);
		return "redirect:/";
	}
	
}
