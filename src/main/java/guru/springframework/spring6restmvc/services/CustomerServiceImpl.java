package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID,Customer> fakeCustomersList;

    public CustomerServiceImpl(){
        fakeCustomersList = new HashMap<>();

        Customer cust1 =  Customer.builder()
                .id(UUID.randomUUID())
                .customerName("First Customer")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        fakeCustomersList.put(cust1.getId(), cust1);

        Customer cust2 =  Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Second Customer")
                .version(2)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        fakeCustomersList.put(cust2.getId(), cust2);

        Customer cust3 =  Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Third Customer")
                .version(4)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        fakeCustomersList.put(cust3.getId(), cust3);

        Customer cust4 =  Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Best Customer")
                .version(3)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        fakeCustomersList.put(cust4.getId(), cust4);
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return fakeCustomersList.get(id);
    }

    @Override
    public List<Customer> customerList() {
        return new ArrayList<>(fakeCustomersList.values());
    }
}
