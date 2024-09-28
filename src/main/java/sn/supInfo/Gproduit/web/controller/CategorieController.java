package sn.supInfo.Gproduit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sn.supInfo.Gproduit.model.Categorie;
import sn.supInfo.Gproduit.repository.CategorieRepository;

import java.util.ArrayList;

@Controller
public class CategorieController {

    private CategorieRepository categorieRepository;

    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }


    @RequestMapping(value = "categorie/liste")
    public String listcategorie(Model model){

        model.addAttribute("categories",categorieRepository.findAll() );
       return "categorie/liste";
    }
    @RequestMapping(value = "categorie/ajout")
    public String ajoutcategorie(Model model){

        model.addAttribute("categorie", new Categorie());
        return "categorie/add";
    }

    @RequestMapping(value = "categorie/edit/{id}")
    public String editcategorie(@PathVariable long id, Model model){
        Categorie categorie = categorieRepository.findById(id).get();

        model.addAttribute("categorie",categorie);
        return "categorie/edite";
    }
    @RequestMapping(value = "categorie/save")
    public String savecategorie(@RequestParam("designation") String design ){
        Categorie categorie = new Categorie();
        categorie.setDesignation(design);
        categorieRepository.save(categorie);
        return "redirect:/categorie/liste";
    }

    @RequestMapping(value = "categorie/update")
    public String updatecategorie(@RequestParam("designation") String design,
            @RequestParam("id") long id ){
        Categorie categorie = new Categorie();
        categorie.setId(id);
        categorie.setDesignation(design);
        categorieRepository.save(categorie);
        return "redirect:/categorie/liste";
    }

    @RequestMapping(value = "categorie/supprimer/{id}")
    public String savecategorie(@PathVariable long id ){

        categorieRepository.deleteById(id);
        return "redirect:/categorie/liste";
    }
}
