package pbo.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Mabel Christoffel A.S - 12S23011
 * Amos Manurung - 12S23027
 *
 */


@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "student_nim", referencedColumnName = "nim")
    private Student enrolledStudent;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "kode")
    private Course enrolledCourse;

    public Enrollment() {
    }

    public Enrollment(Student enrolledStudent, Course enrolledCourse) {
        this.enrolledStudent = enrolledStudent;
        this.enrolledCourse = enrolledCourse;
    }

    public Student getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(Student enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }

    public Course getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(Course enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Enrollment that = (Enrollment) obj;
        return enrolledStudent.equals(that.enrolledStudent) && enrolledCourse.equals(that.enrolledCourse);
    }
    
    @Override
    public int hashCode() {
        return 31 * enrolledStudent.hashCode() + enrolledCourse.hashCode();
    }
}