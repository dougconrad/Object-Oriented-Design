package problem2;

import java.time.LocalDateTime;

public abstract class Donation {

  public Double amount;
  public LocalDateTime date;
  public LocalDateTime time;

  /**
   * Constructor for class Donation
   *
   * @param amount - Double, amount donated
   * @param date   - LocalDateTime, date donation was made
   * @param time   - LocalDateTime, time donation was made
   */
  public Donation(Double amount, LocalDateTime date, LocalDateTime time) {
    this.amount = amount;
    this.date = date;
    this.time = time;
  }

  /**
   * Gives total amount of money made from donations for given year
   *
   * @param year - int, year of donations
   * @return - Double, total amount made from donations for given year
   */
  public abstract Double getTotalAmountForYear(int year);

}
