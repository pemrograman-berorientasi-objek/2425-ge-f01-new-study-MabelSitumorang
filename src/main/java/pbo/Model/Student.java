package pbo;
package pbo.model;
import java.util.*;
import javax.persistence.*;

/**
 * Mabel Christoffel A.S - 12S23011
 * Amos Manurung - 12S23027
 *
 */

@Entity
@Table(name = "Student")
public class Student {

  @Id
  @Column(name = "NIM", nullable = false, length = 100)
  private String NIM;

  @Column(name = "nama", nullable = false, length = 100)
  private String nama;

  @Column(name = "prodi", nullable = false, length = 100)
  private String prodi;

  public Student() {
  }

  public Student(String NIM, String nama, String prodi) {
    this.NIM = NIM;
    this.nama = nama;
    this.prodi = prodi;
  }

  public String getNama() {
    return this.nama;
  }

  public String getNIM() {
    return this.NIM;
  }

  public String getProdi() {
    return this.prodi;
  }
}