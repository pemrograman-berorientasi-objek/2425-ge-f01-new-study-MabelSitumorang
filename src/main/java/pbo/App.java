package pbo;

import java.util.*;

import pbo.model.Course;
import pbo.model.Enrollment;
import pbo.model.Student;

/**
 * Mabel Christoffel A.S - 12S23011
 * Amos Manurung - 12S23027
 *
 */


public class App {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        Map<String, Student> studentMap = new TreeMap<>();
        Map<String, Course> courseMap = new TreeMap<>();
        List<Enrollment> enrollmentList = new ArrayList<>();

        while (inputScanner.hasNextLine()) {
            String inputLine = inputScanner.nextLine().trim();
            if (inputLine.equals("---")) break;

            String[] tokens = inputLine.split("#");
            String action = tokens[0];

            switch (action) {
                case "student-add":
                    String studentId = tokens[1];
                    String fullName = tokens[2];
                    String studyProgram = tokens[3];

                    if (!studentMap.containsKey(studentId)) {
                        studentMap.put(studentId, new Student(studentId, fullName, studyProgram));
                    }
                    break;

                case "student-show-all":
                    for (Student s : studentMap.values()) {
                        System.out.println(s.getStudentId() + "|" + s.getFullName() + "|" + s.getStudyProgram());
                    }
                    break;

                case "course-add":
                    String courseCode = tokens[1];
                    String courseName = tokens[2];
                    int courseSemester = Integer.parseInt(tokens[3]);
                    int courseCredit = Integer.parseInt(tokens[4]);

                    if (!courseMap.containsKey(courseCode)) {
                        courseMap.put(courseCode, new Course(courseCode, courseName, courseSemester, courseCredit));
                    }
                    break;

                case "course-show-all":
                    for (Course c : courseMap.values()) {
                        System.out.println(c.getCourseCode() + "|" + c.getCourseName() + "|" + c.getCourseSemester() + "|" + c.getCourseCredit());
                    }
                    break;

                case "enroll":
                    String enrollStudentId = tokens[1];
                    String enrollCourseCode = tokens[2];
                    Student enrollStudent = studentMap.get(enrollStudentId);
                    Course enrollCourse = courseMap.get(enrollCourseCode);

                    if (enrollStudent != null && enrollCourse != null) {
                        boolean alreadyEnrolled = false;
                        for (Enrollment e : enrollmentList) {
                            if (e.getEnrolledStudent().getStudentId().equals(enrollStudentId) &&
                                e.getEnrolledCourse().getCourseCode().equals(enrollCourseCode)) {
                                alreadyEnrolled = true;
                                break;
                            }
                        }
                        if (!alreadyEnrolled) {
                            enrollmentList.add(new Enrollment(enrollStudent, enrollCourse));
                        }
                    }
                    break;

                case "student-show":
                    String showStudentId = tokens[1];
                    Student showStudent = studentMap.get(showStudentId);
                    if (showStudent != null) {
                        System.out.println(showStudent.getStudentId() + "|" + showStudent.getFullName() + "|" + showStudent.getStudyProgram());

                        List<Course> studentCourses = new ArrayList<>();
                        for (Enrollment e : enrollmentList) {
                            if (e.getEnrolledStudent().getStudentId().equals(showStudentId)) {
                                Course c = e.getEnrolledCourse();
                                if (c != null) {
                                    studentCourses.add(c);
                                }
                            }
                        }

                        studentCourses.sort(Comparator.comparing(Course::getCourseCode));

                        for (Course c : studentCourses) {
                            System.out.println(c.getCourseCode() + "|" + c.getCourseName() + "|" + c.getCourseSemester() + "|" + c.getCourseCredit());
                        }
                    }
                    break;

                default:
                    break;
            }
        }
        inputScanner.close();
    }
}