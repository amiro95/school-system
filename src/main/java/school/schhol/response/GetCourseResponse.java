package school.schhol.response;

import java.util.List;

public class GetCourseResponse {

	
	private List<GetStudentResponse> response;

	/**
	 * @return the response
	 */
	public List<GetStudentResponse> getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(List<GetStudentResponse> response) {
		this.response = response;
	}

	/**
	 * @param response
	 */
	public GetCourseResponse(List<GetStudentResponse> response) {
		super();
		this.response = response;
	}

	public GetCourseResponse() {
		// TODO Auto-generated constructor stub
	}
	
	
}
