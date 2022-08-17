package cofeeshop.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cofeeshop.main.domain.CustomerQueue;

@Repository
public interface CustomerQueueRepository extends JpaRepository<CustomerQueue, Long>{

}
