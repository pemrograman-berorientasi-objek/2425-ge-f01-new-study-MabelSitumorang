package pbo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

/**
 * Mabel Christoffel A.S - 12S23011
 * Amos Manurung - 12S23027
 *
 */


@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @Column(name = "nim", nullable = false)
    private String studentId;
    
    @Column(name = "nama", nullable = false)
    private String fullName;
    
    @Column(name = "prodi", nullable = false)
    private String studyProgram;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "enrollments",
        joinColumns = @JoinColumn(name = "student_nim"),
        inverseJoinColumns = @JoinColumn(name = "course_code")
    )
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String studentId, String fullName, String studyProgram) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.studyProgram = studyProgram;
    }
    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public boolean enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return studentId + "|" + fullName + "|" + studyProgram;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        Student student = (Student) obj;
        return studentId.equals(student.studentId);
    }
    

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }
}