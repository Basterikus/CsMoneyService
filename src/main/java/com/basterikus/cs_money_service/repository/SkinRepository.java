package com.basterikus.cs_money_service.repository;

import com.basterikus.cs_money_service.dto.ItemDto;
import com.basterikus.cs_money_service.utils.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class SkinRepository {

    private final Parser parser;

    @Cacheable(value = "knives")
    public List<ItemDto> getKnivesSkins(int minPrice, int maxPrice) {
        log.info("Getting knives skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(2, minPrice, maxPrice);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or knives isn't found");
        }
        return skins;
    }

    @Cacheable(value = "gloves")
    public List<ItemDto> getGlovesSkins(int minPrice, int maxPrice) {
        log.info("Getting gloves skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(13, minPrice, maxPrice);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or gloves isn't found");
        }
        return skins;
    }

    @Cacheable(value = "pistols")
    public List<ItemDto> getPistolsSkins(int minPrice, int maxPrice) {
        log.info("Getting pistols skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(5, minPrice, maxPrice);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or pistols isn't found");
        }
        return skins;
    }

    @Cacheable(value = "smg")
    public List<ItemDto> getSmgSkins(int minPrice, int maxPrice) {
        log.info("Getting smg skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(6, minPrice, maxPrice);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or smg isn't found");
        }
        return skins;
    }

    @Cacheable(value = "rifles")
    public List<ItemDto> getRiflesSkins(int minPrice, int maxPrice) {
        log.info("Getting rifles skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(3, minPrice, maxPrice);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or rifles isn't found");
        }
        return skins;
    }

    @Cacheable(value = "snipers")
    public List<ItemDto> getSnipersSkins(int minPrice, int maxPrice) {
        log.info("Getting snipers skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(4, minPrice, maxPrice);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or snipers isn't found");
        }
        return skins;
    }
}
