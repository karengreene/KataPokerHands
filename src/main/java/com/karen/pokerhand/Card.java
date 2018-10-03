package com.karen.pokerhand;

public class Card implements Comparable<Card>
{
	private final Suit suit;
	private final Rank rank;

    
    public Card(Suit suit, Rank rank)
    {
        this.rank=rank;
        this.suit=suit;
    }

    @Override 
    public String toString()
    {
    	return rank + " of " + suit;
    }

    public Rank getRank() 
    {
         return rank;
    }

    public Suit getSuit() 
    {
        return suit;
    }
    
    public int getCardValue()
    {
    	return this.getRank().ordinal();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		return true;
	}
	
	
	@Override
	public int compareTo(Card card) {
		return rank.compareTo(card.getRank());
	}
    
    
}
