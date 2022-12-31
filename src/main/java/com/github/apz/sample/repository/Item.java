package com.github.apz.sample.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor @Getter
public class Item {
    private Long id;
    private String name;
    private LocalDateTime registerDateTime;
}
