package sn.supInfo.Gproduit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.supInfo.Gproduit.constant.TypeMouv;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.model.MouvementProduit;
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
        Produit p = produitRepository.getById(m.getProduitId());
        if (m.getTypeMouv().equals(TypeMouv.ENTRER)){
            p.setQte((int) (p.getQte() + m.getQte()));
            p.calculeMontantStock();
        }else {
            p.setQte((int) (p.getQte() - m.getQte()));
            p.calculeMontantStock();
        }
        p = produitRepository.save(p);
        MouvementProduit mouvementProduit = mouvementProduitMapper.toEntity(m);
        mouvementProduit.setProduit(p);

        return mouvementProduitMapper.toDto(mouvementProduitRepository.save(mouvementProduit));
    }




}
