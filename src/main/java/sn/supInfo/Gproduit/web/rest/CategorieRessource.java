package sn.supInfo.Gproduit.web.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.supInfo.Gproduit.model.Categorie;
import sn.supInfo.Gproduit.repository.CategorieRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categorie")
public class CategorieRessource {

    @Autowired
    CategorieRepository categorieRepository;



    @GetMapping("/liste")
    public List<Categorie> listcategorie( ){
        return categorieRepository.findAll() ;
    }

    @GetMapping("/{id}")
    public Optional<Categorie> categorieid(@PathVariable long id){
        return categorieRepository.findById(id) ;
    }

    @PostMapping("/ajout")
    public Optional<Categorie> addcategorie(@RequestBody Categorie categorie){
        return Optional.of(categorieRepository.save(categorie)) ;
    }

    @PutMapping("/ajout")
    public Optional<Categorie> editcategorie(@RequestBody Categorie categorie){
        return Optional.of(categorieRepository.save(categorie)) ;
    }



}
