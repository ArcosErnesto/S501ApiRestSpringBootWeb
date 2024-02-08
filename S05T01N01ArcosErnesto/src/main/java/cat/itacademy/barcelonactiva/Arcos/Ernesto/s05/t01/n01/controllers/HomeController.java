package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/index","/home","/"})
    public String index(){
        return "home";
    }

    @GetMapping({"/error"})
    public String error(){
        return "home";
    }
}