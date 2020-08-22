package converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RomanNumeralsConverter {
    private static final Logger log = LoggerFactory.getLogger(RomanNumeralsConverter.class);

    public String convertSingleNumberToSingleRomanNumber(int number) {

        switch (number){
            case 1:
                return "I";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 900:
                return "CM";
            case 1000:
                return "M";
            default:
                return "EndOfConvert";

        }
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

    public String convertNumberToRomanNumber(int value) {

        StringBuilder romanNumber = new StringBuilder();
        int number = value;
        int highestDecimalValue = 0;

        if(number == 0) throw new UnderflowException();

        while(number != 0){
            highestDecimalValue = findHighestDecimalValue(number);
            romanNumber.append(convertSingleNumberToSingleRomanNumber(highestDecimalValue));
            number -= highestDecimalValue;
        }

        log.info(value + " = " + romanNumber.toString());
        return romanNumber.toString();
    }
}
