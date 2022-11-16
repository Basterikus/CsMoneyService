package com.basterikus.cs_money_service.controller;

import com.basterikus.cs_money_service.dto.SkinsDto;
import com.basterikus.cs_money_service.service.SkinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/skins")
@Tag(name = "skins", description = "Взимодействие с поиском скинов")
public class SkinController {

    private final SkinService skinService;

    @GetMapping
    @Operation(description = "Поиск скинов по скидке")
    public SkinsDto getAllSkinsByOverprice(@RequestParam(value = "overprice") int overprice,
                                        @RequestParam(value = "minPrice", defaultValue = "2000") int minPrice,
                                        @RequestParam(value = "maxPrice", defaultValue = "10000") int maxPrice,
                                        @RequestParam(value = "type", required = false) String type) {

        return skinService.getSkinsByOverprice(overprice, minPrice, maxPrice, type);
    }

    @GetMapping("float")
    @Operation(description = "Поиск скинов по поношенности")
    public SkinsDto getAllSkinsByFloat(@RequestParam(value = "skinFloat") double skinFloat,
                                    @RequestParam(value = "minPrice", defaultValue = "2000") int minPrice,
                                    @RequestParam(value = "maxPrice", defaultValue = "10000") int maxPrice,
                                    @RequestParam(value = "type", required = false) String type) {

        return skinService.getSkinsByFloat(skinFloat, minPrice, maxPrice, type);
    }
}
