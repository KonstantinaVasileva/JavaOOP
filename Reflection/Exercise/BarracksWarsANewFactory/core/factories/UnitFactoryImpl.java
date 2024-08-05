package OOP.Reflection.Exercise.BarracksWarsANewFactory.core.factories;

import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.Unit;
import OOP.Reflection.Exercise.BarracksWarsANewFactory.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"OOP.Reflection.Exercise.BarracksWarsANewFactory.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		// TODO: implement for problem 3

		try {
			Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
			throw new RuntimeException(e);
		}

	}
}
