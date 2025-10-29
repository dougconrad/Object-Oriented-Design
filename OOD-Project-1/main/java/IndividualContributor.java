import java.time.LocalDate;
import java.util.Objects;

/**
 * Class IndividualContributor extends class FullTimeEmployee, stores more information about given
 * individual contributor.
 */
public class IndividualContributor extends FullTimeEmployee {

  private Integer numPatents;
  private Integer numPublications;
  private Integer numExternalCollabs;

  private static final Double INDIVIDUAL_CONTRIBUTOR_BONUS = 1.3;
  private static final Integer INDIVIDUAL_CONTRIBUTOR_BONUS_THRESHOLD = 4;

  /**
   * Constructor for class FullTimeEmployee
   *
   * @param employeeID         - String, representing employee's ID
   * @param contactInfo        - ContactInfo, representing employee's contact info
   * @param employmentDate     - LocalDate, representing the day the employee started working
   * @param employmentLevel    - EmploymentLevel, representing employee's level
   * @param lastYearsEarnings  - Double, representing employee's earnings last year
   * @param basePay            - Double, representing employee's base pay
   * @param bonuses            - Double, representing employee's earnings from bonuses
   * @param overtime           - Double, representing employee's earnings from overtime
   * @param lastPromotionDate  - LocalDate, representing employee's last promotion date
   * @param numProjects        - Integer, representing employee's number of projects
   * @param numPatents         - Integer, representing employee's number of patents
   * @param numPublications    - Integer, representing employee's number of publications
   * @param numExternalCollabs - Integer, representing employee's number of external collaborations
   */
  public IndividualContributor(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EmploymentLevel employmentLevel, Double lastYearsEarnings,
      Double basePay, Double bonuses, Double overtime, LocalDate lastPromotionDate,
      Integer numProjects, Integer numPatents, Integer numPublications,
      Integer numExternalCollabs) {
    super(employeeID, contactInfo, employmentDate, employmentLevel, lastYearsEarnings, basePay,
        bonuses, overtime, lastPromotionDate, numProjects);
    this.numPatents = numPatents;
    this.numPublications = numPublications;
    this.numExternalCollabs = numExternalCollabs;
  }

  public Double estimateProductivity() {
    double productivity = super.baseProductivity();
    if (numPublications > INDIVIDUAL_CONTRIBUTOR_BONUS_THRESHOLD) {
      productivity += INDIVIDUAL_CONTRIBUTOR_BONUS;
    }
    return productivity;
  }

  /**
   * @return - Integer, gives employee's number of patents
   */
  public Integer getNumPatents() {
    return numPatents;
  }

  /**
   * @return - Integer, gives employee's number of publications
   */
  public Integer getNumPublications() {
    return numPublications;
  }

  /**
   * @return - Integer, gives employee's number of external collaborations
   */
  public Integer getNumExternalCollabs() {
    return numExternalCollabs;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndividualContributor that = (IndividualContributor) o;
    return Objects.equals(numPatents, that.numPatents) && Objects.equals(
        numPublications, that.numPublications) && Objects.equals(numExternalCollabs,
        that.numExternalCollabs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numPatents, numPublications, numExternalCollabs);
  }

  @Override
  public String toString() {
    return "IndividualContributor{" +
        "numPatents=" + numPatents +
        ", numPublications=" + numPublications +
        ", numExternalCollabs=" + numExternalCollabs +
        ", basePay=" + basePay +
        ", bonuses=" + bonuses +
        ", overtime=" + overtime +
        ", lastPromotionDate=" + lastPromotionDate +
        ", numProjects=" + numProjects +
        ", employeeID='" + employeeID + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", employmentLevel=" + employmentLevel +
        ", lastYearsEarnings=" + lastYearsEarnings +
        '}';
  }
}
