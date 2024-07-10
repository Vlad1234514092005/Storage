package com.tvo.repository.local;

import com.tvo.exception.GoodNotFoundException;
import com.tvo.exception.QuantityUnderZeroException;
import com.tvo.model.Good;
import com.tvo.model.dto.RequestQuantityDto;
import com.tvo.repository.StorageJdbcInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StorageJdbc implements StorageJdbcInterface {

    private static final BeanPropertyRowMapper<Good> GOOD_ROW_MAPPER = new BeanPropertyRowMapper<>(Good.class);
    private final NamedParameterJdbcOperations jdbcTemplate;

    @Override
    public List<Good> getAllGoods() {
        String selectAllGoods =
                """
                        SELECT *
                        FROM good;
                        """;

        return jdbcTemplate.query(selectAllGoods, GOOD_ROW_MAPPER);
    }

    @Override
    public Good getGoodById(int id) {
        String selectGoodById =
                """
                        SELECT *
                        FROM good
                        WHERE id = %s
                        """;
        List<Good> goodList = jdbcTemplate.query(selectGoodById.formatted(id), GOOD_ROW_MAPPER);
        if (goodList.isEmpty()) {
            throw new GoodNotFoundException("This good is not in storage");
        }
        return goodList.get(0);
    }

    @Override
    public void saveGood(Good good) {
        String insertIntoTable = """
                INSERT INTO good(name, manufacturer, description, quantity, price)
                VALUES(:name, :manufacturer, :description, :quantity, :price);
                """;
        jdbcTemplate.update(insertIntoTable, Map.of(
                        "name", good.getName(),
                        "manufacturer", good.getManufacturer(),
                        "description", good.getDescription(),
                        "quantity", good.getQuantity(),
                        "price", good.getPrice()
                )
        );
    }

    @Override
    public void updateGood(Good good, int id) {
        String updateGood = """
                UPDATE good
                SET name = :name, manufacturer = :manufacturer, description = :description, quantity = :quantity, price = :price
                WHERE id = :id;
                """;
        jdbcTemplate.update(updateGood, Map.of(
                "id", id,
                "name", good.getName(),
                "manufacturer", good.getManufacturer(),
                "description", good.getDescription(),
                "quantity", good.getQuantity(),
                "price", good.getPrice()
        ));
    }

    @Override
    public void addQuantity(int id, RequestQuantityDto requestQuantity) {
        String getQuantity = """
                SELECT quantity
                FROM good
                WHERE id = :id
                """;
        Integer currentQuantity = jdbcTemplate.queryForObject(getQuantity.formatted(id), new HashMap<>(), Integer.class);
        currentQuantity += requestQuantity.quantity();

        String updateQuantity = """
                UPDATE good
                SET quantity = :quantity
                WHERE id = :id;
                """;
        jdbcTemplate.update(updateQuantity, Map.of(
                "id", id,
                "quantity", requestQuantity.quantity()
        ));
    }

    @Override
    public void removeQuantity(int id, RequestQuantityDto requestQuantity) {
        String getQuantity = """
                SELECT quantity
                FROM good
                WHERE id = :id
                """;
        Integer currentQuantity = jdbcTemplate.queryForObject(getQuantity.formatted(id), new HashMap<>(), Integer.class);
        currentQuantity -= requestQuantity.quantity();
        if(currentQuantity < 0){
            throw new QuantityUnderZeroException("The quantity is under zero");
        }

        String updateQuantity = """
                UPDATE good
                SET quantity = :quantity
                WHERE id = :id;
                """;
        jdbcTemplate.update(updateQuantity, Map.of(
                "id", id,
                "quantity", requestQuantity.quantity()
        ));
    }

    @Override
    public void deleteGood(int id) {
        String removeFromGoods = """
                DELETE FROM good
                WHERE id = :id;
                """;
        jdbcTemplate.update(removeFromGoods, Map.of(
                "id", id
        ));
    }
}
