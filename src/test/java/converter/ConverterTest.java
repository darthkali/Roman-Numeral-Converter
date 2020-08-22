package converter;

import converter.Exceptions.OverflowException;
import converter.Exceptions.UnderflowException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class ConverterTest {

    private static final Logger log = LoggerFactory.getLogger(ConverterTest.class);

    private RomanNumeralsConverter romanNumeralsConverter;

    @Before
    public void setUp() throws Exception {
        romanNumeralsConverter = new RomanNumeralsConverter();
    }


    @Test
    public void convert_1_to_I(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(1), "I");
    }

    @Test
    public void convert_4_to_IV(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(4), "IV");
    }

    @Test
    public void convert_5_to_V(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(5), "V");
    }

    @Test
    public void convert_9_to_IX(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(9), "IX");
    }

    @Test
    public void convert_10_to_X(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(10), "X");
    }

    @Test
    public void convert_40_to_XL(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(40), "XL");
    }

    @Test
    public void convert_50_to_L(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(50), "L");
    }

    @Test
    public void convert_90_to_XC(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(90), "XC");
    }

    @Test
    public void convert_100_to_C(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(100), "C");
    }

    @Test
    public void convert_400_to_CD(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(400), "CD");
    }

    @Test
    public void convert_500_to_D(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(500), "D");
    }

    @Test
    public void convert_900_to_CM(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(900), "CM");
    }

    @Test
    public void convert_1000_to_M(){
        assertEquals(romanNumeralsConverter.convertSingleNumberToSingleRomanNumber(1000), "M");
    }



    @Test
    public void whenTheValueIs_Between_1_And_3_ThenReturn_1(){
        for(int i = 1; i <= 3; i++){
            log.info("Value = " + i + " HighestDecimalValue = 1");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 1);
        }
    }

    @Test
    public void whenTheValueIs_4_Return_4(){
        log.info("Value = 4" + " HighestDecimalValue = 4");
        assertEquals(romanNumeralsConverter.findHighestDecimalValue(4), 4);
    }

    @Test
    public void whenTheValueIs_Between_5_And_8_ThenReturn_5(){
        for(int i = 5; i <= 8; i++){
            log.info("Value = " + i + " HighestDecimalValue = 5");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 5);
        }
    }

    @Test
    public void whenTheValueIs_9_Return_9(){
        log.info("Value = 9" + " HighestDecimalValue = 9");
        assertEquals(romanNumeralsConverter.findHighestDecimalValue(9), 9);
    }

    @Test
    public void whenTheValueIs_Between_10_And_39_ThenReturn_10(){
        for(int i = 10; i <= 39; i++){
            log.info("Value = " + i + " HighestDecimalValue = 10");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 10);
        }
    }

    @Test
    public void whenTheValueIs_Between_40_And_49_ThenReturn_40(){
        for(int i = 40; i <= 49; i++){
            log.info("Value = " + i + " HighestDecimalValue = 40");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 40);
        }
    }

    @Test
    public void whenTheValueIs_Between_50_And_89_ThenReturn_50(){
        for(int i = 50; i <= 89; i++){
            log.info("Value = " + i + " HighestDecimalValue = 50");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 50);
        }
    }

    @Test
    public void whenTheValueIs_Between_90_And_99_ThenReturn_90(){
        for(int i = 90; i <= 99; i++){
            log.info("Value = " + i + " HighestDecimalValue = 90");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 90);
        }
    }

    @Test
    public void whenTheValueIs_Between_100_And_399_ThenReturn_100(){
        for(int i = 100; i <= 399; i++){
            log.info("Value = " + i + " HighestDecimalValue = 100");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 100);
        }
    }

    @Test
    public void whenTheValueIs_Between_400_And_499_ThenReturn_400(){
        for(int i = 400; i <= 499; i++){
            log.info("Value = " + i + " HighestDecimalValue = 400");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 400);
        }
    }

    @Test
    public void whenTheValueIs_Between_500_And_899_ThenReturn_500(){
        for(int i = 500; i <= 899; i++){
            log.info("Value = " + i + " HighestDecimalValue = 500");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 500);
        }
    }

    @Test
    public void whenTheValueIs_Between_900_And_999_ThenReturn_900(){
        for(int i = 900; i <= 999; i++){
            log.info("Value = " + i + " HighestDecimalValue = 900");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 900);
        }
    }

    @Test
    public void whenTheValueIs_HigherOrEqual_1000_ThenReturn_1000(){
        for(int i = 1000; i <= 2000; i++){
            log.info("Value = " + i + " HighestDecimalValue = 1000");
            assertEquals(romanNumeralsConverter.findHighestDecimalValue(i), 1000);
        }
    }


    @Test
    public void whenWeHaveFoundTheHighestDecimalValue_Then_SubtractItFromTheNumber(){

        int number = 36;
        number -= romanNumeralsConverter.findHighestDecimalValue(number);
        assertEquals(26, number);
    }

    @Test (expected = UnderflowException.class)
    public void  WhenTheValueIs_0_AndWeTryToSubtract_Then_ThrowA_UnderFlowException() throws Exception{
        romanNumeralsConverter.findHighestDecimalValue(0);
    }

    @Test
    public void Return_I_WhenTheInputIs_1(){
        assertEquals("I", romanNumeralsConverter.convertNumberToRomanNumber(1));
    }

    @Test
    public void Return_IV_WhenTheInputIs_4(){
        assertEquals("IV", romanNumeralsConverter.convertNumberToRomanNumber(4));
    }

    @Test
    public void Return_XI_WhenTheInputIs_11(){
        assertEquals("XI", romanNumeralsConverter.convertNumberToRomanNumber(11));
    }

    @Test
    public void Return_XXXVI_WhenTheInputIs_36(){
        assertEquals("XXXVI", romanNumeralsConverter.convertNumberToRomanNumber(36));
    }

    @Test
    public void Return_MMXII_WhenTheInputIs_2012(){
        assertEquals("MMXII", romanNumeralsConverter.convertNumberToRomanNumber(2012));
    }

    @Test
    public void Return_MCMXCVI_WhenTheInputIs_1996(){
        assertEquals("MCMXCVI", romanNumeralsConverter.convertNumberToRomanNumber(1996));
    }

    @Test
    public void Return_MMMMCMXCIX_WhenTheInputIs_4999(){
        assertEquals("MMMMCMXCIX", romanNumeralsConverter.convertNumberToRomanNumber(4999));
    }


    @Test (expected = UnderflowException.class)
    public void WhenInsertA_0_Then_ThrowAnException() throws Exception{
        romanNumeralsConverter.convertNumberToRomanNumber(0);
    }

    @Test (expected = UnderflowException.class)
    public void WhenInsertA_minus1_Then_ThrowAnException() throws Exception{
        romanNumeralsConverter.convertNumberToRomanNumber(-1);
    }

    @Test (expected = OverflowException.class)
    public void WhenInsert_5000_Then_ThrowAnException() throws Exception{
        romanNumeralsConverter.convertNumberToRomanNumber(5000);
    }

    @Test (expected = OverflowException.class)
    public void WhenInsert_5001_Then_ThrowAnException() throws Exception{
        romanNumeralsConverter.convertNumberToRomanNumber(5001);
    }

}
