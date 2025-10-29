import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Agent.
 *
 * @param <T> the type of property
 * @param <U> the type of contract
 */
public class Agent<T extends AProperty, U extends Contract> {

  private T property;
  private U contract;
  private String name;
  private ArrayList<Listing<T, U>> listings = new ArrayList<>();
  private double commissionRate;
  private double totalEarnings;

  /**
   * Instantiates a new Agent.
   *
   * @param property       the property
   * @param contract       the contract
   * @param name           the name, as a String
   * @param listings       the listings, as an ArrayList of Listings
   * @param commissionRate the commission rate, as a double
   * @param totalEarnings  the total earnings, as a double
   */
  public Agent(T property, U contract, String name, ArrayList<Listing<T, U>> listings,
      double commissionRate, double totalEarnings) {
    this.property = property;
    this.contract = contract;
    this.name = name;
    this.listings = listings;
    this.commissionRate = commissionRate;
    this.totalEarnings = totalEarnings;
  }

  /**
   * Adds a listing to the listings.
   *
   * @param listing the listing, as a Listing
   */
  public void addListing(Listing<T, U> listing) {
    this.listings.add(listing);
  }

  /**
   * Completes a listing and adds earnings to totalEarnings.
   *
   * @param listing the listing, as a Listing
   */
  public void completeListing(Listing<T, U> listing) {
    if (!(this.listings.contains(listing))) {
      throw new IllegalArgumentException("Listing not found");
    }
    this.listings.remove(listing);
    double earnings = listing.getContract().getEarnings(this);
    this.totalEarnings += earnings;
  }

  /**
   * Removes a listing from the listings.
   *
   * @param listing the listing, as a Listing
   */
  public void removeListing(Listing<T, U> listing) {
    if (!(this.listings.contains(listing))) {
      throw new IllegalArgumentException("Listing not found");
    }
    this.listings.remove(listing);
  }

  /**
   * Gets the total portfolio value of all potential earnings from listings.
   *
   * @return the total portfolio value, as a double
   */
  public double getTotalPortfolioValue() {
    ArrayList<Listing<T, U>> portfolioCopy = (ArrayList<Listing<T, U>>) this.listings.clone();
    for (Listing<T, U> listing : portfolioCopy) {
      completeListing(listing);
    }
    return totalEarnings;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets listings.
   *
   * @return the listings
   */
  public ArrayList<Listing<T, U>> getListings() {
    return listings;
  }

  /**
   * Gets commission rate.
   *
   * @return the commission rate
   */
  public double getCommissionRate() {
    return commissionRate;
  }

  /**
   * Gets total earnings.
   *
   * @return the total earnings
   */
  public double getTotalEarnings() {
    return totalEarnings;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Agent<?, ?> agent = (Agent<?, ?>) o;
    return Double.compare(commissionRate, agent.commissionRate) == 0
        && Double.compare(totalEarnings, agent.totalEarnings) == 0
        && Objects.equals(property, agent.property) && Objects.equals(contract,
        agent.contract) && Objects.equals(name, agent.name) && Objects.equals(
        listings, agent.listings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(property, contract, name, listings, commissionRate, totalEarnings);
  }

  @Override
  public String toString() {
    return "Agent{" +
        "property=" + property +
        ", contract=" + contract +
        ", name='" + name + '\'' +
        ", listings=" + listings +
        ", commissionRate=" + commissionRate +
        ", totalEarnings=" + totalEarnings +
        '}';
  }
}
