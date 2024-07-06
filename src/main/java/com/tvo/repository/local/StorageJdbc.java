package com.tvo.repository.local;

import com.tvo.model.Good;
import com.tvo.repository.StorageJdbcInterface;
import org.springframework.stereotype.Repository;

@Repository
public class StorageJdbc implements StorageJdbcInterface {
    @Override
    public void getAllGoods() {

    }

    @Override
    public void getGoodById(int id) {

    }

    @Override
    public boolean saveGood(Good good, int quantity) {
        return false;
    }

    @Override
    public boolean updateGood(Good good, int id) {
        return false;
    }

    @Override
    public boolean deleteGood(int id, int quantity) {
        return false;
    }
}
