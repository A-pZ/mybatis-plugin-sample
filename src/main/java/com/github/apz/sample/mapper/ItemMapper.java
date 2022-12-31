package com.github.apz.sample.mapper;

import com.github.apz.sample.repository.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<Item> selectItem(String id);
}
