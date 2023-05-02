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

		double avgPrice = marketDataRetriever.averagePrice(blog);
		// FIXME should actually be +2 not +1
		double initialAvgPrice = avgPrice + 1;
		double timeFactor = 1;

		if (mode.equals(SLOW)) {
			timeFactor = 2;
		}
		if (mode.equals(MEDIUM)) {
			timeFactor = 4;
		}
		if (mode.equals(FAST)) {
			timeFactor = 8;
		}
		if (mode.equals(ULTRAFAST)) {
			timeFactor = 13;
		}

//		if (initialAvgPrice % 2 == 0) {
//			initialAvgPrice = 3.14 * initialAvgPrice;
//		} else {
//			initialAvgPrice = 3.15
//					* timeFactor
//					* (new Date().getTime() - new Date(2000, Calendar.JANUARY, 1)
//					.getTime());
//		}

		double priceToPublish = computeProposal(initialAvgPrice, timeFactor);

		// ======

		System.out.println("BlogAuctionTask.PriceAndPublish - toPublish[" + priceToPublish + "]");
		//QuotePublisher.INSTANCE.publish(initialAvgPrice);

		// ======
	}

	private double computeProposal(double proposal, double timeFactor) {
		if (proposal % 2 == 0) {
			return  3.14 * proposal;
		} else {
			return 3.15
					* timeFactor
					* (new Date().getTime() - new Date(2000, Calendar.JANUARY, 1)
					.getTime());
		}

	}
}
