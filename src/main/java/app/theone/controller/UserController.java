package app.theone.controller;

import app.theone.entity.User;
import app.theone.service.UserService;
import app.theone.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}")
    public String display(Model model, @PathVariable long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEdit(Model model, @PathVariable long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String doEdit(RedirectAttributes redirectAttributes,  @Validated @ModelAttribute("user") User user, @PathVariable long id) {
        if(userService.updateUser(user)) {
            redirectAttributes.addFlashAttribute("sysMsg", "Success edit");
        } else {
            redirectAttributes.addFlashAttribute("sysMsg", "Failed edit");
        }
        return "redirect:/users";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAdd(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAdd(Model model, @Validated @ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
    @RequestMapping(value = "/delete/{id}" )
    public String delete(RedirectAttributes model, @PathVariable long id) {
        userService.removeUser(id);
        model.addAttribute("sysMsg", "User deleted");
        return "redirect:/users";
    }
}
