package cn.swu.edu.javaweb.login;

import cn.swu.edu.javaweb.usermanage.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {

//    @RequestMapping({"/","/login.html"})
//    public String index(){
//        return "login";
//    }

    @PostMapping("/user/login")
    public String loginmain(@RequestParam("username") String username, @RequestParam("password") String password){
        if ("admin".equals(username) && "123456".equals(password)) {
            return "redirect:/index.html";
        }
        else {
            return "login";
        }
    }
}
