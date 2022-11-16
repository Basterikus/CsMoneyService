package com.basterikus.cs_money_service.model.enums;

public enum Type {
    KNIFE,
    RIFLE,
    SNIPER,
    PISTOL,
    SMG,
    GLOVES;

    public static Type getType(String type) {
        return switch (type) {
            case "2" -> Type.KNIFE;
            case "3" -> Type.RIFLE;
            case "4" -> Type.SNIPER;
            case "5" -> Type.PISTOL;
            case "6" -> Type.SMG;
            case "13" -> Type.GLOVES;
            default -> null;
        };
    }
}
