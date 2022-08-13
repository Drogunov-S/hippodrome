/*
package delete.log;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoLog {

    private static final Logger log = LogManager.getLogger();

    public static void main(String[] args) {

        log.info("Test log");

        try {
            int a = 0;
            int b = 10;
            int c = b / a;

        } catch (ArithmeticException e) {
            log.error("Error ArithmeticException");
        }

        try {
            throw new Exception("Massage of Error");
        } catch (Exception e) {
            log.fatal("Fatal Error");
            e.printStackTrace();
        }

    }

}
*/
