package converter.Exceptions;

import converter.DecimalToRomanConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnderflowException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(DecimalToRomanConverter.class);

    public UnderflowException() {
        log.error("The Input Value was Zero or Negative");
    }
}