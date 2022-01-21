package pl.chrzanek.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pl.chrzanek.warehouse.model.Items;


@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer> {

}