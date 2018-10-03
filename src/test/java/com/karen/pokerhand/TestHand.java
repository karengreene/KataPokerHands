package com.karen.pokerhand;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestHand {

	@Test
	public void testHasTwoPair_True() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.FIVE));
		cards.add(new Card(Suit.D, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.EIGHT));
		cards.add(new Card(Suit.D, Rank.EIGHT));
		cards.add(new Card(Suit.H, Rank.FOUR));
		Hand hand = new Hand(cards);

		assertEquals(true, hand.hasTwoPair());
	}

	@Test
	public void testHasTwoPair_False() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.D, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.EIGHT));
		cards.add(new Card(Suit.D, Rank.EIGHT));
		cards.add(new Card(Suit.H, Rank.FOUR));
		Hand hand = new Hand(cards);

		assertEquals(false, hand.hasTwoPair());
	}

	@Test
	public void testHasOnePair_True() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.SEVEN));
		cards.add(new Card(Suit.D, Rank.SEVEN));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.D, Rank.EIGHT));
		cards.add(new Card(Suit.H, Rank.KING));
		Hand hand = new Hand(cards);

		assertEquals(true, hand.hasOnePair());

	}

	@Test
	public void testHasOnePair_False() {
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.D, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.EIGHT));
		cards.add(new Card(Suit.D, Rank.NINE));
		cards.add(new Card(Suit.H, Rank.FOUR));
		Hand hand = new Hand(cards);

		assertEquals(false, hand.hasOnePair());
	}

	@Test
	public void testIsFullHouse_True() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.D, Rank.ACE));
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.D, Rank.NINE));
		cards.add(new Card(Suit.H, Rank.NINE));
		Hand hand = new Hand(cards);

		assertEquals(true, hand.isFullHouse());

	}

	@Test
	public void testIsStraight_True() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.THREE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.SIX));
		cards.add(new Card(Suit.H, Rank.SEVEN));
		Hand hand = new Hand(cards);

		assertEquals(true, hand.isStraight());

		// a straight flush is still a straight
		cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.THREE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.SIX));
		cards.add(new Card(Suit.C, Rank.SEVEN));
		hand = new Hand(cards);

		assertEquals(true, hand.isStraight());

	}

	@Test
	public void testIsStraight_False() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.THREE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.SIX));
		cards.add(new Card(Suit.C, Rank.EIGHT));
		Hand hand = new Hand(cards);

		assertEquals(false, hand.isStraight());

	}

	@Test
	public void testHasThreeOfAKind_True() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.D, Rank.ACE));
		cards.add(new Card(Suit.H, Rank.ACE));
		cards.add(new Card(Suit.D, Rank.EIGHT));
		cards.add(new Card(Suit.H, Rank.KING));
		Hand hand = new Hand(cards);

		assertEquals(true, hand.hasThreeOfAKind());

	}

	@Test
	public void testHasThreeOfAKind_False() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.D, Rank.ACE));
		cards.add(new Card(Suit.H, Rank.EIGHT));
		cards.add(new Card(Suit.D, Rank.EIGHT));
		cards.add(new Card(Suit.H, Rank.KING));
		Hand hand = new Hand(cards);

		assertEquals(false, hand.hasThreeOfAKind());

	}

	@Test
	public void testIsFlush_True() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.C, Rank.EIGHT));
		cards.add(new Card(Suit.C, Rank.KING));
		Hand hand = new Hand(cards);

		assertEquals(true, hand.isFlush());

	}

	@Test
	public void testIsFlush_False() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.ACE));
		cards.add(new Card(Suit.C, Rank.EIGHT));
		cards.add(new Card(Suit.H, Rank.KING));
		Hand hand = new Hand(cards);

		assertEquals(false, hand.isFlush());

	}

	@Test
	public void testIsStraightFlush_True() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.THREE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.SIX));
		cards.add(new Card(Suit.C, Rank.SEVEN));
		Hand hand = new Hand(cards);

		assertEquals(true, hand.isStraightFlush());

	}

	@Test
	public void testIsStraightFlush_False() {

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.THREE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.SIX));
		cards.add(new Card(Suit.H, Rank.SEVEN));
		Hand hand = new Hand(cards);

		assertEquals(false, hand.isStraightFlush());

		cards = new ArrayList<Card>();
		cards.add(new Card(Suit.C, Rank.THREE));
		cards.add(new Card(Suit.C, Rank.FOUR));
		cards.add(new Card(Suit.C, Rank.FIVE));
		cards.add(new Card(Suit.C, Rank.SIX));
		cards.add(new Card(Suit.C, Rank.EIGHT));
		hand = new Hand(cards);

		assertEquals(false, hand.isStraightFlush());

	}

	@Test
	public void testCompareHands_SameHands() {

		List<Card> cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.C, Rank.THREE));
		cards1.add(new Card(Suit.C, Rank.FOUR));
		cards1.add(new Card(Suit.C, Rank.FIVE));
		cards1.add(new Card(Suit.C, Rank.SIX));
		cards1.add(new Card(Suit.C, Rank.SEVEN));
		Hand hand1 = new Hand(cards1);

		List<Card> cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.C, Rank.FIVE));
		cards2.add(new Card(Suit.C, Rank.THREE));
		cards2.add(new Card(Suit.C, Rank.SEVEN));
		cards2.add(new Card(Suit.C, Rank.FOUR));
		cards2.add(new Card(Suit.C, Rank.SIX));
		Hand hand2 = new Hand(cards2);

		assertEquals(0, hand1.compareTo(hand2));
	}

	@Test
	public void testCompareHands_HighHand_UniqueNumberedCards() {

		List<Card> cards1 = new ArrayList<Card>();
		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.C, Rank.THREE));
		cards1.add(new Card(Suit.C, Rank.FOUR));
		cards1.add(new Card(Suit.C, Rank.FIVE));
		cards1.add(new Card(Suit.C, Rank.SIX));
		cards1.add(new Card(Suit.H, Rank.EIGHT));
		Hand hand1 = new Hand(cards1);

		List<Card> cards2 = new ArrayList<Card>();
		cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.C, Rank.THREE));
		cards2.add(new Card(Suit.C, Rank.FOUR));
		cards2.add(new Card(Suit.C, Rank.FIVE));
		cards2.add(new Card(Suit.C, Rank.SIX));
		cards2.add(new Card(Suit.H, Rank.NINE));
		Hand hand2 = new Hand(cards2);

		assertEquals(-1, hand1.compareTo(hand2));

	}

	@Test
	public void testCompareHands_HighHand_OnePair() {

		List<Card> cards1 = new ArrayList<Card>();
		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.C, Rank.ACE));
		cards1.add(new Card(Suit.H, Rank.ACE));
		cards1.add(new Card(Suit.C, Rank.FIVE));
		cards1.add(new Card(Suit.C, Rank.SIX));
		cards1.add(new Card(Suit.C, Rank.SEVEN));
		Hand hand1 = new Hand(cards1);

		List<Card> cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.C, Rank.ACE));
		cards2.add(new Card(Suit.H, Rank.ACE));
		cards2.add(new Card(Suit.C, Rank.FIVE));
		cards2.add(new Card(Suit.C, Rank.SIX));
		cards2.add(new Card(Suit.C, Rank.NINE));
		Hand hand2 = new Hand(cards2);

		assertEquals(-1, hand1.compareTo(hand2));
	}

	@Test
	public void testCompareHands_HighHand_TwoPair() {

// ====== second hand has the highest pair, same kicker

		List<Card> cards1 = new ArrayList<Card>();
		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.C, Rank.ACE));
		cards1.add(new Card(Suit.H, Rank.ACE));
		cards1.add(new Card(Suit.C, Rank.THREE));
		cards1.add(new Card(Suit.C, Rank.THREE));
		cards1.add(new Card(Suit.C, Rank.SEVEN));
		Hand hand1 = new Hand(cards1);

		List<Card> cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.C, Rank.ACE));
		cards2.add(new Card(Suit.H, Rank.ACE));
		cards2.add(new Card(Suit.C, Rank.FIVE));
		cards2.add(new Card(Suit.C, Rank.FIVE));
		cards2.add(new Card(Suit.C, Rank.SEVEN));
		Hand hand2 = new Hand(cards2);

		assertEquals(-1, hand1.compareTo(hand2));

