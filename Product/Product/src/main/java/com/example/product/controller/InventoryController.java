package com.example.product.controller;

import com.example.product.dto.inventory.InventoryRequest;
import com.example.product.dto.inventory.InventoryResponse;
import com.example.product.model.Inventory;
import com.example.product.service.inventory.InventoryServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "http://localhost:4200")

public class InventoryController {
    private final InventoryServiceInt inventoryServiceInt;

    public InventoryController(InventoryServiceInt inventoryServiceInt) {
        this.inventoryServiceInt = inventoryServiceInt;
    }

    @PostMapping
    public InventoryResponse addInventory(@RequestBody InventoryRequest inventory){
        return inventoryServiceInt.addInventory(inventory);
    }

    @PutMapping
    public InventoryResponse editInventory(@RequestBody InventoryRequest inventory, @RequestParam Integer idInventory){
        return inventoryServiceInt.editInventory(inventory, idInventory);
    }

    @DeleteMapping
    public String deleteInventory(@RequestParam Integer idInventory){
        return inventoryServiceInt.deleteInventory(idInventory);
    }

    @GetMapping
    public List<Inventory> getAllInventory(){
        return inventoryServiceInt.getAllInventory();
    }

}
