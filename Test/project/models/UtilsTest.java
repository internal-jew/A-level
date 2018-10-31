package project.models;

import org.junit.jupiter.api.Test;
import project.Utils;

class UtilsTest {

    @Test()
    void validateTestShouldFail() {
        Utils.validate(0,1,5);
    }

    @Test()
    void validateString() {
    }
}