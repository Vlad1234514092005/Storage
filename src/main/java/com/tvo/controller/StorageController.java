package com.tvo.controller;

import com.tvo.model.Good;
import com.tvo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class StorageController {

    private StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService){
        this.storageService = storageService;
    }

    @GetMapping
    public void getAllGoods(){
        this.storageService.getAllGoods();
    }

    @GetMapping
    public void getGoodById(int id){
        this.storageService.getGoodById(id);
    }

    @PostMapping
    public boolean addGood(Good good, int quantity){
        return this.storageService.addGood(good, quantity);
    }

    @PutMapping
    public boolean updateGood(Good good, int id){
        return this.storageService.updateGood(good, id);
    }

    @DeleteMapping
    public boolean removeGood(int id, int quantity){
        return this.storageService.removeGood(id, quantity);
    }
}
