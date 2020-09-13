package school.schhol.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import school.schhol.dto.Student;
import school.schhol.repository.StudentRepository;
import school.schhol.request.AddStudentRequest;
import school.schhol.request.UpdateStudentRequest;
import school.schhol.response.GetCourseResponse;
import school.schhol.response.GetStudentResponse;

@Transactional
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@PersistenceContext
	EntityManager entity;

	public void addStudent(AddStudentRequest request) throws Exception {

		Student student = new Student();
		student.setStudentName(request.getStudentName());
		student.setCourseId(request.getCourseId());
		student.setCourseName(request.getCourseName());
		studentRepository.save(student);

	}

	public ResponseEntity<GetStudentResponse> getStudent(Integer studentId) throws Exception {

		Student studentInfo = studentRepository.findByStudentId(studentId);
		if(studentInfo != null ) {
			GetStudentResponse response = new GetStudentResponse();
			response.setStudentId(studentInfo.getStudentId());
			response.setStudentName(studentInfo.getStudentName());
			response.setCourseId(studentInfo.getCourseId());
			response.setCourseName(studentInfo.getCourseName());

			return new ResponseEntity(response, HttpStatus.OK);
		} else {
			throw new Exception("Record not found!");
		}


	}

	public void updateStudent(UpdateStudentRequest request) throws Exception {

		Student student = new Student();
		student.setStudentId(request.getStudentId());
		student.setStudentName(request.getStudentName());
		student.setCourseId(request.getCourseId());
		student.setCourseName(request.getCourseName());

		studentRepository.save(student);

	}

	public void deleteStudent(Integer studentId) {

		// Find managed Entity reference
		Student book = entity.find(Student.class, studentId);

		// Call remove method to remove the entity
		entity.remove(book);

	}

	public ResponseEntity<GetStudentResponse> getCourse(Integer courseId) throws Exception {

		List<Student> studentInfo = studentRepository.findByCourseId(courseId);
		GetCourseResponse response = new GetCourseResponse();

		List<GetStudentResponse> responseList = new ArrayList<GetStudentResponse>();
		if (studentInfo != null) {
			for (Student temp : studentInfo) {
				GetStudentResponse list = new GetStudentResponse();
				list.setStudentId(temp.getStudentId());
				list.setStudentName(temp.getStudentName());
				list.setCourseId(temp.getCourseId());
				list.setCourseName(temp.getCourseName());
				responseList.add(list);
			}

		} else {
			throw new Exception("Record not found!");
		}
		response.setResponse(responseList);

		return new ResponseEntity(response, HttpStatus.OK);

	}

}