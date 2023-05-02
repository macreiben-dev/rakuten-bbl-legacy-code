package com.arolla.legacy.testing.quotebot;

import java.util.Arrays;
import java.util.List;

public class ApplicationAllMode {
    public static void main(String[] args) {
        List<String> allModes = Arrays.asList("SLOW", "MEDIUM", "FAST", "ULTRAFAST");

        for (String currentMode : allModes
             ) {
            AutomaticQuoteBot bot = new AutomaticQuoteBot();
            bot.sendAllQuotes(currentMode);
        }

    }
}
