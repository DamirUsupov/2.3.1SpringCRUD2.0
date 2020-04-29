package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @RequestMapping("/admin/users")
    public String printUsers(ModelMap model) {

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }


    @PostMapping("/admin/users")
    public String addUser(@ModelAttribute(name = "user") User user) {

        userService.addUser(user);
        return "redirect:/admin/users";

    }

    @PostMapping("/admin/delete")
    public String deleteUser(@ModelAttribute(name = "id") Long id) {

        userService.deleteUser(userService.getUserById(id));

        return "redirect:/admin/users";
    }


    @GetMapping("/admin/update")
    public String updateUser(ModelMap model, @ModelAttribute(name = "id") Long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update";

    }

    @PostMapping("/admin/update")
    public String confirmUpdate(@ModelAttribute User user) {

        userService.updateUser(user);
        return "redirect:/admin/users";

    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";

    }

    @GetMapping("/user")
    public String userInfo(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("user", auth.getPrincipal());
        return "user";

    }


}
