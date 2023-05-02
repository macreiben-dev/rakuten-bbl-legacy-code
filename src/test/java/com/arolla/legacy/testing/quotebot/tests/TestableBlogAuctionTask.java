package com.arolla.legacy.testing.quotebot.tests;

import com.arolla.legacy.testing.quotebot.BlogAuctionTask;

public class TestableBlogAuctionTask extends BlogAuctionTask {

    private double _price;
    private double _publishedPrice;

    public void setAvgPrice(double price) {
        _price = price;
    }

    public void setPublishedPrice(double price) {
        _publishedPrice = price;
    }

    public double getPublishedPrice() {
        return _publishedPrice;
    }

    @Override
    protected double getAvgPrice(String blog) {
        return _price;
    }

    @Override
    protected void publishPrice(double priceToPublish) {
        _publishedPrice = priceToPublish;
    }
}
