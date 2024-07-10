package com.tvo.controller;

import com.tvo.model.Good;
import com.tvo.model.dto.RequestQuantityDto;
import com.tvo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public List<Good> getAllGoods() {
        return this.storageService.getAllGoods();
    }

    @GetMapping("/{id}")
    public Good getGoodById(@PathVariable int id) {
        return this.storageService.getGoodById(id);
    }

    @PostMapping
    public void addGood(@RequestBody Good good) {
        this.storageService.addGood(good);
    }

    @PutMapping("/{id}")
    public void updateGood(@RequestBody Good good, @PathVariable int id) {
        this.storageService.updateGood(good, id);
    }

    @PatchMapping("/addQuantity/{id}")
    public void addQuantity(@PathVariable int id, RequestQuantityDto requestQuantity){
        this.storageService.addQuantity(id, requestQuantity);
    }

    @PatchMapping("/removeQuantity/{id}")
    public void removeQuantity(@PathVariable int id, RequestQuantityDto requestQuantity){
        this.storageService.removeQuantity(id, requestQuantity);
    }

    @DeleteMapping("/{id}")
    public void removeGood(@PathVariable int id) {
        this.storageService.removeGood(id);
    }
}
