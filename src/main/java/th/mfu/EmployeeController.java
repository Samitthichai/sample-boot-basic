package th.mfu;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    // create hashmap fro employee
    private HashMap<Long, Employee> employeesDB = new HashMap<Long, Employee>();

    // select emp
    @GetMapping("/employees")
    public Collection<Employee> getAllEmployee() {
        return employeesDB.values();// return all employees
    }

    // SELECT BY ID
    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployeeById(@PathVariable long id) {
        // check id exit

        if (!employeesDB.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee id already exits");
        }
        return ResponseEntity.ok(employeesDB.get(id));
    }

    // create emp
    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {

        if (employeesDB.containsKey(employee.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Employee id already exits");
        }
        // add emp to hashmap
        employeesDB.put(employee.getId(), employee);

        // return success
        return ResponseEntity.ok(" Employees created");
    }

    // update emp
    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {

        employeesDB.put(id, employee);

        return ResponseEntity.ok("Employee update");

    }

    // delete emp
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
        employeesDB.remove(id);

        return ResponseEntity.ok("Employee delete");

    }

    @DeleteMapping("/employees")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee) {
        employeesDB.remove(employee);

        return ResponseEntity.ok("Employee delete");

    }

}
