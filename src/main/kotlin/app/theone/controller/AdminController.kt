package app.theone.controller

import app.theone.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class AdminController(@Autowired private val userService: UserService) {
    @RequestMapping(value = ["/admin"], method = [(RequestMethod.GET)])
    fun adminPage(model: Model) : String {
        val users = userService.allUsers()
        model.addAttribute("users", users)
        return "admin"
    }
}