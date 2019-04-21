package com.shutl.utils;

import com.shutl.utils.PriceUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceUtilsTests {
    @Test
    public void testGetPriceByPostcode() {
        Long price = PriceUtils.getPriceByPostcode("SW1A1AA", "EC2A3LT");
        assertEquals(new Long(316), price);
    }

    @Test
    public void getMarkedUpPrice() {
        Long price = PriceUtils.getMarkedUpPrice(new Long(100), 32);
        assertEquals(new Long(132), price);
    }
}
