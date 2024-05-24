package com.tretle.tech.inventoryservice.repository;

import com.tretle.tech.inventoryservice.pojo.Inventory;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Query("SELECT i FROM Inventory i WHERE i.skuCode = :skuCode")
    Optional<Inventory> findBySkuCode(@Param("skuCode") String skuCode);
    @Query("SELECT i FROM Inventory i WHERE i.skuCode in (:skuCode)")
    List<Inventory> findBySkuCodeIn(@Param("skuCode") List<String> skuCode);
}

