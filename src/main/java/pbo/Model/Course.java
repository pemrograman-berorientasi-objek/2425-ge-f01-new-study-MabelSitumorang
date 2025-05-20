package pbo.model;

import java.util.*;
import javax.persistence.*;

/**
 * Mabel Christoffel A.S - 12S23011
 * Amos Manurung - 12S23027
 *
 */
@Entity
@Table(name = "Course")
public class Course {
  @Id
  @Column(name = "idCourse", nullable = false, length = 100)
  private String idCourse;

  @Column(name = "courseName", nullable = false, length = 100)
  private String courseName;

  @Column(name = "semester", nullable = false, length = 100)
  private String semester;

  @Column(name = "kredit", nullable = false, length = 100)
  private String kredit;

  public Course() {
  }

  public Course(String idCourse, String courseName, String semester, String kredit) {
    this.idCourse = idCourse;
    this.courseName = courseName;
    this.semester = semester;
    this.kredit = kredit;
  }

  public String getIdCourse() {
    return this.idCourse;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public String getSemester() {
    return this.semester;
  }

  public String getKredit() {
    return this.kredit;
  }
}