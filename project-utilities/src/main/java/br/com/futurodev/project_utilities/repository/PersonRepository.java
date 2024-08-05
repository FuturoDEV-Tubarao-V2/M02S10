package br.com.futurodev.project_utilities.repository;

import br.com.futurodev.project_utilities.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
