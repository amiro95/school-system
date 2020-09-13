package school.schhol.request;

public class AddStudentRequest {

	private String studentName;

	private Integer courseId;
	
	private String courseName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @param studentName
	 * @param courseId
	 * @param courseName
	 */
	public AddStudentRequest(String studentName, Integer courseId, String courseName) {
		super();
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
	}

}
