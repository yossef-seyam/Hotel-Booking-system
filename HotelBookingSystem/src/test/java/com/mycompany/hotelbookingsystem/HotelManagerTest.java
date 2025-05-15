package com.mycompany.hotelbookingsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HotelManagerTest {

    @Test
    public void testCustomerCreationAndGetters() {
        Customer customer = new Customer("Test User", "test@example.com");
        assertNotNull(customer, "Customer object should not be null");
        assertEquals("Test User", customer.getName(), "getName() should return the correct name");
        assertEquals("test@example.com", customer.getEmail(), "getEmail() should return the correct email");
        // Assuming ID is auto-incremented and starts from a known value or is predictable for testing.
        // For this example, let's assume the first customer ID after static init is predictable.
        // This part might need adjustment based on how Customer ID is actually managed (e.g., if it's reset or truly static across tests).
        // For simplicity, we'll test if ID is greater than a base, as it increments.
        assertTrue(customer.getID() > 1010, "getID() should return a valid ID greater than the initial static ID value");
    }

    @Test
    public void testRequestService() {
        Customer customer = new Customer("Service Requester", "service@example.com");
        // This method prints to console, so we can't directly assert its output without more complex setup (e.g., redirecting System.out).
        // For now, we'll just call it to ensure it doesn't throw an exception.
        // A more robust test would involve checking logs or using a mock/spy if the method had side effects we could verify.
        assertDoesNotThrow(() -> customer.requestService("Room Cleaning"), 
            "requestService should not throw an exception");
    }

    @Test
    public void testDisplayInfo() {
        Customer customer = new Customer("Info User", "info@example.com");
        // Similar to requestService, displayInfo prints to console.
        // We will call it to ensure no exceptions are thrown.
        assertDoesNotThrow(() -> customer.displayInfo(), 
            "displayInfo should not throw an exception");
    }
    
    @Test
    public void testMultipleCustomerIDs() {
        Customer customer1 = new Customer("User One", "one@example.com");
        Customer customer2 = new Customer("User Two", "two@example.com");
        assertNotEquals(customer1.getID(), customer2.getID(), "Multiple customers should have different IDs");
        assertTrue(customer2.getID() > customer1.getID(), "Second customer ID should be greater than the first");
    }
}

