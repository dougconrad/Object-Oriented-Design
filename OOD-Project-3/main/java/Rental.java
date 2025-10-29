/**
 * The type Rental.
 */
public class Rental extends Contract {

  private Integer term;

  /**
   * Instantiates a new Rental.
   *
   * @param askingPrice  the asking price, as a Double
   * @param isNegotiable flag for whether contract is negotiable, as a Boolean
   * @param term         the term of the contract, as an Integer
   */
  public Rental(Double askingPrice, Boolean isNegotiable, Integer term) {
    super(askingPrice, isNegotiable);
    this.term = term;
  }

  @Override
  public double getEarnings(Agent agent) {
    return agent.getCommissionRate() * this.term * this.askingPrice;
  }

  /**
   * Gets term.
   *
   * @return the term
   */
  public Integer getTerm() {
    return term;
  }
}
