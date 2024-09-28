package sn.supInfo.Gproduit.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.repository.CategorieRepository;
import sn.supInfo.Gproduit.repository.ProduitRepository;
import sn.supInfo.Gproduit.service.DTO.ProduitDTO;
import sn.supInfo.Gproduit.service.Mapper.ProduitMapper;
import sn.supInfo.Gproduit.service.ProduitService;

import java.util.ArrayList;

@Controller
public class ProduitController {

    private ProduitRepository produitRepository;
    @Autowired
    public CategorieRepository categorieRepository;

    @Autowired
    public ProduitService produitService;

    @Autowired
    public ProduitMapper produitMapper;

    ProduitController(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }

    @RequestMapping("/produit/ajout")
    public String addProdut(Model model){
        model.addAttribute("produitdto",new ProduitDTO());
        model.addAttribute("categories",categorieRepository.findAll());

        return "produit/add";
    }


    @RequestMapping("/produit/edit/{id}")
    public String addProdut(@PathVariable long id,  Model model){
        Produit produit = produitRepository.findById(id).get();
        ProduitDTO produitDTO = produitMapper.toDto(produit);

        model.addAttribute("produitdto",produitDTO);
        model.addAttribute("categories",categorieRepository.findAll());

        return "produit/edite";
    }

    @RequestMapping("/produit/liste")
    public String listProdut(Model model){

        model.addAttribute("produits", produitRepository.findAll());
        return "produit/liste";
    }
    @PostMapping("produit/save")
    public  String saveProduit(@ModelAttribute ProduitDTO produitDTO, BindingResult bindingResult, Model model){

        produitService.save(produitDTO);

        return "redirect:/produit/liste";

    }

    @PutMapping("produit/save")
    public  String updateProduit(@ModelAttribute ProduitDTO produitDTO, BindingResult bindingResult, Model model){

        produitService.save(produitDTO);

        return "redirect:/produit/liste";

    }

    @RequestMapping(value = "produit/supprimer/{id}")
    public String saveproduit(@PathVariable long id ){

        produitRepository.deleteById(id);
        return "redirect:/produit/liste";
    }





}
