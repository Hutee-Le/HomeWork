package likelion.edu.vn.restfulAPI.controller;

import likelion.edu.vn.restfulAPI.domain.Item;
import likelion.edu.vn.restfulAPI.util.error.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    @GetMapping
    public List<Item> getAllItems() {
        return items;
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        items.add(item);
        return item;
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Item not found with ID " + id));
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item updatedItem) {
        Item item = items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Item not found with ID " + id));
        item.setName(updatedItem.getName());
        return item;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        Item item = items.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ConfigDataResourceNotFoundException("Item not found with ID " + id));
        items.remove(item);
        return "Item deleted with ID " + id;
    }
}
