package course.codejava.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String courseName;
  public String courseCode;
  public String prerequisite;
  public String courseCredit;

  protected Course() {
  }

  protected Course(String coursename, String coursecode, String prerequisite, String coursecredit) {
    this.courseName = coursename;
    this.courseCode = coursecode;
    this.prerequisite = prerequisite;
    this.courseCredit = coursecredit;
  }

  protected Course(Long id, String coursename, String coursecode, String prerequisite, String coursecredit) {
    this.id = id;
    this.courseName = coursename;
    this.courseCode = coursecode;
    this.prerequisite = prerequisite;
    this.courseCredit = coursecredit;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String coursename) {
    this.courseName = coursename;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String coursecode) {
    this.courseCode = coursecode;
  }

  public String getPrerequisite() {
    return prerequisite;
  }

  public void setPrerequisite(String prerequisite) {
    this.prerequisite = prerequisite;
  }

  public String getCourseCredit() {
    return courseCredit;
  }

  public void setCourseCredit(String coursecredit) {
    this.courseCredit = coursecredit;
  }


}
