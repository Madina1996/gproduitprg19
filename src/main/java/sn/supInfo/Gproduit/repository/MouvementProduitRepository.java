package sn.supInfo.Gproduit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supInfo.Gproduit.model.MouvementProduit;

@Repository
public interface MouvementProduitRepository extends JpaRepository<MouvementProduit,Long> {


}
