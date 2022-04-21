/*
 * ComputerPlayer.java
 * 
 * 
 * This class serves as a blueprint for objects that represent 
 * a single CardMatch computer player.
 *
 * Jason Wang, jasonw77@bu.edu
 */



import java.util.*;
public class ComputerPlayer extends Player {

    public ComputerPlayer(String name){
        /* 
         * constructor for the computer based player
         */
        super(name);
    }

    public void displayHand(){
        /*
         * overrides the Player version of this method
         */
        System.out.println(this.getName() + "'s hand:");
        if (this.getNumCards() == 1){
            System.out.println("  " + this.getNumCards() + " card");
        }
        else{
            System.out.println("  " + this.getNumCards() + " cards");
        }
    }

    public int getPlay(Scanner scan, Card discardCard){
        /*
         * overrides the Player version of this method, and computes the best move for the computer
         */
        int highestVal = 0;
        int index = -1;
        for (int i = 0; i < this.getNumCards(); i++){
            if (this.getCard(i).equals(discardCard)){
                index = i;
            }
            else if (this.getCard(i).getValue() == discardCard.getValue()){
                index = i;
            }
            else if (this.getCard(i).getValue() != discardCard.getValue() 
                    && this.getCard(i).getColor() == discardCard.getColor() 
                    && this.getCard(i).getValue() >= highestVal){
                index = i;
                highestVal = this.getCard(i).getValue();
            }

        }
        return index;
    }

}
