package cn.swu.edu.javaweb.config;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class TestEncoder {

    @Test
    public void encoder(){
        String password = "admin";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
    }

}