package com.javatpoint;
/*
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * @RestController public class UserController {
 * 
 * 
 * @PostMapping("/user/save") // Changed URL path public ModelAndView
 * save(@ModelAttribute User user) { ModelAndView modelAndView = new
 * ModelAndView(); modelAndView.setViewName("user-data");
 * modelAndView.addObject("user", user); return modelAndView; }
 * 
 * @Autowired private UserService userService;
 * 
 * @PostMapping("/users") public void addUser(@RequestBody User user) {
 * userService.addUser(user); }
 * 
 * @GetMapping("/users") public List<User> getAllUsers() { return
 * userService.getAllUsers(); }
 * 
 * 
 * }
 * 
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint to save a user using form data and return a view
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute User user) {
    	System.out.print("i741");
        ModelAndView modelAndView = new ModelAndView();
        userService.addUser(user); // Save user
        modelAndView.setViewName("user-data");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    // Endpoint to add a user via JSON payload
    @PostMapping
    @ResponseBody
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    // Endpoint to retrieve all users as JSON
    @GetMapping
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
