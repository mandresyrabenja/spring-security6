package mg.mandresy.springSecurity.customer;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerService.selectUserByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Username " + username + " not found")
                );
    }
}
