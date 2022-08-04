package by.gulis.springcourse.FirstSecurityApp.services;

import by.gulis.springcourse.FirstSecurityApp.models.Person;
import by.gulis.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private PeopleRepository peopleRepository;
    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public void registrationPerson(Person person){
        peopleRepository.save(person);
    }
}
