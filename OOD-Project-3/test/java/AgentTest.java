import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgentTest {

  private Agent<AProperty, Contract> agent;
  private Agent<AProperty, Contract> agent2;
  private ResidentialProperty residentialProperty;
  private Sale contract;
  private Listing<AProperty, Contract> listing;


  @BeforeEach
  void setUp() {
    residentialProperty = new ResidentialProperty("1000 Lenora", 800, 2, 1.0);
    listing = new Listing<>(residentialProperty, contract);
    agent = new Agent<>(residentialProperty, contract, "Test Property"
        , new ArrayList<Listing<AProperty, Contract>>(), 0.1, 0.0);

  }

  @Test
  void addListing() {
    agent.addListing(listing);
    assertTrue(agent.getListings().contains(listing));
  }

  @Test
  void completeListing() {
    agent.addListing(listing);
    agent.completeListing(listing);
    assertFalse(agent.getListings().contains(listing));
    assertEquals(listing.getContract().getEarnings(agent), agent.getTotalEarnings());
  }

  @Test
  void removeListing() {
    agent.addListing(listing);
    agent.removeListing(listing);
    assertFalse(agent.getListings().contains(listing));
    assertEquals(0, agent.getTotalEarnings());
  }

  @Test
  void getTotalPortfolioValue() {
    agent.addListing(listing);
    assertEquals(listing.getContract().getEarnings(agent), agent.getTotalPortfolioValue());
  }

  @Test
  void testEquals() {
    assertEquals(agent, agent);
    assertNotEquals(agent, agent2);
  }

  @Test
  void testHashCode() {
    assertEquals(agent.hashCode(), agent.hashCode());
  }
}