import java.time.LocalDate;
import java.util.Objects;

/**
 * Class Hourly extends class PartTimeEmployee, stores more information about given hourly
 * employee.
 */
public class HourlyEmployee extends PartTimeEmployee {

  private Double hourlyRate;

  private static final Integer HOURLY_RATE_BONUS = 3;
  private static final Double HOURLY_RATE_BONUS_THRESHOLD = 14.0;

  /**
   * Constructor for class HourlyEmployee
   *
   * @param employeeID            - String, representing employee's ID
   * @param contactInfo           - ContactInfo, representing employee's contact info
   * @param employmentDate        - LocalDate, representing the day the employee started working
   * @param employmentLevel       - EmploymentLevel, representing employee's level
   * @param lastYearsEarnings     - Double, representing employee's earnings last year
   * @param contractualHours      - Double, representing employee's contractual hours
   * @param actualWorkedHours     - Double, representing employee's actual worked hours
   * @param bonusOvertimeEarnings - Double, representing employee's bonus and overtime earnings
   * @param hourlyRate            - Double, representing employee's hourly rate
   */
  public HourlyEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EmploymentLevel employmentLevel, Double lastYearsEarnings,
      Double contractualHours, Double actualWorkedHours, Double bonusOvertimeEarnings,
      Double hourlyRate) {
    super(employeeID, contactInfo, employmentDate, employmentLevel, lastYearsEarnings,
        contractualHours, actualWorkedHours, bonusOvertimeEarnings);
    this.hourlyRate = hourlyRate;
  }

  public Double estimateProductivity() {
    double productivity = super.baseProductivity();
    if (hourlyRate < HOURLY_RATE_BONUS_THRESHOLD) {
      productivity += HOURLY_RATE_BONUS;
    }
    return productivity;
  }

  /**
   * @return - Double, gives employee's hourly rate
   */
  public Double getHourlyRate() {
    return hourlyRate;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HourlyEmployee that = (HourlyEmployee) o;
    return Objects.equals(hourlyRate, that.hourlyRate);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(hourlyRate);
  }

  @Override
  public String toString() {
    return "HourlyEmployee{" +
        "hourlyRate=" + hourlyRate +
        ", contractualHours=" + contractualHours +
        ", actualWorkedHours=" + actualWorkedHours +
        ", bonusOvertimeEarnings=" + bonusOvertimeEarnings +
        ", employeeID='" + employeeID + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", employmentLevel=" + employmentLevel +
        ", lastYearsEarnings=" + lastYearsEarnings +
        '}';
  }
}
