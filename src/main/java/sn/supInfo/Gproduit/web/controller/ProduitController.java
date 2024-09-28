package sn.supInfo.Gproduit.web.controller;


import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.repository.ProduitRepository;
import sn.supInfo.Gproduit.service.DTO.ProduitDTO;

import java.util.ArrayList;

@Controller
public class ProduitController {

    private ProduitRepository produitRepository;


    ProduitController(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

    @RequestMapping("/produit/ajout")
    public String addProdut(Model model){
        model.addAttribute("produitdto",new ProduitDTO());

        return "produit/add";
    }

    @RequestMapping("/produit/liste")
    public String listProdut(Model model){

        model.addAttribute("produits", produitRepository.findAll());

        return "produit/liste";
    }


}
