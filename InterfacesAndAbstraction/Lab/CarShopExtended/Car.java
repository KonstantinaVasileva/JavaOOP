package OOP.InterfacesAndAbstraction.Lab.CarShopExtended;

import java.io.Serializable;

public interface Car extends Serializable {
     Integer TYRE = 4;
     String getModel();
     String getColor();
     Integer getHorsePower();
     String countryProduced();

}
