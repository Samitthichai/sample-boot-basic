package th.mfu;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;

@ResponseController
public class productController {

    private HashMap<Long, product> productDB = new HashMap<Long, product>();

    @GetMapping("/product")
    public Collection<product> getAllproduct() {
        return productDB.values();

    }

}
