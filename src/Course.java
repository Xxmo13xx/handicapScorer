
public class Course {
	private String courseName;
	private int courseSlope;
	private double courseRating;
	
	
	public Course(String nameOfCourse, int slopeOfCourse, double ratingOfCourse ){
		courseName = nameOfCourse;
		courseSlope = slopeOfCourse;
		courseRating = ratingOfCourse;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseSlope() {
		return courseSlope;
	}

	public void setCourseSlope(int courseSlope) {
		this.courseSlope = courseSlope;
	}

	public double getCourseRating() {
		return courseRating;
	}

	public void setCourseRating(float courseRating) {
		this.courseRating = courseRating;
	}
	

}
