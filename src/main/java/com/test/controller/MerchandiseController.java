package com.test.controller;

import com.test.model.MerchandiseEntity;
import com.test.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MerchandiseController {

    private final InventoryService inventoryService;

    public MerchandiseController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<MerchandiseEntity> addShirt(@RequestParam("price") Double price,
                                                      @RequestParam("nameLength") Integer length){
        return ResponseEntity.ok(inventoryService.saveShirtInventory(price, length));
    }
}
