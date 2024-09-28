package sn.supInfo.Gproduit.service.Mapper;

import org.springframework.stereotype.Service;
import sn.supInfo.Gproduit.model.Produit;
import sn.supInfo.Gproduit.service.DTO.MouvementProduitDTO;
import sn.supInfo.Gproduit.model.MouvementProduit;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MouvementProduitMapper {



    public MouvementProduit toEntity(MouvementProduitDTO dto) {
        MouvementProduit entity = new MouvementProduit();
        entity.setId(dto.getId());
        entity.setDateMouv(dto.getDateMouv());
        entity.setQte(dto.getQte());
        entity.setTypeMouv(dto.getTypeMouv());
        Produit p  = new Produit();
        p.setId(dto.getId());
        entity.setProduit(p);

        return entity;
    }


    public MouvementProduitDTO toDto(MouvementProduit entity) {
        MouvementProduitDTO dto = new MouvementProduitDTO();
        dto.setId(entity.getId());
        dto.setDateMouv(entity.getDateMouv());
        dto.setQte(entity.getQte());
        dto.setTypeMouv(entity.getTypeMouv());
        dto.setProduitId(entity.getProduit().getId());

        return dto;
    }


    public List<MouvementProduit> toEntity(List<MouvementProduitDTO> dtoList) {
        return dtoList.stream().filter(Objects::nonNull).map(this::toEntity).collect(Collectors.toList());
    }


    public List<MouvementProduitDTO> toDto(List<MouvementProduit> entityList) {
        return entityList.stream().filter(Objects::nonNull).map(this::toDto).collect(Collectors.toList());
    }
}
