package com.basterikus.cs_money_service.model;

import com.basterikus.cs_money_service.model.enums.Quality;
import com.basterikus.cs_money_service.model.enums.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skin {
    String name;
    String skin3d;
    Type type;
    double skinFloat;
    Quality quality;
    double price;
    double overprice;
}
