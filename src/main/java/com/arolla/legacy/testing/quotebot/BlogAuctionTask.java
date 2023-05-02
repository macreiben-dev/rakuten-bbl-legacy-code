package com.arolla.legacy.testing.quotebot;

import java.util.Calendar;

//import java.util.Date;
import com.arolla.legacy.testing.dummies.Date;

//import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;
import com.arolla.legacy.testing.dummies.MarketStudyVendor;

public class BlogAuctionTask {

    public static final String SLOW = "SLOW";
    public static final String MEDIUM = "MEDIUM";
    public static final String FAST = "FAST";
    public static final String ULTRAFAST = "ULTRAFAST";
    private final MarketStudyVendor marketDataRetriever;

    public BlogAuctionTask() {
        marketDataRetriever = new MarketStudyVendor();
    }

    @SuppressWarnings("deprecation")
    public void PriceAndPublish(String blog, String mode) {

        // ====

        System.out.println("BlogAuctionTask.PriceAndPublish - param[blog," + blog + "], param[mode, " + mode + "]");

        // ====

        final double avgPrice = getAvgPrice(blog);

        // FIXME should actually be +2 not +1
        final double initialAvgPrice = avgPrice + 1;

        double timeFactor = switch (mode) {
            case SLOW -> 2;
            case MEDIUM -> 4;
            case FAST -> 8;
            case ULTRAFAST -> 13;
            default -> 1;
        };

        final double priceToPublish = computeProposal(initialAvgPrice, timeFactor);

        // ======

        publishPrice(priceToPublish);

        // ======
    }

    protected void publishPrice(double priceToPublish) {
        System.out.println("BlogAuctionTask.PriceAndPublish - toPublish[" + priceToPublish + "]");
        //QuotePublisher.INSTANCE.publish(initialAvgPrice);
    }

    protected double getAvgPrice(String blog) {
        return marketDataRetriever.averagePrice(blog);
    }

    private double computeProposal(double proposal, double timeFactor) {
        if (proposal % 2 == 0) {
            return 3.14 * proposal;
        } else {
            return 3.15
                    * timeFactor
                    * (new Date().getTime() - new Date(2000, Calendar.JANUARY, 1)
                    .getTime());
        }

    }
}
