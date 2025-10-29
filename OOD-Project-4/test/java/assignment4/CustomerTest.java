package assignment4;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testGetExistingField() {
        Map<String, String> data = Map.of("first_name", "Jane", "email", "jane@test.com");
        Customer customer = new Customer(data);
        assertEquals("Jane", customer.get("first_name"));
        assertEquals("jane@test.com", customer.get("email"));
    }

    @Test
    public void testGetMissingFieldReturnsEmpty() {
        Customer customer = new Customer(Map.of("name", "Tom"));
        assertEquals("", customer.get("email"));
    }

    @Test
    public void testGetAllData() {
        Map<String, String> data = new HashMap<>();
        data.put("city", "Boston");
        data.put("state", "MA");

        Customer customer = new Customer(data);
        Map<String, String> retrieved = customer.getAllData();

        assertEquals(2, retrieved.size());
        assertEquals("Boston", retrieved.get("city"));
    }

    @Test
    public void testGetFieldAlias() {
        Customer customer = new Customer(Map.of("zip", "02115"));
        assertEquals("02115", customer.getField("zip"));
    }
}
