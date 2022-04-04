package com.basterikus.CsMoneyService.service;

import com.basterikus.CsMoneyService.dto.ItemDto;
import com.basterikus.CsMoneyService.exception.LimitRequestException;
import com.basterikus.CsMoneyService.parser.Parser;
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
    public List<ItemDto> getKnivesSkins() {
        log.info("Getting knives skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(2);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or knives isn't found");
        }
        return skins;
    }

    @Cacheable(value = "gloves")
    public List<ItemDto> getGlovesSkins() {
        log.info("Getting gloves skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(13);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or gloves isn't found");
        }
        return skins;
    }

    @Cacheable(value = "pistols")
    public List<ItemDto> getPistolsSkins() {
        log.info("Getting pistols skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(5);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or pistols isn't found");
        }
        return skins;
    }

    @Cacheable(value = "smg")
    public List<ItemDto> getSmgSkins() {
        log.info("Getting smg skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(6);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or smg isn't found");
        }
        return skins;
    }

    @Cacheable(value = "rifles")
    public List<ItemDto> getRiflesSkins() {
        log.info("Getting rifles skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(3);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or rifles isn't found");
        }
        return skins;
    }

    @Cacheable(value = "snipers")
    public List<ItemDto> getSnipersSkins() {
        log.info("Getting snipers skins from CS.MONEY");
        List<ItemDto> skins = parser.parse(4);
        if (skins.isEmpty()) {
            log.error("CS.MONEY isn't answering or snipers isn't found");
        }
        return skins;
    }
}
