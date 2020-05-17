package org.drinkanddelight.rawmaterial.dao;

import org.drinkanddelight.rawmaterial.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
	

}
