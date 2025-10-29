import java.time.LocalDate;

/**
 * Class BenefitEligibleEmployee extends class PartTimeEmployee, stores more information about given
 * benefit eligible employee.
 */
public class BenefitEligibleEmployee extends PartTimeEmployee {

  /**
   * Constructor for class BenefitEligibleEmployee
   *
   * @param employeeID            - String, representing employee's ID
   * @param contactInfo           - ContactInfo, representing employee's contact info
   * @param employmentDate        - LocalDate, representing the day the employee started working
   * @param employmentLevel       - EmploymentLevel, representing employee's level
   * @param lastYearsEarnings     - Double, representing employee's earnings last year
   * @param contractualHours      - Double, representing employee's contractual hours
   * @param actualWorkedHours     - Double, representing employee's actual worked hours
   * @param bonusOvertimeEarnings - Double, representing employee's bonus and overtime earnings
   */
  public BenefitEligibleEmployee(String employeeID, ContactInfo contactInfo,
      LocalDate employmentDate, EmploymentLevel employmentLevel, Double lastYearsEarnings,
      Double contractualHours, Double actualWorkedHours, Double bonusOvertimeEarnings) {
    super(employeeID, contactInfo, employmentDate, employmentLevel, lastYearsEarnings,
        contractualHours, actualWorkedHours, bonusOvertimeEarnings);
  }

  public Double estimateProductivity() {
    return super.baseProductivity();
  }

  @Override
  public String toString() {
    return "BenefitEligibleEmployee{" +
        "contractualHours=" + contractualHours +
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
