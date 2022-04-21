/*
 * Player.java
 * 
 * 
 * This class serves as a blueprint for objects that represent 
 * a single CardMatch player.
 *
 * Jason Wang, jasonw77@bu.edu
 */
import java.util.*;

public class Player{
    private String name;
    private Card[] hand;
    private int numCards;

    public Player(String name){
        /* 
         * constructor that initializes the Player object
         */
        this.hand = new Card[CardMatch.MAX_CARDS];
        this.name = name;
        this.numCards = 0;
    }

    public String getName(){
        /* 
         * accessor that returns the player's name
         */
        return this.name;
    }

    public int getNumCards(){
        /* 
         * accessor that returns the number 
         * of cards in teh player's hand
         */
        return this.numCards;
    }

    public String toString(){
        /* 
         * returns the player's name
         */
        return this.name;
    }

    public void addCard(Card card){
        /* 
         * adds the specified card to the player’s hand,
         * filling the array from left to right
         */
        if (card == null || this.numCards == CardMatch.MAX_CARDS){
            throw new IllegalArgumentException();
        }
        else{
            this.hand[this.numCards] = card;
            this.numCards++;
        }
    }

    public Card getCard(int index){
        /* 
         * takes an integer index as a parameter and returns
         * the Card at the specified position in the player’s hand, without
         * actually removing the card from the hand
         */
        if (this.hand[index] == null){
            throw new IllegalArgumentException();
        }
        return this.hand[index];
    }

    public int getHandValue(){
        /* 
         * computes and returns the total value of the player’s current hand 
         */
        int sumOfValues = 0;
        for (int i = 0; i < this.numCards; i++){
            sumOfValues += this.hand[i].getValue();
        }
        if (this.numCards == CardMatch.MAX_CARDS){
            sumOfValues += CardMatch.MAX_CARDS_PENALTY;
        } 
        return sumOfValues;
    }

    public void displayHand(){
        /* 
         * prints the current contents of the player’s hand,
         * preceded by a heading that includes the player’s name
         */
        System.out.println(this.name + "'s " + "hand:");
        for (int i = 0; i < this.numCards; i++){
            System.out.println("  " + i + ": " + this.hand[i]);
        }
    }

    public Card removeCard(int index){
        /* 
         * takes an integer index as a parameter and both removes
         * and returns the Card at that position of the player’s hand
         */
        Card card = null;
        if (this.hand[index] == null){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < this.numCards; i++){
            if (this.hand[i].equals(this.hand[index])){
                card = this.hand[i];
                for (int j = i; j < this.numCards -1; j++){
                    this.hand[j] = this.hand[j + 1];
                }
                this.hand[numCards - 1] = null;
                this.numCards--;
            }
        }
        return card;
    }

    public int getPlay(Scanner scan, Card card){
        /* 
         * determines and returns the number corresponding to the player’s next play
         */
        System.out.print(this.name + ": number of card to play (-1 to draw)? ");
        int playerNumber = scan.nextInt();
        if (playerNumber < -1 || playerNumber > numCards -1){
            System.out.print(this.name + ": number of card to play (-1 to draw)? ");
            playerNumber = scan.nextInt();
        }
        return playerNumber;

    }








}