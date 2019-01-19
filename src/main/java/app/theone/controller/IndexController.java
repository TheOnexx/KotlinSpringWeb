package app.theone.controller;

import app.theone.entity.User;
import app.theone.service.UserService;
import app.theone.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

    private UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String index(Model model, @ModelAttribute("sysMsg") String systemMessage) {
        List<User> users = userService.allUsers();
        model.addAttribute("sysMsg", systemMessage);
        model.addAttribute("users", users);
        return "index";
    }

}