// ====  second hand has the highest pair, lowest kicker		

		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.C, Rank.ACE));
		cards1.add(new Card(Suit.H, Rank.ACE));
		cards1.add(new Card(Suit.C, Rank.THREE));
		cards1.add(new Card(Suit.C, Rank.THREE));
		cards1.add(new Card(Suit.C, Rank.SEVEN));
		hand1 = new Hand(cards1);

		cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.C, Rank.ACE));
		cards2.add(new Card(Suit.H, Rank.ACE));
		cards2.add(new Card(Suit.C, Rank.FIVE));
		cards2.add(new Card(Suit.C, Rank.FIVE));
		cards2.add(new Card(Suit.C, Rank.FOUR));
		hand2 = new Hand(cards2);

		assertEquals(-1, hand1.compareTo(hand2));

		

	}
	
	@Test
	public void testHandCompare_TestCase1()
	{
		//Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH
		//None of the same kind of cards in either hand, so only kickers
		//White has the highest card, so it should win
		
		List<Card> cards1 = new ArrayList<Card>();
		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.H, Rank.TWO));
		cards1.add(new Card(Suit.D, Rank.THREE));
		cards1.add(new Card(Suit.S, Rank.FIVE));
		cards1.add(new Card(Suit.C, Rank.NINE));
		cards1.add(new Card(Suit.D, Rank.KING));
		Hand hand1 = new Hand(cards1);

		List<Card> cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.C, Rank.TWO));
		cards2.add(new Card(Suit.H, Rank.THREE));
		cards2.add(new Card(Suit.S, Rank.FOUR));
		cards2.add(new Card(Suit.C, Rank.EIGHT));
		cards2.add(new Card(Suit.H, Rank.ACE));
		Hand hand2 = new Hand(cards2);
		
		assertEquals(-1, hand1.compareTo(hand2));

	}
	
	@Test
	public void testHandCompare_TestCase2()
	{
		//Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S
		//Black should win since it is a full house
		
		//full house
		List<Card> cards1 = new ArrayList<Card>();
		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.H, Rank.TWO));
		cards1.add(new Card(Suit.S, Rank.FOUR));
		cards1.add(new Card(Suit.C, Rank.FOUR));
		cards1.add(new Card(Suit.D, Rank.TWO));
		cards1.add(new Card(Suit.H, Rank.FOUR));
		Hand hand1 = new Hand(cards1);

		//flush
		List<Card> cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.S, Rank.TWO));
		cards2.add(new Card(Suit.S, Rank.THREE));
		cards2.add(new Card(Suit.S, Rank.EIGHT));
		cards2.add(new Card(Suit.S, Rank.QUEEN));
		cards2.add(new Card(Suit.S, Rank.ACE));
		
		Hand hand2 = new Hand(cards2);
		
		assertEquals(1, hand1.compareTo(hand2));

	}
	
	@Test
	public void testHandCompare_TestCase3()
	{
		//Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C KH
		//No same rank cards, so only kickers
		//White wins since it has high card
		List<Card> cards1 = new ArrayList<Card>();
		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.H, Rank.TWO));
		cards1.add(new Card(Suit.D, Rank.THREE));
		cards1.add(new Card(Suit.S, Rank.FIVE));
		cards1.add(new Card(Suit.C, Rank.NINE));
		cards1.add(new Card(Suit.D, Rank.KING));
		Hand hand1 = new Hand(cards1);

		List<Card> cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.C, Rank.TWO));
		cards2.add(new Card(Suit.H, Rank.THREE));
		cards2.add(new Card(Suit.S, Rank.FOUR));
		cards2.add(new Card(Suit.C, Rank.EIGHT));
		cards2.add(new Card(Suit.H, Rank.KING));
		Hand hand2 = new Hand(cards2);
		
		assertEquals(1, hand1.compareTo(hand2));

	}
	
	@Test
	public void testHandCompare_TestCase4()
	{
		//Black: 2H 3D 5S 9C KD  White: 2D 3H 5C 9S KH
		//Both hands the same
		List<Card> cards1 = new ArrayList<Card>();
		cards1 = new ArrayList<Card>();
		cards1.add(new Card(Suit.H, Rank.TWO));
		cards1.add(new Card(Suit.D, Rank.THREE));
		cards1.add(new Card(Suit.S, Rank.FIVE));
		cards1.add(new Card(Suit.C, Rank.NINE));
		cards1.add(new Card(Suit.D, Rank.KING));
		Hand hand1 = new Hand(cards1);

		List<Card> cards2 = new ArrayList<Card>();
		cards2.add(new Card(Suit.D, Rank.TWO));
		cards2.add(new Card(Suit.H, Rank.THREE));
		cards2.add(new Card(Suit.C, Rank.FOUR));
		cards2.add(new Card(Suit.S, Rank.NINE));
		cards2.add(new Card(Suit.H, Rank.KING));
		Hand hand2 = new Hand(cards2);
		
		assertEquals(1, hand1.compareTo(hand2));

	}

}
