package by.gulis.springcourse.FirstSecurityApp.config;

import by.gulis.springcourse.FirstSecurityApp.security.AuthProviderImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthProviderImp authProviderImp;

    @Autowired
    public SecurityConfiguration(AuthProviderImp authProviderImp) {
        this.authProviderImp = authProviderImp;
    }

    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProviderImp);
    }
}
