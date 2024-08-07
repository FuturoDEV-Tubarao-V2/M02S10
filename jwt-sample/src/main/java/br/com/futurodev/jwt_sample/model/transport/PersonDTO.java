package br.com.futurodev.jwt_sample.model.transport;

import br.com.futurodev.jwt_sample.model.Person;

public record PersonDTO(Long id,
                        String name,
                        String email) {

    public PersonDTO(Person person) {
        this(person.getId(), person.getName(), person.getUsername());
    }
}
