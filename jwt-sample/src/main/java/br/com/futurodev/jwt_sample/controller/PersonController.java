package br.com.futurodev.jwt_sample.controller;

import br.com.futurodev.jwt_sample.model.transport.CreatePersonForm;
import br.com.futurodev.jwt_sample.model.transport.PersonDTO;
import br.com.futurodev.jwt_sample.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/authenticated")
    public ResponseEntity<String> isAuthenticated() {
        return ResponseEntity.ok("Is authenticated");
    }

    @PostMapping
    public ResponseEntity<PersonDTO> createUser(@RequestBody CreatePersonForm form,
                                                UriComponentsBuilder uriComponentsBuilder) {
        PersonDTO response = this.personService.createUser(form);

        URI uri = uriComponentsBuilder
                .path("/person/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
