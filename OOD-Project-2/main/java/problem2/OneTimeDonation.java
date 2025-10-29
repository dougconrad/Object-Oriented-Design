package problem2;

import java.time.LocalDateTime;

public class OneTimeDonation extends Donation {

  /**
   * Constructor for class OneTimeDonation
   *
   * @param amount - Double, amount donated
   * @param date   - LocalDateTime, date donation was made
   * @param time   - LocalDateTime, time donation was made
   */
  public OneTimeDonation(Double amount, LocalDateTime date, LocalDateTime time) {
    super(amount, date, time);
  }

  public Double getTotalAmountForYear(int year) {
    if (this.date.getYear() == year) {
      return this.amount;
    }
    return 0.0;
  }
}
