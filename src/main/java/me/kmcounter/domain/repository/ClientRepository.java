package me.kmcounter.domain.repository;

import me.kmcounter.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByZipCode(String zipCode);
    boolean existsByName(String name);

}
