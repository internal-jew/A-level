package hw_15.Train;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class TrainTest {


    @Test
    public void createTrain() {
        Train train = new Train(1, 1, 1);
        String actualTrain = train.toString();
        assertTrue(Pattern.matches("[A-z]+-\\[[A-z ]+: \\d+%]-\\[[A-z ]+\\d+ [a-z]+]-\\[[A-z ]+\\d+ [a-z]+]-", actualTrain));
    }

    @Test
    public void createCities() {
        Enum<CityName> cityName = MainForTrain.getRandomCityName();
        assertThat(cityName, (notNullValue()));
    }

}