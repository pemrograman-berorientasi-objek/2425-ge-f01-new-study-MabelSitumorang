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
            String perintah = tokens[0];

            switch (perintah) {
                case "student-add":
                    String idMahasiswa = tokens[1];
                    String namaMahasiswa = tokens[2];
                    String programStudi = tokens[3];

                    if (!studentMap.containsKey(idMahasiswa)) {
                        studentMap.put(idMahasiswa, new Student(idMahasiswa, namaMahasiswa, programStudi));
                    }
                    break;

                case "student-show-all":
                    for (Student mhs : studentMap.values()) {
                        System.out.println(mhs.getNim() + "|" + mhs.getNama() + "|" + mhs.getProdi());
                    }
                    break;

                case "course-add":
                    String kodeMatkul = tokens[1];
                    String namaMatkul = tokens[2];
                    int semesterMatkul = Integer.parseInt(tokens[3]);
                    int jumlahKredit = Integer.parseInt(tokens[4]);

                    if (!courseMap.containsKey(kodeMatkul)) {
                        courseMap.put(kodeMatkul, new Course(kodeMatkul, namaMatkul, semesterMatkul, jumlahKredit));
                    }
                    break;

                case "course-show-all":
                    for (Course matkul : courseMap.values()) {
                        System.out.println(matkul.getKode() + "|" + matkul.getNama() + "|" + matkul.getSemester() + "|" + matkul.getKredit());
                    }
                    break;

                case "enroll":
                    String nimEnroll = tokens[1];
                    String kodeEnroll = tokens[2];
                    Student mahasiswaEnroll = studentMap.get(nimEnroll);
                    Course matkulEnroll = courseMap.get(kodeEnroll);

                    if (mahasiswaEnroll != null && matkulEnroll != null) {
                        boolean sudahTerdaftar = false;
                        for (Enrollment daftar : enrollmentList) {
                            if (daftar.getStudent().getNim().equals(nimEnroll) &&
                                daftar.getCourse().getKode().equals(kodeEnroll)) {
                                sudahTerdaftar = true;
                                break;
                            }
                        }
                        if (!sudahTerdaftar) {
                            enrollmentList.add(new Enrollment(mahasiswaEnroll, matkulEnroll));
                        }
                    }
                    break;

                case "student-show":
                    String nimTarget = tokens[1];
                    Student mahasiswaTarget = studentMap.get(nimTarget);
                    if (mahasiswaTarget != null) {
                        System.out.println(mahasiswaTarget.getNim() + "|" + mahasiswaTarget.getNama() + "|" + mahasiswaTarget.getProdi());

                        List<Course> daftarMatkul = new ArrayList<>();
                        for (Enrollment daftar : enrollmentList) {
                            if (daftar.getStudent().getNim().equals(nimTarget)) {
                                Course c = daftar.getCourse();
                                if (c != null) {
                                    daftarMatkul.add(c);
                                }
                            }
                        }

                        daftarMatkul.sort(Comparator.comparing(Course::getKode));

                        for (Course c : daftarMatkul) {
                            System.out.println(c.getKode() + "|" + c.getNama() + "|" + c.getSemester() + "|" + c.getKredit());
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