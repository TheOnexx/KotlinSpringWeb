package app.theone.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController {

    @RequestMapping(value = ["/login.do"], method = [RequestMethod.GET])
    fun login(mode: Model,
              @RequestParam(value = "error", required = false)
              error: String?) : String {
        if(error != null) {
            mode.addAttribute("error", "Invalid username or password")
        }
        return "login"
    }
}