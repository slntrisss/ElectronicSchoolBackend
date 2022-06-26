package org.back.school.service;

import org.back.school.model.Login;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class LoginService {
    private static final Properties properties;
    private static final Login credentials;
    static{
        credentials = new Login();
        properties = new Properties();
        try {
            properties.load(LoginService.class.getClassLoader().getResourceAsStream("application.properties"));
            credentials.setUsername(properties.getProperty("credentials.username"));
            credentials.setPassword(properties.getProperty("credentials.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean checkCredentials(Login login){
        return credentials.getUsername().equals(login.getUsername())
                && credentials.getPassword().equals(login.getPassword());
    }
}
