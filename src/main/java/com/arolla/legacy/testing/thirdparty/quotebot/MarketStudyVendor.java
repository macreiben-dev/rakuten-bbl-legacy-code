package com.arolla.legacy.testing.thirdparty.quotebot;

import java.util.Random;

import javax.swing.JOptionPane;

public class MarketStudyVendor {

    public static final int ONE_SECOND = 1000;

    public double averagePrice(String blog) {
        if (System.getenv("license") == null) {
            JOptionPane.showMessageDialog(null, "Missing license !",
                    "Stupid license", JOptionPane.WARNING_MESSAGE);
            throw new RuntimeException("");
        }

        SomeComputingThatTakesRandomTime();

        return ((double) blog.hashCode() * (new Random()).nextDouble());
    }

    private static void SomeComputingThatTakesRandomTime() {
        var someProcessingTime = new Random().nextInt(10) * ONE_SECOND;

        try {
            Thread.sleep(someProcessingTime);
        } catch (InterruptedException e) {

        }
    }

}
