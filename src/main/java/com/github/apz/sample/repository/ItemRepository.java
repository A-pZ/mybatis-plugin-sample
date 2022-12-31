package com.github.apz.sample.repository;

import com.github.apz.sample.mapper.ItemMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ItemRepository {
    ItemMapper itemMapper;

    public List<Item> findById(String id) {
        return itemMapper.selectItem(id);
    }
}
