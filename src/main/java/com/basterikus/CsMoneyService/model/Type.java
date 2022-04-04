package com.basterikus.CsMoneyService.model;

public enum Type {
    KNIFE,
    AK,
    GLOVES;

    public static Type getType(String type) {
        return switch (type) {
            case "2" -> Type.KNIFE;
            case "1" -> Type.AK;
            case "13" -> Type.GLOVES;
            default -> null;
        };
    }
}
