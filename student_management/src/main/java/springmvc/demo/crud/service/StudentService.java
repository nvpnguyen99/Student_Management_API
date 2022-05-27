package springmvc.demo.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.demo.crud.entity.Student;
import springmvc.demo.crud.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Optional<Student> findById(int id) {
		return studentRepository.findById(id);
	}
	
	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}
}
