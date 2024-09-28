package sn.supInfo.Gproduit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supInfo.Gproduit.model.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
