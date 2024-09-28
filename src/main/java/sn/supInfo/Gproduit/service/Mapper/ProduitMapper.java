package sn.supInfo.Gproduit.service.Mapper;

import org.springframework.stereotype.Service;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.model.Categorie;
import sn.supInfo.Gproduit.service.DTO.ProduitDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Service
public class ProduitMapper {

    public Produit toEntity(ProduitDTO dto){


        Produit entity = new Produit();
        entity.setId(dto.getId());
        entity.setDesignation(dto.getDesignation());
        entity.setCode(dto.getCode());
        entity.setPrixU(dto.getPrixU());
        entity.setQte(dto.getQte());
        entity.setMontantS(dto.getPrixU() * dto.getQte() );
        Categorie categorie = new Categorie();
        categorie.setId(dto.getCategorieId());
        entity.setCategorie(categorie);

        return entity;

    }

    public ProduitDTO toDto(Produit entity){


        ProduitDTO dto = new ProduitDTO();
        dto.setId(entity.getId());
        dto.setDesignation(entity.getDesignation());
        dto.setCode(entity.getCode());
        dto.setPrixU(entity.getPrixU());
        dto.setQte(entity.getQte());
        dto.setMontantS(entity.getMontantS());
        dto.setCategorieId(entity.getCategorie().getId());

        return dto;

    }

    public List<Produit> toEntity(List<ProduitDTO> lproduitDto){

        return lproduitDto.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }


    public List<ProduitDTO> toDto(List<Produit> lproduit){

        return lproduit.stream().filter(Objects::nonNull).map(this::toDto).collect(Collectors.toList());
    }





}
