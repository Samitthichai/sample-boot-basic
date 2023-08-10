package th.mfu;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ResponseController
public class ProductController {

    @Autowired
    private ProductReposity productReposity;

    @GetMapping("/products")
    public Collection<Product> getAllProduct() {
        return productReposity.findAll();// return all employees ////like call interface in oop
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product products) {

        // // add emp to hashmap
        // employeesDB.put(employee.getId(), employee);

        productReposity.save(products);
        // return success
        return ResponseEntity.ok(" product created");
    }

    // @GetMapping("/products/{id}")
    // public ResponseEntity getProductById(@PathVariable long id) {
    //     // // check id exit
    //     Optional<Product> optProduct = productReposity.findById(id);

    //     if (!optProduct.isPresent()) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product id already exits");
    //     }
    //     Product prod = optProduct.get();
    //     return ResponseEntity.ok(prod);
    // }

    // @PutMapping("/products/{id}")
    // public ResponseEntity<String> updateProduct(@PathVariable long id,
    // @RequestBody product product) {

    // if (!productReposity.existsById(id)) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not
    // found");
    // }
    // employeeRepository.save(employee);

    // return ResponseEntity.ok("Employee update");

    // }

}
