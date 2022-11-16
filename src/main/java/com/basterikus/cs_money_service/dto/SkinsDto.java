package com.basterikus.cs_money_service.dto;

import com.basterikus.cs_money_service.model.Skin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkinsDto {
    List<Skin> skins;
}
