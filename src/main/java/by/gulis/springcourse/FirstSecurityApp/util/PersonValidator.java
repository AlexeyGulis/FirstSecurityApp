package by.gulis.springcourse.FirstSecurityApp.util;

import by.gulis.springcourse.FirstSecurityApp.models.Person;
import by.gulis.springcourse.FirstSecurityApp.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person p = (Person) target;
        if(peopleService.findByName(p.getName()).isPresent()){
            errors.rejectValue("name","","Человек с таким именем пользователя существует");
        }
    }
}
