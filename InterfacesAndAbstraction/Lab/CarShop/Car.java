package OOP.InterfacesAndAbstraction.Lab.CarShop;

import java.io.Serializable;

public interface Car extends Serializable {
     Integer TYRE = 4;
     String getModel();
     String getColor();
     Integer getHorsePower();
     String countryProduced();

}
