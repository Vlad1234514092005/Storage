package com.tvo.service;

import com.tvo.model.Good;
import com.tvo.repository.StorageJdbcInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    private StorageJdbcInterface storageJdbc;

    @Autowired
    public StorageService(StorageJdbcInterface storageJdbc){
        this.storageJdbc = storageJdbc;
    }


    public void getAllGoods(){
        this.storageJdbc.getAllGoods();
    }

    public void getGoodById(int id){
        this.storageJdbc.getGoodById(id);
    }

    public boolean addGood(Good good, int quantity){

    }

    public boolean updateGood(Good good, int id){

    }

    public boolean removeGood(int id, int quantity){

    }
}
