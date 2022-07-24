package edu.umsl;

public class RunGame {

    public static void main (String [] args){ //This is the main method of running the game where we will call all of the methods from the connect four class in a do while loop.

        String gameStatus; //string variable to store the status of the game and to use in the do while condition check.
        ConnectFour game = new ConnectFour();

        do{ 

            game.displayBoard();

            game.getUserChoice();

            gameStatus = game.getGameStatus();

        }
        while(gameStatus == "continue"); //check if the game is still going, then execute the above loop.



    }
}
