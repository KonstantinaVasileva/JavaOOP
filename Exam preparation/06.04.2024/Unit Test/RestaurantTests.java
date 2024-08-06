package busyWaiters;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RestaurantTests {
    Restaurant restaurant;
    FullTimeWaiter waiter;

    @BeforeEach
    public void setUp() {
        restaurant = new Restaurant("Niagara", 2);
        waiter = new FullTimeWaiter("Ivan", 5);
    }

    @Test
    public void getCapacity_returnCorrectResult() {
        Assertions.assertEquals(2, restaurant.getCapacity());
    }

    @Test
    public void getName_returnCorrectResult() {
        Assertions.assertEquals("Niagara", restaurant.getName());
    }

    @Test
    public void getWaiters_returnCorrectResult() {
        restaurant.addFullTimeWaiter(waiter);
        Assertions.assertEquals(List.of(waiter), restaurant.getWaiters());
    }

    @Test
    public void getCount_returnCorrectResult() {
        restaurant.addFullTimeWaiter(waiter);
        Assertions.assertEquals(1, restaurant.getCount());
    }

    @Test
    public void addFullTimeWaiter_whenAlreadyExist_throwExp() {
        restaurant.addFullTimeWaiter(waiter);
        Assertions.assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(waiter));
    }

    @Test
    public void addFullTimeWaiter_whenCapacityIsFull_throwExp() {
        restaurant.addFullTimeWaiter(waiter);
        FullTimeWaiter waiter1 = new FullTimeWaiter("Georgi", 3);
        FullTimeWaiter waiter2 = new FullTimeWaiter("Niki", 9);
        restaurant.addFullTimeWaiter(waiter1);
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> restaurant.addFullTimeWaiter(waiter2));
        Assertions.assertEquals("No more places!", ex.getMessage());
    }

    @Test
    public void removeFullTimeWaiter_returnCorrectBoolean(){
        restaurant.addFullTimeWaiter(waiter);
        FullTimeWaiter waiter1 = new FullTimeWaiter("Georgi", 3);
        Assertions.assertFalse(restaurant.removeFullTimeWaiter(waiter1.getName()));
        Assertions.assertTrue(restaurant.removeFullTimeWaiter(waiter.getName()));
    }
    @Test
    public void throwExp_whenCapacityIsNegative(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->new Restaurant("Pizza", -1));
    }

    @Test
    public void throwExp_whenNameIsBlank(){
        Assertions.assertThrows(NullPointerException.class, ()->new Restaurant(" ", 3));
    }

    @Test
    public void throwExp_whenNameIsNull(){
        Assertions.assertThrows(NullPointerException.class, ()->new Restaurant(null, 3));
    }
}
