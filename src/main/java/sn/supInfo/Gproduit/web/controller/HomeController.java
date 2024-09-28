package sn.supInfo.Gproduit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.supInfo.Gproduit.repository.CategorieRepository;

@Controller
public class HomeController {

    @Autowired
    CategorieRepository categorieRepository;



    @RequestMapping("/")
    public String getHome(){

        return "home";
    }
}
