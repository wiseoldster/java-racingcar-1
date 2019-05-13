package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarFactoryTest {
    private final CarFactory factory = new CarFactory();

    @Test
    void newCars_순서에따라_올바른_이름으로_생성했는지_검사() {
        // Arrange
        String str = "포비,제이슨,씨유";
        String[] names = str.split(",");

        // Act
        ArrayList<Car> actuals = factory.newCars(str);

        // Assert
        for (int i = 0; i < names.length && i < actuals.size(); i++) {
            String expected = names[i];
            String actual = actuals.get(i).getName();

            assertEquals(expected,
                    actual,
                    String.format("[%d] expected: %s, actual: %s", i, expected, actual));
        }
    }

    @Test
    void newCars_N개의올바른이름_N개차생성() {
        // Arrange
        String str = "포비,제이슨,씨유";
        String[] names = str.split(",");

        // Act
        ArrayList<Car> actuals = factory.newCars(str);

        // Assert
        assertEquals(names.length, actuals.size());
    }
}