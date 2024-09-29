package sn.supInfo.Gproduit.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.service.DTO.ProduitDTO;
import sn.supInfo.Gproduit.service.ProduitService;
import sn.supInfo.Gproduit.repository.ProduitRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produit")
public class ProduitRessource {

    @Autowired
    ProduitService produitService;
    @Autowired
    ProduitRepository produitRepository;


    @GetMapping("/liste")
    public List<Produit> listproduit( ){
        return produitRepository.findAll() ;
    }

    @GetMapping("/{id}")
    public Optional<Produit> roduitid(@PathVariable long id){
        return produitRepository.findById(id) ;
    }

    @PostMapping("/ajout")
    public Optional<ProduitDTO> addroduit(@RequestBody ProduitDTO categorie){
        return Optional.of(produitService.save(categorie)) ;
    }

    @PutMapping("/ajout")
    public Optional<ProduitDTO> editroduit(@RequestBody ProduitDTO produitDTO){
        return Optional.of(produitService.save(produitDTO)) ;
    }

}
