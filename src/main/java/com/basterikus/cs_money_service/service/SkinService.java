package com.basterikus.cs_money_service.service;

import com.basterikus.cs_money_service.dto.SkinsDto;

public interface SkinService {

    SkinsDto getSkinsByOverprice(int overprice, int minPrice, int maxPrice, String type);
    SkinsDto getSkinsByFloat(double skinFloat, int minPrice, int maxPrice, String type);
}
