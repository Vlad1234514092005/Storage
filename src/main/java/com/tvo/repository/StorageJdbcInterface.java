package com.tvo.repository;

import com.tvo.model.Good;
import com.tvo.model.dto.RequestQuantityDto;

import java.util.List;

public interface StorageJdbcInterface {
    List<Good> getAllGoods();

    Good getGoodById(int id);

    void saveGood(Good good);

    void updateGood(Good good, int id);

    void addQuantity(int id, RequestQuantityDto requestQuantity);

    void removeQuantity(int id, RequestQuantityDto requestQuantity);

    void deleteGood(int id);
}
