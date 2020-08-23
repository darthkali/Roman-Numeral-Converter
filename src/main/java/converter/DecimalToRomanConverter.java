package converter;

import exceptions.OverflowException;
import exceptions.UnderflowException;
import java.util.HashMap;
import java.util.NavigableSet;
import java.util.TreeSet;

public class DecimalToRomanConverter {

  /**
   * Convert a Decimal Number to a Roman Number.
   *
   * @author Danny Steinbrecher.
   */
  public String convertDecimalNumberToRomanNumber(int decimalNumber) {

    StringBuilder romanNumber = new StringBuilder();
    int subtractNumber = decimalNumber;
    int highestDecimalNumber;

    do {
      highestDecimalNumber = findHighestDecimalNumberIn(subtractNumber);
      subtractNumber -= highestDecimalNumber;
      romanNumber.append(convertHighestDecimalNumberToRomanNumber(highestDecimalNumber));

    } while (subtractNumber != 0);

    return romanNumber.toString();
  }

  /**
   * Find the highest Decimal Number in Decimal number.
   *
   * @author Danny Steinbrecher.
   */
  public int findHighestDecimalNumberIn(int decimalNumber) {

    if (decimalNumber <= 0) {
      throw new UnderflowException();
    }

    if (decimalNumber >= 5000) {
      throw new OverflowException();
    }

    if (decimalNumber >= 1000) {
      return 1000;
    }

    HashMap<Integer, Integer> romanValueMap = new HashMap<>();
    romanValueMap.put(3, 1);
    romanValueMap.put(4, 4);
    romanValueMap.put(8, 5);
    romanValueMap.put(9, 9);
    romanValueMap.put(39, 10);
    romanValueMap.put(49, 40);
    romanValueMap.put(89, 50);
    romanValueMap.put(99, 90);
    romanValueMap.put(399, 100);
    romanValueMap.put(499, 400);
    romanValueMap.put(899, 500);
    romanValueMap.put(999, 900);

    NavigableSet<Integer> set = new TreeSet<>(romanValueMap.keySet());
    Integer key = set.ceiling(decimalNumber);

    return romanValueMap.get(key);
  }

  /**
   * Convert a single Number to a single Roman Number.
   *
   * @author Danny Steinbrecher.
   */
  public String convertHighestDecimalNumberToRomanNumber(int number) {

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
}
