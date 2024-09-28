package sn.supInfo.Gproduit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.supInfo.Gproduit.constant.TypeMouv;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.repository.MouvementProduitRepository;
import sn.supInfo.Gproduit.repository.ProduitRepository;
import sn.supInfo.Gproduit.service.DTO.MouvementProduitDTO;
import sn.supInfo.Gproduit.service.Mapper.MouvementProduitMapper;

@Service
public class MouvementProduitService {
    @Autowired
    MouvementProduitMapper mouvementProduitMapper;
    @Autowired
    MouvementProduitRepository  mouvementProduitRepository;
    @Autowired
    ProduitRepository produitRepository;


    @Transactional
    public MouvementProduitDTO save(MouvementProduitDTO m){
        Produit p = produitRepository.findById(m.getProduitId()).get();
        if (m.getTypeMouv().equals(TypeMouv.ENTRER)){
            p.setQte((int) (p.getQte() + m.getQte()));
            p.calculeMontantStock();
        }else {
            p.setQte((int) (p.getQte() - m.getQte()));
            p.calculeMontantStock();
        }
        produitRepository.save(p);

        return mouvementProduitMapper.toDto(mouvementProduitRepository.save(mouvementProduitMapper.toEntity(m)));
    }


    public MouvementProduitDTO update(MouvementProduitDTO dto){


        return null;
    }


}
