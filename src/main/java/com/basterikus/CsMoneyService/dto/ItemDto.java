package com.basterikus.CsMoneyService.dto;

import lombok.Value;

@Value
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
