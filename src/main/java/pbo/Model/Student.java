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
    private String idSiswa;
    
    @Column(name = "nama", nullable = false)
    private String namaLengkap;
    
    @Column(name = "prodi", nullable = false)
    private String jurusan;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "enrollments",
        joinColumns = @JoinColumn(name = "student_nim"),
        inverseJoinColumns = @JoinColumn(name = "course_code")
    )
    private List<Course> daftarMatkul = new ArrayList<>();

    public Student(String idSiswa, String namaLengkap, String jurusan) {
        this.idSiswa = idSiswa;
        this.namaLengkap = namaLengkap;
        this.jurusan = jurusan;
    }
    
    public String getNim() {
        return idSiswa;
    }

    public void setNim(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNama() {
        return namaLengkap;
    }

    public void setNama(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getProdi() {
        return jurusan;
    }

    public void setProdi(String jurusan) {
        this.jurusan = jurusan;
    }

    public List<Course> getCourses() {
        return daftarMatkul;
    }

    public void setCourses(List<Course> daftarMatkul) {
        this.daftarMatkul = daftarMatkul;
    }

    public boolean enrollCourse(Course matkul) {
        if (!daftarMatkul.contains(matkul)) {
            daftarMatkul.add(matkul);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return idSiswa + "|" + namaLengkap + "|" + jurusan;
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
        return idSiswa.equals(student.idSiswa);
    }
    

    @Override
    public int hashCode() {
        return idSiswa.hashCode();
    }
}