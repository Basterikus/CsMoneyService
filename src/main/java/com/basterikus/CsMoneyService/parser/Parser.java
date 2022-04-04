package com.basterikus.CsMoneyService.parser;

import com.basterikus.CsMoneyService.dto.ItemDto;

import java.util.List;

public interface Parser {
    List<ItemDto> parse(int type);
}
