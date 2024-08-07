package br.com.futurodev.jwt_sample.service;

import br.com.futurodev.jwt_sample.model.Person;
import br.com.futurodev.jwt_sample.model.transport.CreatePersonForm;
import br.com.futurodev.jwt_sample.model.transport.PersonDTO;
import br.com.futurodev.jwt_sample.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService implements UserDetailsService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.personRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Transactional
    public PersonDTO createUser(CreatePersonForm form) {
        Person person = this.personRepository.save(new Person(form, this.passwordEncoder));
        return new PersonDTO(person);
    }
}
