package pbo.model;
import javax.persistence.*;
import java.util.*;
/**
 * Mabel Christoffel A.S - 12S23011
 * Amos Manurung - 12S23027
 *
 */

@Entity
@Table(name = "Enroll")
public class Enroll {

  @Id
  @Column(name = "ide", nullable = false, length = 100)
  public int ide;

  @Column(name = "NIMM", nullable = false, length = 100)
  public String NIMM;

  @Column(name = "idCoursee", nullable = false, length = 100)
  public String idCoursee;

  public Enroll() {
  }

  public Enroll(int ide, String NIMM, String idCoursee) {
    this.ide = ide;
    this.NIMM = NIMM;
    this.idCoursee = idCoursee;
  }

  public String getIdCoursee() {
    return this.idCoursee;
  }

  public String getNIMM() {
    return this.NIMM;
  }

  public int getide() {
    return this.ide;
  }
}