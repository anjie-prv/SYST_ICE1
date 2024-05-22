/*
 Cardtick Class.
 Modifier: Parvatie Persaud
 Student ID: 991517197
 */
package ca.sheridancollege.week3.softwarefundamentals.ice1;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author dancye
 */

import java.util.Random;
import java.util.Scanner;


public class CardTrick {
    
    public static void main(String[] args){
        Card[] magicHand = new Card[7];
        Random rand = new Random();
        
        
        //random cards : magicHand
        for (int i=0; i<magicHand.length; i++){
            Card c = new Card();
            //c.setValue(insert call to random number generator here)
            c.setValue(rand.nextInt(13) + 1);
            //c.setSuit(Card.SUITS[insert call to random number between 0-3 here])
            c.setSuit(Card.SUITS[rand.nextInt(4)]);
            magicHand[i] =c;  
        }
        
        //insert code to ask the user for Card value and suit, create their card
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a card. (Enter number between 1 and 13): ");
        int userNumber = scanner.nextInt();
        System.out.println("Pick a suit: (Either diamonds, clubs, hearts, or spades): ");
        String userSuit = scanner.next();
        
        //get user's card: 
        Card userChoice = new Card ();
        userChoice.setValue(userNumber);
        userChoice.setSuit(userSuit);
        
        
        // and search magicHand here
        boolean found = false;
        for (Card card : magicHand){
            if(card.getValue()== userChoice.getValue() && card.getSuit().equalsIgnoreCase(userChoice.getSuit())) {
                found = true;
                break;
            }
        }
        //Then report the result here
        if (found){
            System.out.println("Behold! Your card is in the magic hand.");
        }else {
            System.out.println("Whoops! Your card is not in the magic hand. Try again.");
        }
        
        //Hard Code : Lucky Card
        Card luckyCard = new Card(10, "Diamonds");
        
        //Search for Lucky Card
        found = false;
        for (Card card: magicHand){
            if(card.getValue()== luckyCard.getValue() && card.getSuit().equalsIgnoreCase(luckyCard.getSuit())){
                found = true;
                break;
            }
        }
        //Report result
        if (found){
            System.out.println("Yay! You have the lucky card.");
        } else {
            System.out.println("Oh dear, the lucky card is not in this magic hand.");
        }
    }
    
}
