package com.github.apz.sample.controller;

import com.github.apz.sample.repository.Item;
import com.github.apz.sample.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class SampleController {
    ItemRepository itemRepository;

    @GetMapping("/{id}")
    public List<Item> item(@PathVariable("id") String id) {
        return itemRepository.findById(id);
    }
}
