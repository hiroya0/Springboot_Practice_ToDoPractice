package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

import com.example.demo.model.Employee;
import com.example.demo.model.Memory;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.MemoryRepository;

@RequiredArgsConstructor
@Controller
public class TodoController {
	
	private final EmployeeRepository employeerepository;
	private final MemoryRepository memoryrepository;
	
	@GetMapping("/")
	public String snowform(Model model) {
		model.addAttribute("employees", employeerepository.findAll());
		model.addAttribute("memories",memoryrepository.findAll());
	return "index";
	}
	
	@GetMapping("/add")
	public String addform(Employee employee, Memory memory) {
		return "form";
	}
	
	@PostMapping("/")
	public String process(@Validated Memory memory,Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		
		employeerepository.save(employee);//社員から保存
		memory.setEmployee(employee);//社員とメモリー紐付け
		memoryrepository.save(memory);//メモリー保存
		
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deletelist(@PathVariable Long id) {
		employeerepository.deleteById(id);
		return "redirect:/";
	}
}
