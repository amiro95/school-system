package school.schhol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import school.schhol.dto.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByStudentId(Integer studentId);
	
	List<Student> findByCourseId(Integer studentId);
}