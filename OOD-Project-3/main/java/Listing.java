/**
 * The type Listing.
 *
 * @param <T> the type of property
 * @param <U> the type of contract
 */
public class Listing<T extends AProperty, U extends Contract> {

  private T property;
  private U contract;

  /**
   * Instantiates a new Listing.
   *
   * @param property the property, as generic T
   * @param contract the contract, as generic U
   */
  public Listing(T property, U contract) {
    this.property = property;
    this.contract = contract;
  }

  /**
   * Gets property.
   *
   * @return the property
   */
  public T getProperty() {
    return property;
  }

  /**
   * Gets contract.
   *
   * @return the contract
   */
  public U getContract() {
    return contract;
  }

}
