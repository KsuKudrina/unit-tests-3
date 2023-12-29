package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainHWTest {
    MainHW num;

    @BeforeEach
    void setUp() {
        num = new MainHW();
    }

    @Test
    void EvenNumber() {
        assertTrue(num.evenOddNumber(8));
    }

    @Test
    void OddNumber() {
        assertFalse(num.evenOddNumber(5));
    }

    @Test
    void numberInInterval_True() {
        assertTrue(num.numberInInterval(35));
    }

    @Test
    void numberInInterval_False() {
        assertFalse(num.numberInInterval(100));
    }
}