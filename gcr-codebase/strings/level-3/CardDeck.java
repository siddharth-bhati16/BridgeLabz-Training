import java.util.Scanner;
public class CardDeck 
{
	public static void main(String[] args)
	{
        CardDeck deckOfCards = new CardDeck();
        String[] deck = deckOfCards.getDeck();
        deck = deckOfCards.shuffleDeck(deck);
        int players = 4;

        String[][] hands = deckOfCards.distribute(deck, players);
        if (hands == null)
		{
            System.out.println("Cannot distribute cards evenly.");
            return;
        }

        for (int i = 0; i < hands.length; i++)
		{
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < hands[i].length; j++) 
			{
                System.out.println("  " + hands[i][j]);
            }
            System.out.println();
        }
    }



    // to generate deck
	
    public String[] getDeck() 
	{
        String[] suit = {"Hearts", "Diamonds", "Spades", "Clubs"};
        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        String[] deck = new String[suit.length * rank.length];
        int index = 0;

        for (int i = 0; i < suit.length; i++) 
		{
            for (int j = 0; j < rank.length; j++) 
			{
                deck[index] = rank[j] + " of " + suit[i];
                index++;
            }
        }

        return deck;
    }

    // shuffling the Deck
	
    public String[] shuffleDeck(String[] deck) 
	{
        for (int i = 0; i < deck.length; i++) 
		{
            int index = i + (int)(Math.random() * (deck.length - i));
            String temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
        return deck;
    }

    // distributing deck evenly
	
    public String[][] distributeDeck(String[] deck, int x)
	{
        if (52%x!=0)
		{
            return null;
        }
        String[][] distributedDeck = new String[x][52/x];
        int index = 0;
        for (int i = 0; i < x; i++) 
		{
            for (int j = 0; j < 52/x; j++)
			{
                distributedDeck[i][j] = deck[index];
                index++;
            }
        }
        return distributedDeck;
    }
    
}