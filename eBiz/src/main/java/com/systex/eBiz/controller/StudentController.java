package com.systex.eBiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.systex.eBiz.model.Student;
import com.systex.eBiz.model.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/student")
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student student, Model model) {
		this.studentRepository.save(student);
		model.addAttribute("student", student);
		return "result";
	}
	
	@GetMapping("/listStudent")
	public String getAll(Model model) {
		List<Student> allStudents =  this.studentRepository.findAll();
		model.addAttribute("students", allStudents);
		return "listStudents";
	}
	
	@GetMapping("/updateStudent/{id}")
	public ModelAndView updateStudentForm(@PathVariable("id") int id) {
		Optional<Student> result =  this.studentRepository.findById(id);
		Student student = null;
		if(result.isPresent()) {
			student = result.get();
		} else {
			throw new RuntimeException("Cannot find student for id = " + id);
		}
		return new ModelAndView("updateStudentForm", "command", student);
	}
	
	@PostMapping("/updateStudent")
	public String updateStudent(@ModelAttribute Student student) {
		this.studentRepository.save(student);
		return "redirect:/listStudent";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		Optional<Student> result = this.studentRepository.findById(id);
		if(result.isPresent()) {
			this.studentRepository.deleteById(id);
		} else {
			throw new RuntimeException("Cannot find student for id = " + id);
		}
		return "redirect:/listStudent";
	}
	
	
	
	
	
	
	
}
