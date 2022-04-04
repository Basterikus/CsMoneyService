package com.basterikus.CsMoneyService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class Skin {
    String name;
    String skin3d;
    Type type;
    double skinFloat;
    Quality quality;
    double price;
    double overprice;
}
