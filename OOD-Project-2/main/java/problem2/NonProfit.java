package problem2;

import java.util.ArrayList;

public class NonProfit {

  public String name;
  public ArrayList<Donation> donations;

  /**
   * Constructor for class NonProfit
   *
   * @param name - String, name of the NonProfit
   */
  public NonProfit(String name) {
    this.name = name;
  }

  public Double getTotalDonationsForYear(int year) {
    Double totalAmount = 0.0;
    for (Donation donation : donations) {
      totalAmount += donation.getTotalAmountForYear(year);
    }
    return totalAmount;
  }
}
