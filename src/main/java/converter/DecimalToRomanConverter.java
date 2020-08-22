package converter;

import converter.Exceptions.OverflowException;
import converter.Exceptions.UnderflowException;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DecimalToRomanConverter {
    private static final Logger log = LoggerFactory.getLogger(DecimalToRomanConverter.class);


    public String convertDecimalNumberToRomanNumber(int decimalNumber) {

        StringBuilder romanNumber = new StringBuilder();
        int subtractNumber = decimalNumber;
        int highestDecimalNumber;

        do {
            highestDecimalNumber = findHighestDecimalNumberIn(subtractNumber);
            romanNumber.append(convertSingleNumberToSingleRomanNumber(highestDecimalNumber));
            subtractNumber -= highestDecimalNumber;
        } while(subtractNumber != 0);

        return romanNumber.toString();
    }

    public String convertSingleNumberToSingleRomanNumber(int number) {

        HashMap<Integer, String> romanNumberMap = new HashMap<>();

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

    public int findHighestDecimalNumberIn(int decimalNumber) {

        if(decimalNumber <= 0)       throw new UnderflowException();
        if(decimalNumber >= 5000)    throw new OverflowException();

        if( decimalNumber <  4 )    return 1;
        if( decimalNumber == 4 )    return 4;
        if( decimalNumber <  9 )    return 5;
        if( decimalNumber == 9 )    return 9;
        if( decimalNumber < 40 )    return 10;
        if( decimalNumber < 50 )    return 40;
        if( decimalNumber < 90 )    return 50;
        if( decimalNumber < 100 )   return 90;
        if( decimalNumber < 400 )   return 100;
        if( decimalNumber < 500 )   return 400;
        if( decimalNumber < 900 )   return 500;
        if( decimalNumber < 1000 )  return 900;

        return 1000;
    }
}
