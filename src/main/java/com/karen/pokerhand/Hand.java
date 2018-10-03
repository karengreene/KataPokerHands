package com.karen.pokerhand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Hand implements Comparable<Hand> {

	private List<Card> cards = new ArrayList<Card>();
	private static final int NUMBEROFCARDSINHAND = 5;
	private Integer[] cardValues;
	private Integer[] sameKindCounts;
	private Integer[] sameKinds;
	private Integer[] kickers;

	public Hand(List<Card> cards) {
		this.cards = cards;
		populateCardValues();
		populateSameKindCounts();
		populateCardTypes();

	}

	private void populateCardValues() {

		cardValues = new Integer[NUMBEROFCARDSINHAND];
		for (int i = 0; i < cards.size(); i++) 
			cardValues[i] = cards.get(i).getCardValue();
		
		Arrays.sort(cardValues, Collections.reverseOrder());

	}

	private void populateSameKindCounts() {

		sameKindCounts = new Integer[Rank.values().length];
		Arrays.fill(sameKindCounts, Integer.valueOf(0));
		for (int i = 0; i < cardValues.length; i++)
			sameKindCounts[cardValues[i]]++;

	}

	private void populateCardTypes() {

		ArrayList<Integer> sameKinds = new ArrayList<Integer>();
		ArrayList<Integer> kickers = new ArrayList<Integer>();

		for (int i = 0; i < sameKindCounts.length; i++) {
			if (sameKindCounts[i] > 1)
				sameKinds.add(i);
			if (sameKindCounts[i] == 1)
				kickers.add(i);
		}

		Collections.sort(sameKinds, Collections.reverseOrder());
		Collections.sort(kickers, Collections.reverseOrder());
		this.sameKinds = sameKinds.toArray(new Integer[sameKinds.size()]);
		this.kickers = kickers.toArray(new Integer[kickers.size()]);
	}

	private long numberOfPairs() {
		return Arrays.stream(sameKindCounts).filter(x -> x == 2).count();
	}

	public boolean hasThreeOfAKind() {
		return Arrays.stream(sameKindCounts).anyMatch(x -> x == 3);
	}

	public boolean hasFourOfAKind() {
		return Arrays.stream(sameKindCounts).anyMatch(x -> x == 4);
	}

	public boolean hasTwoPair() {

		if (numberOfPairs() == 2)
			return true;

		return false;

	}

	public boolean hasOnePair() {

		if (numberOfPairs() == 1)
			return true;

		return false;
	}

	public boolean isFullHouse() {

		if (hasOnePair() && hasThreeOfAKind())
			return true;

		return false;
	}

	public boolean isStraight() {

		int counter = 0;
		boolean isStraight = false;

		for (int i = 1; i < cardValues.length; i++)
			if (cardValues[i] == cardValues[i - 1] - 1)
				counter++;

		if (counter == 4)
			isStraight = true;

		return isStraight;
	}

	public boolean isFlush() {
		int[] suitOrdinal = new int[NUMBEROFCARDSINHAND];

		for (int i = 0; i < cards.size(); i++)
			suitOrdinal[cards.get(i).getSuit().ordinal()]++;

		return IntStream.of(suitOrdinal).anyMatch(x -> x == 5);
	}

	public boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	public int calculateRank() {

		if (isStraightFlush())
			return 8;

		if (hasFourOfAKind()) 
			return 7;		

		if (isFullHouse())
			return 6;

		if (isFlush())
			return 5;

		if (isStraight())
			return 4;

		if (hasThreeOfAKind()) 
			return 3;		

		if (hasTwoPair()) 
			return 2;
		
		if (hasOnePair()) 
			return 1;
		

		return 0;

	}

	private int compareHighestKickers(Hand otherHand) {

		int highestKickers = 0;

		for (int i = 0; i < kickers.length; i++) {

			int thisCardValue = kickers[i];
			int otherCardValue = otherHand.kickers[i];

			highestKickers += Integer.valueOf(thisCardValue).compareTo(otherCardValue);
			if (highestKickers != 0)
				break;
		}

		return highestKickers > 0 ? 1 : highestKickers < 0 ? -1 : 0;
	}

	private int compareHighestKind(Hand otherHand) {

		int highestKickers = 0;

		for (int i = 0; i < sameKinds.length; i++) {
			int thisCardValue = sameKinds[i];
			int otherCardValue = otherHand.sameKinds[i];
			highestKickers += Integer.valueOf(thisCardValue).compareTo(otherCardValue);
		}

		return highestKickers > 0 ? 1 : highestKickers < 0 ? -1 : 0;
	}

	@Override
	public int compareTo(Hand hand) {

		int compare = -2;

		int thisCardRank = this.calculateRank();
		int otherCardRank = hand.calculateRank();
		int rank = Integer.valueOf(thisCardRank).compareTo(otherCardRank);
		int compareHighestKind = 0;

		// if the hands have the same type of hand (pair, straight, two pair), etc.
		// then, also need to find out highest set of that type
		if (rank == 0 && (thisCardRank > 0 || otherCardRank > 0)) {
			compareHighestKind = compareHighestKind(hand);
			if (compareHighestKind == 0)
				// if hands of same cards in that rank, then compare kickers
				compare = compareHighestKickers(hand);
			else
				compare = compareHighestKind;
		} else if (rank > 0)
			compare = rank;
		else
			compare = compareHighestKickers(hand);

		return compare;
	}

}
