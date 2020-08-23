package converter;

import exceptions.OverflowException;
import exceptions.UnderflowException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecimalToRomanConverterTest {

    private static final Logger log = LoggerFactory.getLogger(DecimalToRomanConverterTest.class);
    private DecimalToRomanConverter decimalToRomanConverter;

    @Before
    public void setUp() {
        decimalToRomanConverter = new DecimalToRomanConverter();
    }

    @Test
    public void convert_1_to_I() {
        assertEquals("I" , decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(1));
    }

    @Test
    public void convert_4_to_IV() {
        assertEquals("IV", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(4));
    }

    @Test
    public void convert_5_to_V() {
        assertEquals("V", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(5));
    }

    @Test
    public void convert_9_to_IX() {
        assertEquals("IX", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(9));
    }

    @Test
    public void convert_10_to_X() {
        assertEquals("X", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(10));
    }

    @Test
    public void convert_40_to_XL() {
        assertEquals("XL" , decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(40));
    }

    @Test
    public void convert_50_to_L() {
        assertEquals("L" , decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(50));
    }

    @Test
    public void convert_90_to_XC() {
        assertEquals("XC", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(90));
    }

    @Test
    public void convert_100_to_C() {
        assertEquals("C", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(100));
    }

    @Test
    public void convert_400_to_CD() {
        assertEquals("CD", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(400));
    }

    @Test
    public void convert_500_to_D() {
        assertEquals("D", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(500));
    }

    @Test
    public void convert_900_to_CM() {
        assertEquals("CM", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(900));
    }

    @Test
    public void convert_1000_to_M() {
        assertEquals("M", decimalToRomanConverter.convertHighestDecimalNumberToRomanNumber(1000));
    }

    @Test
    public void whenTheValueIs_Between_1_And_3_ThenReturn_1() {
        for(int i = 1; i <= 3; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 1");
            assertEquals(1, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_4_Return_4() {
        log.info("Value = 4" + " HighestDecimalValue = 4");
        assertEquals(4, decimalToRomanConverter.findHighestDecimalNumberIn(4));
    }

    @Test
    public void whenTheValueIs_Between_5_And_8_ThenReturn_5() {
        for(int i = 5; i <= 8; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 5");
            assertEquals(5, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_9_Return_9() {
        log.info("Value = 9" + " HighestDecimalValue = 9");
        assertEquals(9, decimalToRomanConverter.findHighestDecimalNumberIn(9));
    }

    @Test
    public void whenTheValueIs_Between_10_And_39_ThenReturn_10() {
        for(int i = 10; i <= 39; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 10");
            assertEquals(10, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_Between_40_And_49_ThenReturn_40() {
        for(int i = 40; i <= 49; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 40");
            assertEquals(40, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_Between_50_And_89_ThenReturn_50() {
        for(int i = 50; i <= 89; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 50");
            assertEquals(50, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_Between_90_And_99_ThenReturn_90() {
        for(int i = 90; i <= 99; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 90");
            assertEquals(90, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_Between_100_And_399_ThenReturn_100() {
        for(int i = 100; i <= 399; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 100");
            assertEquals(100, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_Between_400_And_499_ThenReturn_400() {
        for(int i = 400; i <= 499; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 400");
            assertEquals(400, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_Between_500_And_899_ThenReturn_500() {
        for(int i = 500; i <= 899; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 500");
            assertEquals(500, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_Between_900_And_999_ThenReturn_900() {
        for(int i = 900; i <= 999; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 900");
            assertEquals(900, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenTheValueIs_HigherOrEqual_1000_ThenReturn_1000() {
        for(int i = 1000; i <= 2000; i++) {
            log.info("Value = " + i + " HighestDecimalValue = 1000");
            assertEquals(1000, decimalToRomanConverter.findHighestDecimalNumberIn(i));
        }
    }

    @Test
    public void whenWeHaveFoundTheHighestDecimalValue_Then_SubtractItFromTheNumber() {
        int number = 36;
        number -= decimalToRomanConverter.findHighestDecimalNumberIn(number);
        assertEquals(26, number);
    }

    @Test (expected = UnderflowException.class)
    public void  WhenTheValueIs_0_AndWeTryToSubtract_Then_ThrowA_UnderFlowException() {
        decimalToRomanConverter.findHighestDecimalNumberIn(0);
    }

    @Test
    public void Return_I_WhenTheInputIs_1() {
        assertEquals("I", decimalToRomanConverter.convertDecimalNumberToRomanNumber(1));
    }

    @Test
    public void Return_IV_WhenTheInputIs_4() {
        assertEquals("IV", decimalToRomanConverter.convertDecimalNumberToRomanNumber(4));
    }

    @Test
    public void Return_XI_WhenTheInputIs_11() {
        assertEquals("XI", decimalToRomanConverter.convertDecimalNumberToRomanNumber(11));
    }

    @Test
    public void Return_XXXVI_WhenTheInputIs_36() {
        assertEquals("XXXVI", decimalToRomanConverter.convertDecimalNumberToRomanNumber(36));
    }

    @Test
    public void Return_MMXII_WhenTheInputIs_2012() {
        assertEquals("MMXII", decimalToRomanConverter.convertDecimalNumberToRomanNumber(2012));
    }

    @Test
    public void Return_MCMXCVI_WhenTheInputIs_1996() {
        assertEquals("MCMXCVI", decimalToRomanConverter.convertDecimalNumberToRomanNumber(1996));
    }

    @Test
    public void Return_MMMMCMXCIX_WhenTheInputIs_4999() {
        assertEquals("MMMMCMXCIX", decimalToRomanConverter.convertDecimalNumberToRomanNumber(4999));
    }

    @Test (expected = UnderflowException.class)
    public void WhenInsertA_0_Then_ThrowAnException() {
        decimalToRomanConverter.convertDecimalNumberToRomanNumber(0);
    }

    @Test (expected = UnderflowException.class)
    public void WhenInsertA_minus1_Then_ThrowAnException() {
        decimalToRomanConverter.convertDecimalNumberToRomanNumber(-1);
    }

    @Test (expected = OverflowException.class)
    public void WhenInsert_5000_Then_ThrowAnException() {
        decimalToRomanConverter.convertDecimalNumberToRomanNumber(5000);
    }

    @Test (expected = OverflowException.class)
    public void WhenInsert_5001_Then_ThrowAnException() {
        decimalToRomanConverter.convertDecimalNumberToRomanNumber(5001);
    }

    @Test
    public void printAllNumbersFrom_1_to_4999() {
        int number = 1;
        while(number != 5000){
            log.info("Decimal = " + number + " Roman = " + decimalToRomanConverter.convertDecimalNumberToRomanNumber(number));
            number++;
        }
    }
}
