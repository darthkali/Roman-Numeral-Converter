package converter;

import converter.Exceptions.OverflowException;
import converter.Exceptions.UnderflowException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class RomanNumeralsConverter {
    private static final Logger log = LoggerFactory.getLogger(RomanNumeralsConverter.class);

    public String convertNumberToRomanNumber(int value) {

        StringBuilder romanNumber = new StringBuilder();
        int number = value;
        int highestDecimalValue;

        if(number == 0) throw new UnderflowException();

        while(number != 0) {
            highestDecimalValue = findHighestDecimalValue(number);
            romanNumber.append(convertSingleNumberToSingleRomanNumber(highestDecimalValue));
            number -= highestDecimalValue;
        }

        log.info(value + " = " + romanNumber.toString());
        return romanNumber.toString();
    }

    public String convertSingleNumberToSingleRomanNumber(int number) {

        HashMap<Integer, String> romanNumberMap = new HashMap<Integer, String>();

        romanNumberMap.put(1, "I");
        romanNumberMap.put(4, "IV");
        romanNumberMap.put(5, "V");
        romanNumberMap.put(9, "IX");
        romanNumberMap.put(10, "X");
        romanNumberMap.put(40, "XL");
        romanNumberMap.put(50, "L");
        romanNumberMap.put(90, "XC");
        romanNumberMap.put(100, "C");
        romanNumberMap.put(400, "CD");
        romanNumberMap.put(500, "D");
        romanNumberMap.put(900, "CM");
        romanNumberMap.put(1000, "M");

        return romanNumberMap.get(number);
    }

    public int findHighestDecimalValue(int intValue) {

        if(intValue <= 0)       throw new UnderflowException();
        if(intValue >= 5000)    throw new OverflowException();

        if( intValue <  4 )    return 1;
        if( intValue == 4 )    return 4;
        if( intValue <  9 )    return 5;
        if( intValue == 9 )    return 9;
        if( intValue < 40 )    return 10;
        if( intValue < 50 )    return 40;
        if( intValue < 90 )    return 50;
        if( intValue < 100 )   return 90;
        if( intValue < 400 )   return 100;
        if( intValue < 500 )   return 400;
        if( intValue < 900 )   return 500;
        if( intValue < 1000 )  return 900;

        return 1000;
    }
}
