package com.example.PersonalBlog.SignupController;

import com.example.PersonalBlog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";  // Renders signup.html
    }

    @PostMapping("/signup")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        userService.registerUser(username, password);
        model.addAttribute("message", "Signup successful!");
        return "success";  // Redirects to a success page
    }
}

//package com.example.PersonalBlog;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class SignupController {
//
//    @GetMapping("/signup")
//    public String showSignupForm() {
//        return "signup";
//    }
//
//    @PostMapping("/signup")
//    public String processSignup(@RequestParam String username, @RequestParam String password, @RequestParam String confirmPassword) {
//        if (!password.equals(confirmPassword)) {
//            return "redirect:/signup?error";
//        }
//        return "redirect:/signup-success";
//    }
//}