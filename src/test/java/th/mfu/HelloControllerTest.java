package th.mfu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest /// test script spring boots
public class HelloControllerTest { /// test unit class to check output

    @Autowired
    private HelloController controller;

    @Test
    public void testHello() {

        // Act
        String response = controller.hello();
        // Assert
        assertEquals("Hello World", response);

    }

    @Test
    public void testHi() {

        // Act
        String response = controller.hi("CMU");
        // Assert
        assertEquals("Hello CMU", response);
    }

    @Test
    public void testSum() {

        // Act
        int response = controller.sum(1, 2);
        // Assert
        assertEquals(3, response);

        int response2 = controller.sum(4, 5);
        // Assert
        assertEquals(9, response2);
    }
}
