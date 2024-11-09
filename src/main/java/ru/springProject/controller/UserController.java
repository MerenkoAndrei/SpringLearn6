package ru.springProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springProject.model.User;
import ru.springProject.service.UserService;

import java.util.List;


@Controller
@RequestMapping()
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String welcome(){
        return "users/welcome";
    }

    @GetMapping("/users/list")
    public String listUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users/usersList";
    }

   @GetMapping("/{id}")
    public String showUser(@PathVariable int id, Model model) {
        model.addAttribute("user",userService.getById(id));
        return "users/showUser";
   }

   @GetMapping("/new")
   public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/newUser";
   }

   @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users/list";
   }

   @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "users/editUser";
   }

   @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user,@PathVariable("id") int id) {
        userService.update(user,id);
        return "redirect:/users/list";
   }

   @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users/list";
   }
}
