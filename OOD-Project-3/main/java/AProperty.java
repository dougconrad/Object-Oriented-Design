/**
 * Abstract class for all properties
 */
public abstract class AProperty {

  public String address;
  public Integer size;

  /**
   * Instantiates a new property.
   *
   * @param address the address, as a String
   * @param size    the size, in square feet, as an Integer
   */
  public AProperty(String address, Integer size) {
    this.address = address;
    this.size = size;
  }

  /**
   * Gives address.
   *
   * @return the address, as a String
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gives size.
   *
   * @return the size, in square feet, as an Integer
   */
  public Integer getSize() {
    return size;
  }


}
