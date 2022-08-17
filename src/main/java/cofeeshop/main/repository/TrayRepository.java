package cofeeshop.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cofeeshop.main.domain.Tray;

@Repository
public interface TrayRepository extends JpaRepository<Tray, Long>{

}
