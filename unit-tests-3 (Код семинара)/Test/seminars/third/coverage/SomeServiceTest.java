package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
   // 3.1.
   private SomeService someService;
    void multipleThreeNotFiveReturnsFizz(int n) {

        // assertEquals...

    }

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    @Test
    void fizzTest() {
        String res = someService.fizzBuzz(3);
        assertThat(res).isEqualTo("Fizz");
    }

    @Test
    void buzzTest() {
        String res = someService.fizzBuzz(5);
        assertThat(res).isEqualTo("Buzz");
    }

    @Test
    void fizzBuzzTest() {
        String res = someService.fizzBuzz(15);
        assertThat(res).isEqualTo("FizzBuzz");
    }

    @Test
    void firstSix() {
        boolean res = someService.firstLast6(new int[] {6, 2, 9, 4});
        assertTrue(res);
    }

    @Test
    void lastSix() {
        boolean res = someService.firstLast6(new int[] {7, 2, 1, 6});
        assertTrue(res);
    }

    @Test
    void bothEndsSix() {
        boolean res = someService.firstLast6(new int[] {6, 2, 4, 3, 6});
        assertTrue(res);
    }

    @Test
    void noSix() {
        boolean res = someService.firstLast6(new int[] {5, 4, 2});
        assertFalse(res);
    }

    @Test
    void emptyArr() {
        boolean res = someService.firstLast6(new int[] {});
        assertFalse(res);
    }

    @Test
    void nullArr() {

        assertThatNullPointerException().isThrownBy(() -> {
            boolean res = someService.firstLast6(null);
        });
    }

    /**
     *
     * @param i
     * @param result
     */

    @ParameterizedTest
    @CsvSource({
            "50, 1000",
            "100, 0",
            "0, 2000"})
    void correctDiscountCalculatingTest(int i, int result) {
        assertThat(someService.calculatingDiscount(2000, i)).isEqualTo(result);
    }

    /**
     *
     * @param i
     */
    @ParameterizedTest
    @ValueSource(ints = {101, -1})
    void incorrectDiscountValue(int i){
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, i))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    public static int luckySum(int a, int b, int c) {
        int[] number = new int[]{a, b, c};
        int result = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 13) {
                result += number[i];
            }
        }
        return result;
    }
}