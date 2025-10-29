package problem2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MonthlyDonation extends Donation {

  public LocalDateTime cancelDate;
  public LocalDateTime cancelTime;

  /**
   * Constructor for class MonthlyDonation
   *
   * @param amount - Double, amount donated
   * @param date   - LocalDateTime, date donation was made
   * @param time   - LocalDateTime, time donation was made
   */
  public MonthlyDonation(Double amount, LocalDateTime date, LocalDateTime time) {
    super(amount, date, time);
  }

  /**
   * Sets cancel date
   *
   * @param cancelDate - LocalDateTime, date monthly donation ends
   */
  public void setCancelDate(LocalDateTime cancelDate) {
    this.cancelDate = cancelDate;
  }

  /**
   * Sets cancel time
   *
   * @param cancelTime - LocalDateTime, time monthly donation ends
   */
  public void setCancelTime(LocalDateTime cancelTime) {
    this.cancelTime = cancelTime;
  }

  public Double getTotalAmountForYear(int year) {
    LocalDateTime localDateTime = LocalDateTime.of(year, 12, 31, 23, 59, 59);
    localDateTime.minusMonths(this.date.getMonthValue());
    Integer months = localDateTime.getMonthValue();
    return amount * months;
  }

}
