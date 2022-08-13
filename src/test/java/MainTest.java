import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @Timeout(22)
    @Disabled
    void main() {
        try {
            String[] strings = new String[3];
            Main.main(strings);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}