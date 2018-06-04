package com.spbstu.lab4.enums;

public enum  DIFF_ELEMENTS_DATA{
    CHECK_BOXES(new String[] {"Water", "Earth", "Wind", "Fire"}),
    EXPECTED_CHECK_BOXES(new String[] {"Water", "Wind"}),
    RADIOS(new String[] {"Gold", "Silver", "Bronze", "Selen"}),
    DROP_COLORS(new String[] {"Red", "Green", "Blue", "Yellow"}),
    SELECT_ELEMENTS(new String[] {"Wind: condition changed to true", "Water: condition changed to true", "metal: value changed to Selen", "Colors: value changed to Yellow", "Water: condition changed to false", "Wind: condition changed to false"});

    public String[] strAr;
    DIFF_ELEMENTS_DATA(String[] strings) {
        strAr = strings;
    }
}