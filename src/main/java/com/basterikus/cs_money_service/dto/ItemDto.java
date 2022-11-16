package com.basterikus.cs_money_service.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemDto {
    String name;
    long id;
    String skin3d;
    String type;
    double skinFloat;
    String quality;
    String img;
    String statTrak;
    String rarity;
    String screenshot;
    String stickers;
    double price;
    double overprice;
}
