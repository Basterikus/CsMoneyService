package com.basterikus.CsMoneyService.service;

import com.basterikus.CsMoneyService.dto.ItemDto;
import com.basterikus.CsMoneyService.dto.SkinsDto;
import com.basterikus.CsMoneyService.model.Quality;
import com.basterikus.CsMoneyService.model.Skin;
import com.basterikus.CsMoneyService.model.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CsMoneySkinService implements SkinService {

    private final SkinRepository skinRepository;

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemDto> allItems = new ArrayList<>();
        allItems.addAll(skinRepository.getKnivesSkins());
        allItems.addAll(skinRepository.getGlovesSkins());
        allItems.addAll(skinRepository.getSmgSkins());
        allItems.addAll(skinRepository.getPistolsSkins());
        allItems.addAll(skinRepository.getRiflesSkins());
        allItems.addAll(skinRepository.getSnipersSkins());
        return allItems;
    }

    @Override
    public SkinsDto getSkinsByOverprice(int overprice, int minPrice, int maxPrice) {
        List<ItemDto> allItems = getAllItems();

        List<ItemDto> result = allItems.stream()
                .filter(i -> i.getOverprice() < overprice && i.getPrice() > minPrice && i.getPrice() < maxPrice)
                .toList();

        List<Skin> skins = result.stream()
                .map(i -> {
                    return Skin.builder()
                            .name(i.getName())
                            .skin3d(i.getSkin3d())
                            .type(Type.getType(i.getType()))
                            .skinFloat(i.getSkinFloat())
                            .quality(Quality.getQuality(i.getQuality()))
                            .overprice(i.getOverprice())
                            .price(i.getPrice())
                            .build();
                })
                .toList();
        return new SkinsDto(skins);
    }

    @Override
    public SkinsDto getSkinsByFloat(double skinFloat) {
        List<ItemDto> allItems = getAllItems();

        List<ItemDto> result = allItems.stream()
                .filter(i -> i.getSkinFloat() < skinFloat)
                .toList();

        List<Skin> skins = result.stream()
                .map(i -> {
                    return Skin.builder()
                            .name(i.getName())
                            .skin3d(i.getSkin3d())
                            .type(Type.getType(i.getType()))
                            .skinFloat(i.getSkinFloat())
                            .quality(Quality.getQuality(i.getQuality()))
                            .overprice(i.getOverprice())
                            .price(i.getPrice())
                            .build();
                })
                .toList();
        return new SkinsDto(skins);
    }


}
