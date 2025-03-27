package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomerList(){
        return customerService.customerList();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("customerId") UUID id){
        log.debug("CustomerController: getCustomer by id: " + id);
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer){

        Customer newCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers =  new HttpHeaders();
        headers.add("Location", "/api/v1/customer/"+ newCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
