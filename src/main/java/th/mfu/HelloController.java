package th.mfu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") /// {name} parameter name
    String hello() { /* @PathVariable String name = name */
        return "Hello World!";
    }

    @GetMapping("/hi/{name}") /// {name} parameter name
    String hi(@PathVariable String name) { /* @PathVariable String name = name */
        return "Hello " + name;
    }

    @GetMapping("/sum/{a}/{b}")
    int sum(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

}
