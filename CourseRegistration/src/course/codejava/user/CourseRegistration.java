package course.codejava.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CourseRegistration {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public Long courseId;
  public Long studentId;
  public Double mark;
  public Date registrationDate;

  @Transient
  public String courseName;

  @Transient
  public String courseCode;

  @Transient
  public String courseCredit;

  public String getCourseCredit() {
    return courseCredit;
  }

  public void setCourseCredit(String courseCredit) {
    this.courseCredit = courseCredit;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }




  public String getCourseCode() {
    return courseCode;
  }

  public void setCourseCode(String courseCode) {
    this.courseCode = courseCode;
  }

  protected CourseRegistration() {
  }

  protected CourseRegistration(Long courseId, Long studentId, Date registrationDate) {
    this.courseId = courseId;
    this.studentId = studentId;
    this.registrationDate = registrationDate;
  }

  protected CourseRegistration(Long courseId, Long studentId, Double mark, Date registrationDate) {
    this.courseId = courseId;
    this.mark = mark;
    this.studentId = studentId;
    this.registrationDate = registrationDate;
  }

  protected CourseRegistration(Long id, Long courseId, Long studentId, Double mark, Date registrationDate) {
    this.id = id;
    this.courseId = courseId;
    this.mark = mark;
    this.studentId = studentId;
    this.registrationDate = registrationDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public Double getMark() {
    return mark;
  }

  public void setMark(Double mark) {
    this.mark = mark;
  }

  public Date getRegistrationDate() {
    return registrationDate;
  }

  public void setRegistrationDate(Date date) {
    this.registrationDate = date;
  }




}
