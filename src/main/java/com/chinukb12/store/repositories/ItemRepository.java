package com.chinukb12.store.repositories;

import com.chinukb12.store.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TroAA
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
