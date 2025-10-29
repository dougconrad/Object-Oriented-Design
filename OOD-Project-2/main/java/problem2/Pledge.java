package problem2;

import java.time.LocalDateTime;

public class Pledge extends Donation {

  public LocalDateTime fulfillmentDate;
  public LocalDateTime fulfillmentTime;

  /**
   * Constructor for class Pledge
   *
   * @param amount - Double, amount donated
   * @param date   - LocalDateTime, date donation was made
   * @param time   - LocalDateTime, time donation was made
   */
  public Pledge(Double amount, LocalDateTime date, LocalDateTime time) {
    super(amount, date, time);
  }

  /**
   * Sets fulfillment date for pledge
   *
   * @param fulfillmentDate - LocalDateTime, date pledge will be fulfilled
   */
  public void setFulfillmentDate(LocalDateTime fulfillmentDate) {
    this.fulfillmentDate = fulfillmentDate;
  }

  /**
   * Sets fulfillment time for pledge
   *
   * @param fulfillmentTime - LocalDateTime, time pledge will be fulfilled
   */
  public void setFulfillmentTime(LocalDateTime fulfillmentTime) {
    this.fulfillmentTime = fulfillmentTime;
  }

  public Double getTotalAmountForYear(int year) {
    if (this.fulfillmentDate.getYear() == year) {
      return this.amount;
    }
    return 0.0;
  }
}
