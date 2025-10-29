/**
 * The type Sale.
 */
public class Sale extends Contract {

  /**
   * Instantiates a new Sale.
   *
   * @param askingPrice  the asking price, as a Double
   * @param isNegotiable flag for whether contract is negotiable, as a Boolean
   */
  public Sale(Double askingPrice, Boolean isNegotiable) {
    super(askingPrice, isNegotiable);
  }

  public double getEarnings(Agent agent) {
    return agent.getCommissionRate() * this.askingPrice;
  }
}
