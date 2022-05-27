package springmvc.demo.crud.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springmvc.demo.crud.entity.Student;
import springmvc.demo.crud.service.StudentService;

@RestController
public class StudentRestController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/student/{id}")
	public Object findById(@PathVariable int id) {
		Optional<Student> student = studentService.findById(id);
	if(student.isPresent()) {
		return student.get();
	}
	
	Map<String, String> obj = new HashMap<String, String>();
	obj.put("message", "student not found!");
	return obj;
	}
	
	@PostMapping("/student")
	public Object insertStudent(@RequestBody Student student) {
		Map<String, String> obj = new HashMap<String, String>();
		try {
		studentService.save(student);
		obj.put("message", "Insert successfully!");
		} catch (Exception e) {
			obj.put("message", "Insert not successfully!");
		}
	return obj;
	}
	
	@PutMapping("/student")
	public Object updateStudent(@RequestBody Student student) {
		Map<String, String> obj = new HashMap<String, String>();
		try {
			Optional<Student> studentDB = studentService.findById(student.getId());
			if(studentDB.isPresent()) {
				obj.put("message", "Update successfully!");
				studentService.save(student);	
			} else {
				obj.put("message", "student not found!");
			}
		} catch (Exception e) {
			obj.put("message", "Update not successfully!");
		}
	return obj;
	}
	
	@DeleteMapping("/student/{id}")
	public Object deleteById(@PathVariable int id) {
		Map<String, String> obj = new HashMap<String, String>();
		Optional<Student> student = studentService.findById(id);
	if(student.isPresent()) {
		studentService.deleteById(id);
		obj.put("message", "Delete Successfully");
	} else {
		obj.put("message", "student not found!");
	}
	return obj;
	}
}

