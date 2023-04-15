package mg.mandresy.springSecurity.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerDao {
    private final CustomerRepository customerRepository;

    public Optional<Customer> selectUserByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
