package sn.supInfo.Gproduit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.repository.MouvementProduitRepository;
import sn.supInfo.Gproduit.repository.ProduitRepository;
import sn.supInfo.Gproduit.service.DTO.MouvementProduitDTO;
import sn.supInfo.Gproduit.service.Mapper.MouvementProduitMapper;
import sn.supInfo.Gproduit.service.MouvementProduitService;
import sn.supInfo.Gproduit.model.MouvementProduit;

@Controller
public class MouvementController {

    @Autowired
    MouvementProduitRepository mouvementProduitRepository;
    @Autowired
    MouvementProduitService mouvementProduitService;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    MouvementProduitMapper mouvementProduitMapper;


    @RequestMapping("/mouvementproduit/ajout")
    public String addProdut(Model model){
        model.addAttribute("mouvementproduitDto",new MouvementProduitDTO());
        model.addAttribute("produis",produitRepository.findAll());

        return "mouvement/add";
    }


    @RequestMapping("/mouvementproduit/edit/{id}")
    public String addMouvementproduit(@PathVariable long id, Model model){
        MouvementProduit  m  = mouvementProduitRepository.findById(id).get();
        MouvementProduitDTO dto = mouvementProduitMapper.toDto(m);

        model.addAttribute("mouvementproduitDto",dto);
        model.addAttribute("produits",produitRepository.findAll());

        return "mouvement/edite";
    }

    @RequestMapping("/mouvementproduit/liste")
    public String listProdut(Model model){

        model.addAttribute("mouvementproduits", produitRepository.findAll());
        return "mouvement/liste";
    }
    @PostMapping("mouvementproduit/save")
    public  String saveProduit(@ModelAttribute MouvementProduitDTO produitDTO, BindingResult bindingResult, Model model){

        mouvementProduitService.save(produitDTO);

        return "redirect:/mouvementproduit/liste";

    }

    @PutMapping("mouvementproduit/save")
    public  String updateProduit(@ModelAttribute MouvementProduitDTO mouvementProduitDTO, BindingResult bindingResult, Model model){

        mouvementProduitService.update(mouvementProduitDTO);

        return "redirect:/mouvementproduit/liste";

    }

    @RequestMapping(value = "mouvementproduit/supprimer/{id}")
    public String saveproduit(@PathVariable long id ){

        produitRepository.deleteById(id);
        return "redirect:/mouvementproduit/liste";
    }





}
