package com.basterikus.cs_money_service.service.impl;

import com.basterikus.cs_money_service.dto.ItemDto;
import com.basterikus.cs_money_service.dto.SkinsDto;
import com.basterikus.cs_money_service.exception.RequestException;
import com.basterikus.cs_money_service.model.enums.Quality;
import com.basterikus.cs_money_service.model.Skin;
import com.basterikus.cs_money_service.model.enums.Type;
import com.basterikus.cs_money_service.repository.SkinRepository;
import com.basterikus.cs_money_service.service.SkinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CsMoneySkinService implements SkinService {

    private final SkinRepository skinRepository;

    private List<ItemDto> getAllItems(int minPrice, int maxPrice) {
        List<ItemDto> allItems = new ArrayList<>();
        allItems.addAll(skinRepository.getKnivesSkins(minPrice, maxPrice));
        allItems.addAll(skinRepository.getGlovesSkins(minPrice, maxPrice));
        allItems.addAll(skinRepository.getSmgSkins(minPrice, maxPrice));
        allItems.addAll(skinRepository.getPistolsSkins(minPrice, maxPrice));
        allItems.addAll(skinRepository.getRiflesSkins(minPrice, maxPrice));
        allItems.addAll(skinRepository.getSnipersSkins(minPrice, maxPrice));
        return allItems;
    }

    public List<ItemDto> getItemsForType(int minPrice, int maxPrice, String type) {
        List<ItemDto> result = new ArrayList<>();
        switch (type) {
            case "knife" -> result.addAll(skinRepository.getKnivesSkins(minPrice, maxPrice));
            case "gloves" -> result.addAll(skinRepository.getGlovesSkins(minPrice, maxPrice));
            case "smg" -> result.addAll(skinRepository.getSmgSkins(minPrice, maxPrice));
            case "pistol" -> result.addAll(skinRepository.getPistolsSkins(minPrice, maxPrice));
            case "rifle" -> result.addAll(skinRepository.getRiflesSkins(minPrice, maxPrice));
            case "sniper" -> result.addAll(skinRepository.getSnipersSkins(minPrice, maxPrice));
            default -> throw new RequestException("Wrong type");
        }
        return result;
    }

    @Override
    public SkinsDto getSkinsByOverprice(int overprice, int minPrice, int maxPrice, String type) {
        List<ItemDto> allItems = new ArrayList<>();
        if (type != null) {
            allItems.addAll(getItemsForType(minPrice, maxPrice, type));
        } else allItems.addAll(getAllItems(minPrice, maxPrice));

        List<ItemDto> result = allItems.stream()
                .filter(i -> i.getOverprice() < overprice && i.getPrice() > minPrice && i.getPrice() < maxPrice)
                .sorted(Comparator.comparingDouble(ItemDto::getOverprice))
                .toList();

        List<Skin> skins = result.stream()
                .map(i ->
                        Skin.builder()
                                .name(i.getName())
                                .skin3d(i.getSkin3d())
                                .type(Type.getType(i.getType()))
                                .skinFloat(i.getSkinFloat())
                                .quality(Quality.getQuality(i.getQuality()))
                                .overprice(i.getOverprice())
                                .price(i.getPrice())
                                .build()
                )
                .toList();
        return new SkinsDto(skins);
    }

    @Override
    public SkinsDto getSkinsByFloat(double skinFloat, int minPrice, int maxPrice, String type) {
        List<ItemDto> allItems = new ArrayList<>();
        if (type != null) {
            allItems.addAll(getItemsForType(minPrice, maxPrice, type));
        } else allItems.addAll(getAllItems(minPrice, maxPrice));

        List<ItemDto> result = allItems.stream()
                .filter(i -> i.getSkinFloat() < skinFloat)
                .sorted(Comparator.comparingDouble(ItemDto::getSkinFloat))
                .toList();

        List<Skin> skins = result.stream()
                .map(i ->
                        Skin.builder()
                                .name(i.getName())
                                .skin3d(i.getSkin3d())
                                .type(Type.getType(i.getType()))
                                .skinFloat(i.getSkinFloat())
                                .quality(Quality.getQuality(i.getQuality()))
                                .overprice(i.getOverprice())
                                .price(i.getPrice())
                                .build()
                )
                .toList();
        return new SkinsDto(skins);
    }


}
