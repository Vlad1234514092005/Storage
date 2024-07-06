package com.tvo.repository;

import com.tvo.model.Good;

public interface StorageJdbcInterface {
    public void getAllGoods();

    public void getGoodById(int id);

    public boolean saveGood(Good good, int quantity);

    public boolean updateGood(Good good, int id);

    public boolean deleteGood(int id, int quantity);
}
