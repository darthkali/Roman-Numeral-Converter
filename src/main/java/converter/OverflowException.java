package converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverflowException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(RomanNumeralsConverter.class);

    public OverflowException() {
        log.error("The Input Value was Higher or Equal Then 5000");
    }
}