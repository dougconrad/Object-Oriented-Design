public class CommercialProperty extends AProperty {

  private Integer numOffices;
  private Boolean suitableForRetail;
  
  /**
   * Instantiates a new Commercial property.
   *
   * @param address           the address, as a String
   * @param size              the size, in square feet, as an Integer
   * @param numOffices        the number of offices, as an Integer
   * @param suitableForRetail flag for whether the price is negotiable, as a Boolean
   */
  public CommercialProperty(String address, Integer size, Integer numOffices,
      Boolean suitableForRetail) {
    super(address, size);
    this.numOffices = numOffices;
    this.suitableForRetail = suitableForRetail;
  }
}
