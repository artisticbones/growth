package cn.swu.edu.javaweb.login;

import cn.swu.edu.javaweb.common.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;



}
