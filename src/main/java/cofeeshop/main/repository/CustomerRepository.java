package cofeeshop.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import cofeeshop.main.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
