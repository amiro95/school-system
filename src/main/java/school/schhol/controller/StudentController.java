package school.schhol.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.ribbon.proxy.annotation.Content;

import school.schhol.request.AddStudentRequest;
import school.schhol.request.UpdateStudentRequest;
import school.schhol.response.GetStudentResponse;
import school.schhol.response.MessageResponse;
import school.schhol.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<GetStudentResponse> getStudentByStudentId(@Content HttpServletResponse http,
			@RequestParam Integer studentId) throws Exception {

		return studentService.getStudent(studentId);

	}

	@RequestMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetStudentResponse> getStudentByCourseId(@Content HttpServletResponse http,
			@RequestParam Integer courseId) throws Exception {

		return studentService.getCourse(courseId);

	}

	@PostMapping
	public Object addStudent(@Content HttpServletResponse http, @Valid @RequestBody AddStudentRequest request)
			throws Exception {

		MessageResponse response = new MessageResponse();
		String message = "Student Added!";

		studentService.addStudent(request);
		response.setMessage(message);
		return response;

	}

	@PutMapping
	public Object updateStudent(@Content HttpServletResponse http, @Valid @RequestBody UpdateStudentRequest request)
			throws Exception {

		MessageResponse response = new MessageResponse();
		String message = "Student Updated!";

		studentService.updateStudent(request);
		response.setMessage(message);
		return response;

	}

	@Transactional
	@DeleteMapping(path = "/{studentId}")
	public Object deleteStudent(@Content HttpServletResponse http, @PathVariable Integer studentId) {

		MessageResponse response = new MessageResponse();
		String message = "Student Deleted!";

		studentService.deleteStudent(studentId);
		response.setMessage(message);

		return response;

	}

}
