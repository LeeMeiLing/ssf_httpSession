package sg.edu.nus.iss.app.httpSession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/reset-cart")
public class ResetCartController {
    
    @GetMapping
    public String resetCart(HttpSession session){

        System.out.println("In resetCart : " + session.getId()); // debug
        session.invalidate();
        return "redirect:/cart";

    }
}
