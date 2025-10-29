/**
 * The type Contract.
 */
public abstract class Contract {

  protected Double askingPrice;
  private Boolean isNegotiable;

  /**
   * Instantiates a new Contract.
   *
   * @param askingPrice  the asking price, as a Double
   * @param isNegotiable flag for whether Contract is negotiable, as a Boolean
   */
  public Contract(Double askingPrice, Boolean isNegotiable) {
    this.askingPrice = askingPrice;
    this.isNegotiable = isNegotiable;
  }

  /**
   * Gets earnings from specified contract of listing of agent.
   *
   * @param agent the agent, as an Agent
   * @return the earnings
   */
  public abstract double getEarnings(Agent agent);
}
