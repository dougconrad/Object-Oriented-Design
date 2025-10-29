package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DonationTest {

  private Donation donation;

  @Test
  void testGetTotalAmountForYearWorksWhenOne() {
    donation = new OneTimeDonation(100.0, LocalDateTime.now(), LocalDateTime.now());
    assertEquals(100.0, donation.getTotalAmountForYear(LocalDateTime.now().getYear()));
  }

  @Test
  void testGetTotalAmountForYearWorksWhenMonthly() {
    donation = new MonthlyDonation(100.0, LocalDateTime.now().minusMonths(12),
        LocalDateTime.now().minusMonths(12));
    assertEquals(1200.0, donation.getTotalAmountForYear(LocalDateTime.now().getYear()));
  }

  @Test
  void testGetTotalAmountForYearWorksWhenPledge() {
    Pledge donation = new Pledge(100.0, LocalDateTime.now(), LocalDateTime.now());
    donation.setFulfillmentDate(LocalDateTime.now().plusMonths(12));
    assertEquals(0, donation.getTotalAmountForYear(LocalDateTime.now().getYear()));

  }
}