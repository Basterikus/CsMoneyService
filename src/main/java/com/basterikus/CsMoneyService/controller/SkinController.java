package com.basterikus.CsMoneyService.controller;

import com.basterikus.CsMoneyService.dto.SkinsDto;
import com.basterikus.CsMoneyService.service.SkinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SkinController {

    private final SkinService skinService;

    @GetMapping("/skins/overprice={overprice}&minPrice={minPrice}&maxPrice={maxPrice}")
    public SkinsDto getSkinsByOverprice(@PathVariable("overprice") int overprice, @PathVariable("minPrice") int minPrice, @PathVariable("maxPrice") int maxPrice) {
        return skinService.getSkinsByOverprice(overprice, minPrice, maxPrice);
    }

    @GetMapping("skins/float={skinFloat}")
    public SkinsDto getSkinsByFloat(@PathVariable double skinFloat) {
        return skinService.getSkinsByFloat(skinFloat);
    }
}
