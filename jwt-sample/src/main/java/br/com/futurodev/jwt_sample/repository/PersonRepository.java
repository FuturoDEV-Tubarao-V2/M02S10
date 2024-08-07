package br.com.futurodev.jwt_sample.repository;

import br.com.futurodev.jwt_sample.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);
}
