package sn.supInfo.Gproduit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.supInfo.Gproduit.model.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {

}
