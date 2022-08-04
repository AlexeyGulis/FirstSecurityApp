package by.gulis.springcourse.FirstSecurityApp.controllers;


import by.gulis.springcourse.FirstSecurityApp.models.Person;
import by.gulis.springcourse.FirstSecurityApp.services.RegistrationService;
import by.gulis.springcourse.FirstSecurityApp.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private PersonValidator personValidator;
    private RegistrationService registrationService;

    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person){
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){

        System.out.println("hi");
        personValidator.validate(person,bindingResult);

        if(bindingResult.hasErrors()){
            return "/auth/registration";
        }

        registrationService.registrationPerson(person);

        return "redirect:auth/login";
    }
}
