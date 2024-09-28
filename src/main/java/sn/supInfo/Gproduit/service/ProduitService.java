package sn.supInfo.Gproduit.service;

import org.springframework.stereotype.Service;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.repository.ProduitRepository;
import sn.supInfo.Gproduit.service.DTO.ProduitDTO;
import sn.supInfo.Gproduit.service.Mapper.ProduitMapper;

@Service
public class ProduitService {

    private ProduitMapper produitMapper;
    private ProduitRepository produitRepository;

    public ProduitService(ProduitMapper produitMapper, ProduitRepository produitRepository ){
        this.produitMapper = produitMapper;
        this.produitRepository =  produitRepository;

    }



    public ProduitDTO save(ProduitDTO produitDTO){
        //Produit produit = produitMapper.toEntity(produitDTO);
        //produit = produitRepository.save(produitMapper.toEntity(produitDTO));
        //ProduitDTO dto = produitMapper.toDto( produitRepository.save(produitMapper.toEntity(produitDTO)));
        //return  dto;
        return  produitMapper.toDto( produitRepository.save(produitMapper.toEntity(produitDTO)));

    }

}
