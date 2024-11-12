package org.launchcode.techjobsauth.controllers;

import jakarta.servlet.http.HttpSession;
import org.launchcode.techjobsauth.models.User;
import org.launchcode.techjobsauth.models.data.UserRepository;
import org.launchcode.techjobsauth.models.dto.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.SecureRandom;
import java.util.Optional;

@Controller
public class AuthenticationController {
    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey ="user";

    public User getUserFromSession(HttpSession session){
Integer userId = (Integer) session.getAttribute(userSessionKey);
if (userId == null){
    return null;
}
        Optional<User> user = userRepository.findById(userId);

if (user.isEmpty()){
    return null;
}
return user.get();
    }
    private static void  setUserSession(HttpSession session, User user) {

        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping("register")
    public String displayform(Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register");
        return "register";
    }
    @PostMapping()
    public String processDisplay() {}

}
