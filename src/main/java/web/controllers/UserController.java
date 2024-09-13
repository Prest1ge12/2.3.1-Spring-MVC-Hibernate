package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiceImp;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userServiceImp.getAllUsers());
        return "users/users";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.getUser(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") Long id) {
        model.addAttribute("user", userServiceImp.getUser(id));
        return "users/edit";
    }

    @PatchMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") Long id) {
        userServiceImp.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping()
    public String delete(@RequestParam("id") Long id) {
        userServiceImp.delete(id);
        return "redirect:/users";

    }

}
