package com.shutl.utils;

public class PriceUtils {
    public static Long getPriceByPostcode(String postCode1, String postCode2) {
        return Math.abs((Long.valueOf(postCode1, 36)
                - Long.valueOf(postCode2, 36))/100000000);
    }

    public static Long getMarkedUpPrice(Long originalPrice, int markup) {
        return (Long) Math.round(originalPrice * (1 + markup / 100d));
    }
}
