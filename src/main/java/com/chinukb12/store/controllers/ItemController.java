package com.chinukb12.store.controllers;

import com.chinukb12.store.entities.Item;
import com.chinukb12.store.exception.ItemNotFoundException;
import com.chinukb12.store.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TroAA
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("items")
public class ItemController {
    private final ItemRepository repository;

    @GetMapping
    public List<Item> allMessages() {
        return repository.findAll();
    }

    @PostMapping
    public Item create(@RequestBody Item newItem) {
        return repository.save(newItem);
    }

    @GetMapping(value = "{id}")
    public Item getItem(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
    }

    @PutMapping("{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        Item findItem = repository.findById(id).orElseThrow(ItemNotFoundException::new);
        findItem.setDescription(item.getDescription());
        findItem.setName(item.getName());
        findItem.setPrice(item.getPrice());
        return findItem;
    }

    @DeleteMapping("{id}")
    public List<Item> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}
