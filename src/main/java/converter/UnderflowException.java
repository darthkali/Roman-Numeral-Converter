package converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnderflowException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(RomanNumeralsConverter.class);

    public UnderflowException() {
        log.error("The Input Value was Zero or Negative");
    }
}