package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.dummies.MarketStudyVendor;

import java.util.Arrays;
import java.util.List;

public class ApplicationAllMode {
    public static void main(String[] args) {
        MarketStudyVendor.SetAveragePrice(5);

        computeForAllMode();

        MarketStudyVendor.SetAveragePrice(6);

        computeForAllMode();
    }

    private static void computeForAllMode() {
        List<String> allModes = Arrays.asList("SLOW", "MEDIUM", "FAST", "ULTRAFAST");

        for (String currentMode : allModes
             ) {
            AutomaticQuoteBot bot = new AutomaticQuoteBot();
            bot.sendAllQuotes(currentMode);
        }
    }
}
