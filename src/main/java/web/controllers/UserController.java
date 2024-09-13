package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public String getAllUsers() {
        return "users";
    }

    @GetMapping("/hello")
    public String test(){
        return "hello";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        return null;
    }
}
