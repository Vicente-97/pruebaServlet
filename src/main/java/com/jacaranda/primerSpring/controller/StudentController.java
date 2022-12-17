package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Calculator;
import com.jacaranda.primerSpring.model.Student;
import com.jacaranda.primerSpring.service.StudentService;

@Controller
public class StudentController {

	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	StudentService repositorio;

	/**ç
	 * Metodo get que devuelve los estudiantes.
	 * @param modelo
	 * @return
	 */
	@GetMapping("/listStudents")
	public String listStudent(Model modelo) {
		
		modelo.addAttribute("lista", repositorio.getListStudent());
		return "listStudents";
	}
	
	/**
	 * Método get que instancia un estudiante y lo mapea con una template, "addStudent.html"
	 * 
	 * @param modelo
	 * @return
	 */
	@GetMapping("AddStudent")
	public String listStudentAdd(Model modelo) {
		
		Student student= new Student();
		
		modelo.addAttribute("student", student );
		return "addStudent";
	}
	
	/**
	 * Recoje el objeto student que hemos instanciado antes y le hemos dado valores en la template
	 * llamamos al service y añadimos ese objeto a la lista. Por ultimo redirijimos a la lista Estudiantes
	 * @param student
	 * @return
	 */
	@PostMapping("/listStudents/AddSubmit")
	public String listStudentsAddMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.addStudent(student);
			
		return "redirect:/listStudents";
	}
	
	
	@GetMapping("/delStudent")
	public String delStudent(Model model, @RequestParam(name="name", required=false, defaultValue="") String name,
			@RequestParam(name="surname", required=false, defaultValue="")String surname) {
		
		
		Student estudiante = repositorio.getStudent(name, surname);
		model.addAttribute("student", estudiante);
		return "delStudent";
	}
	
	@PostMapping("/delStudent/delSubmit")
	public String listStudentsdelMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.removeStudent(student);
			
		return "redirect:/listStudents";
	}
	
	@GetMapping("/editStudent")
	public String editStudent(Model model, @RequestParam(name="name", required=false, defaultValue="")String name,
			@RequestParam(name="surname", required=false, defaultValue="")String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		model.addAttribute("student", estudiante);
		
		return "editStudent";
	}
	
	@PostMapping("/editStudent/Submit")
	public String listStudentseditMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.updateStudent(student.getName(), student.getSurname(), student.getAge());
			
		return "redirect:/listStudents";
	}
	
}
