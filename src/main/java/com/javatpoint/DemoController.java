package com.javatpoint;  
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
@Controller  
public class DemoController 
{  
	
	
	
	
@RequestMapping("/")  
public String index()
{  
//returns to index.html
return"index";  
}  
/*
 * @RequestMapping(value="/save", method=RequestMethod.POST) public ModelAndView
 * save(@ModelAttribute User user) { System.out.print("hiii7777"); ModelAndView
 * modelAndView = new ModelAndView(); modelAndView.setViewName("user-data");
 * modelAndView.addObject("user", user); return modelAndView; }
 */ 

@Autowired
private UserService userService;

// Endpoint to save a user using form data and return a view
@RequestMapping(value="/save", method=RequestMethod.POST)
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