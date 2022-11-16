package com.basterikus.cs_money_service.model.enums;

public enum Quality {
    MINIMAL_WEAR,
    FACTORY_NEW,
    FIELD_TESTED,
    WELL_WORN,
    BATTLE_SCARRED,
    UNKNOWN;

    public static Quality getQuality(String quality) {
        return switch (quality) {
            case "mw" -> Quality.MINIMAL_WEAR;
            case "fn" -> Quality.FACTORY_NEW;
            case "ft" -> Quality.FIELD_TESTED;
            case "ww" -> Quality.WELL_WORN;
            case "bs" -> Quality.BATTLE_SCARRED;
            case "unknown" -> Quality.UNKNOWN;
            default -> null;
        };
    }
}
