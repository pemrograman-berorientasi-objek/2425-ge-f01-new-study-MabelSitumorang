package pbo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;


/**
 * Mabel Christoffel A.S - 12S23011
 * Amos Manurung - 12S23027
 *
 */


@Entity
@Table(name = "courses")
public class Course {
    
    @Id
    @Column(name = "kode", nullable = false)
    private String courseCode;
    
    @Column(name = "nama", nullable = false)
    private String courseName;
    
    @Column(name = "semester", nullable = false)
    private int courseSemester;
    
    @Column(name = "kredit", nullable = false)
    private int courseCredit;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enrollment> enrollmentList = new ArrayList<>();
    
    
    public Course(String courseCode, String courseName, int courseSemester, int courseCredit) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseSemester = courseSemester;
        this.courseCredit = courseCredit;
    }
   
    public String getCourseCode() {
        return courseCode;
    }
    

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    

    public String getCourseName() {
        return courseName;
    }
  
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public int getCourseSemester() {
        return courseSemester;
    }
    
    public void setCourseSemester(int courseSemester) {
        this.courseSemester = courseSemester;
    }
    

    public int getCourseCredit() {
        return courseCredit;
    }
  
    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }
    

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }
    
    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }
    
    public void addEnrollment(Enrollment enrollment) {
        enrollmentList.add(enrollment);
        enrollment.setEnrolledCourse(this); 
    }
    
    @Override
    public String toString() {
        return courseCode + "|" + courseName + "|" + courseSemester + "|" + courseCredit;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Course other = (Course) obj;
        return courseCode.equals(other.courseCode);
    }
    
    @Override
    public int hashCode() {
        return courseCode.hashCode();
    }
}