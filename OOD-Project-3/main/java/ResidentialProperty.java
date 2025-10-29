public class ResidentialProperty extends AProperty {

  private Integer numBedrooms;
  private Double numBathrooms;


  /**
   * Instantiates a new Residential property.
   *
   * @param address      the address, as a String
   * @param size         the size, in square feet, as an Integer
   * @param numBedrooms  the number of bedrooms, as an Integer
   * @param numBathrooms the number of bathrooms, as a Double
   */
  public ResidentialProperty(String address, Integer size, Integer numBedrooms,
      Double numBathrooms) {
    super(address, size);
    this.numBedrooms = numBedrooms;
    this.numBathrooms = numBathrooms;
  }
}
