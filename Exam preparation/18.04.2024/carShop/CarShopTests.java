package carShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarShopTests {
    private Car car;
    private CarShop shop;

    @BeforeEach
    public void setUp() {
        car = new Car("WV", 120, 2000);
        shop = new CarShop();
    }

    @Test
    public void getCount_returnCorrectSize() {
        shop.add(car);
        Assertions.assertEquals(1, shop.getCount());
    }

    @Test
    public void correctlyFindCar_withMaxHP() {
        shop.add(car);
        Assertions.assertEquals(List.of(car), shop.findAllCarsWithMaxHorsePower(100));
    }

    @Test
    public void throwExp_whenTyrToAdd_nullCar() {
        Assertions.assertThrows(NullPointerException.class, () -> shop.add(null));
    }

    @Test
    public void returnFalse_whenRemoveCar_thatNotExist(){
        Assertions.assertFalse(shop.remove(car));
    }

    @Test
    public void returnTRue_whenRemoveCar_thatExist(){
        shop.add(car);
        Assertions.assertTrue(shop.remove(car));
    }

    @Test
    public void whenTryToFind_mostLuxuryCar_returnCorrectResult(){
        Car car1 = new Car("Porshe", 2000, 20000);
        shop.add(car);
        shop.add(car1);
        Assertions.assertEquals(car1, shop.getTheMostLuxuryCar());
    }
    @Test
    public void findCarByModel_returnCorrectResult(){
        Car car1 = new Car("Porshe", 2000, 20000);
        shop.add(car);
        shop.add(car1);
        Assertions.assertEquals(List.of(car1), shop.findAllCarByModel("Porshe"));
    }
}

