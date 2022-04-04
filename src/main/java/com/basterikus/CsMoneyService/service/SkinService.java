package com.basterikus.CsMoneyService.service;

import com.basterikus.CsMoneyService.dto.ItemDto;
import com.basterikus.CsMoneyService.dto.SkinsDto;

import java.math.BigDecimal;
import java.util.List;

public interface SkinService {

    SkinsDto getSkinsByOverprice(int overprice, int minPrice, int maxPrice);
    SkinsDto getSkinsByFloat(double skinFloat);
    List<ItemDto> getAllItems();
}
