/*
 * Card.java
 * 
 * A blueprint class for objects that represent a single playing card 
 * for a game in which cards have both colors and numeric values.
 * 
 * starter code: CS 112 Staff (cs112-staff@cs.bu.edu)
 * completed by: Jason Wang, jasonw77@bu.edu
 */

public class Card {
    /* The smallest possible value that a Card can have. */
    public static final int MIN_VALUE = 0;
    
    /* The possible colors that a Card can have. */
    public static final String[] COLORS = {"blue", "green", "red", "yellow"};

    /* Define the third class constant here. */
    public static final int MAX_VALUE = 9;
    /* Put the rest of your class definition below. */
    private String color;
    private int value;

    public static boolean isValidColor(String color){
        /* 
         * take the name of a color as a parameter, and it should return true
         *  if the specified color is valid , and false otherwise
         */
        for (int i = 0; i < COLORS.length; i++){
            if (COLORS[i] == color){
                return true;
            }
        }
        return false;
    }

    public void setColor(String color){
        /* 
         * takes a String representing a color and sets the value 
         * of the Card object’s color field to the specified color.
         */
        if (isValidColor(color) == false){
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    public void setValue(int value){
        /* 
         * takes an integer and sets the value of 
         * the Card object’s value field to the specified number.
         */
        if (value < MIN_VALUE || value > MAX_VALUE){
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public Card(String color, int value){
        /*
         * Constructor for Card object
         */
        this.setColor(color);
        this.setValue(value);
    }

    public String getColor(){
        /* 
         * returns the string representing the Card object's color
         */
        return this.color;
    }

    public int getValue(){
        /* 
         * returns the integer representing the Card object's value
         */
        return this.value;
    }

    public String toString(){
        /* 
         *  returns a String representation of the Card object 
         *  that can be used when printing it or concatenating it to a String
         */
        return this.color + " " + this.value;
    }

    public boolean matches(Card other){
        /* 
         * takes another Card object as a parameter and returns true if the
         * called Card object matches the color and/or value of the other Card 
         * object, and false if it doesn’t match either the color or the value.
         */
        if (other == null){
            return false;
        }
        if (this.color == other.color || this.value == other.value){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean equals(Card other){
        /* 
         * takes another Card object as a parameter and determines if it is 
         * equivalent to the called object, returning true if it is 
         * equivalent and false if it is not equivalent
         */
        if (other == null){
            return false;
        }
        if (this.color == other.color && this.value == other.value){
            return true;
        }
        else{
            return false;
        }

    }




}
    
