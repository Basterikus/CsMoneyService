package com.basterikus.CsMoneyService.dto;

import com.basterikus.CsMoneyService.model.Skin;
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
