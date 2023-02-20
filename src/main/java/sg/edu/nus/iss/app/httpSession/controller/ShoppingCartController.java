package sg.edu.nus.iss.app.httpSession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.app.httpSession.model.Cart;
import sg.edu.nus.iss.app.httpSession.model.Item;

@Controller
@RequestMapping(path="/cart")
public class ShoppingCartController {
    
    @GetMapping
    public String getCart(Model model,HttpSession session){

        System.out.println("In GetMapping : " + session.getId()); // debug
        Cart cart = (Cart) session.getAttribute("cart");

        if(null==cart){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        model.addAttribute("item", new Item());
        model.addAttribute("cart",cart);
        return "cart";

    }

    @PostMapping
    public String postData(@Valid Item item, BindingResult result, Model model, HttpSession session){

        System.out.println("In PostMapping : " + session.getId()); // debug

        Cart cart = (Cart) session.getAttribute("cart");
        if(result.hasErrors()){
            model.addAttribute("item",item);
            model.addAttribute("cart", cart);
            return "cart";
        }
        cart.addItemToCart(item);
        model.addAttribute("item",item);
        model.addAttribute("cart", cart);
        return "cart";
    }

}
