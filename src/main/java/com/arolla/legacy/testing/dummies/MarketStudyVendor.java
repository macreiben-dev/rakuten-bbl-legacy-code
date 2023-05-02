package com.arolla.legacy.testing.dummies;

public class MarketStudyVendor {
    private static double _value = 0;

    public static void SetAveragePrice(double value) {
        _value = value;
    }
    public double averagePrice(String blog) {
        System.out.println("Computing average price for: [" + blog + "]");
        return _value;
    }
}
