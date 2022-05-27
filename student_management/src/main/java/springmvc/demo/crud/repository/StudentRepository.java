package springmvc.demo.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import springmvc.demo.crud.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
