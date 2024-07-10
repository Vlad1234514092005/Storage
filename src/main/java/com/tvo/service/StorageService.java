package com.tvo.service;

import com.tvo.exception.ValueIsNotValidException;
import com.tvo.model.Good;
import com.tvo.model.dto.RequestQuantityDto;
import com.tvo.repository.StorageJdbcInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StorageService {

    private StorageJdbcInterface storageJdbc;

    @Autowired
    public StorageService(StorageJdbcInterface storageJdbc) {
        this.storageJdbc = storageJdbc;
    }


    public List<Good> getAllGoods() {
        return this.storageJdbc.getAllGoods();
    }

    public Good getGoodById(int id) {
        return this.storageJdbc.getGoodById(id);
    }

    public void addGood(Good good) {
        this.storageJdbc.saveGood(good);
    }

    public void updateGood(Good good, int id) {
        this.storageJdbc.updateGood(good, id);
    }

    public void addQuantity(int id, RequestQuantityDto requestQuantity) {
        if(!isValid(requestQuantity.quantity())){
            throw new ValueIsNotValidException("The quantity is zero or under it!");
        }
        this.storageJdbc.addQuantity(id, requestQuantity);
    }

    public void removeQuantity(int id, RequestQuantityDto requestQuantity) {
        if(!isValid(requestQuantity.quantity())){
            throw new ValueIsNotValidException("The quantity is zero or under it!");
        }
        this.storageJdbc.removeQuantity(id, requestQuantity);
    }

    public void removeGood(int id) {
        this.storageJdbc.deleteGood(id);
    }

    private boolean isValid(int value){
        return value > 0;
    }
}
