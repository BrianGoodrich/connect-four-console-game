package edu.umsl;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConnectFour {

    private static char[][] gameArray = new char[6][7]; //create an array with 6 rows and 7 columns

    private static char currentPlayer = 'R'; //The first player will be red each time and the users can just decide who goes first.

    private static String gameStatus = "continue";

    ConnectFour (){ //This constructor will initialize the connectfour object's array so that it is filled with empty spaces so that we can check for empty spots to fill as well as simplify outputting the game board.
        for (int row = 0; row < 6; row++){
            for (int column = 0; column < 7; column++){
                gameArray[row][column] = ' ';
            }
        }
    }

    public void displayBoard() { //This method is to display the game board and will iterate through the array placing column numbers above and a structured output for the characters.

        System.out.println("  0   1   2   3   4   5   6 ");

        for (int row = 5; row >= 0; row--) {
            System.out.println();
            for (int column = 0; column < 7; column++) {
                if (column == 6) { //this will ensure there is a bar placed on the far right column each time we display.
                    System.out.print("| " + gameArray[row][column] + " |");
                }
                else
                    System.out.print("| " + gameArray[row][column] + " ");

            }
        }


    }

    public String getGameStatus() { //This method is to loop through the array and check to see if there is a player with four consecutive disks in a diagonal direction, vertical, or horizontal.

        int counter=0;

        for (int row = 0; row < 6; row++){
            for (int column = 0; column < 7; column++){ //Nested for loops to iterate through the rows and columns of the array.
                if (gameArray[row][column] == 'R' || gameArray[row][column] == 'Y'){ //This if statement will trigger if the loop encounters a red or yellow disk to begin checking if there is a winning condition met in the following if else structure below.
                    if (column < 4 && gameArray[row][column] == gameArray[row][column+1] && gameArray[row][column+1] == gameArray[row][column+2] && gameArray[row][column+2] == gameArray[row][column+3]){ //checking if 4 disks in a row are equal horizontally. The first 2 conditions of each of these if statements are bounds checking the array before testing for 4 equal disks to ensure that there are enough spaces in the given direction for there to be a win so that we can check for it.
                        gameStatus = "win"; //this is in each statement to change the return statements value in order to break the do while loop in the main method.
                        if(gameArray[row][column] == 'R')
                        System.out.println("Red is the winner!");
                        else
                            System.out.println("Yellow is the winner!");
                        displayBoard(); //display the game board after a winner is declared.
                        return gameStatus; //If the winning conditions are met we output a winner message above and then return win to the main method to stop the do while loop.
                    }
                    else if (row < 3 && gameArray[row][column] == gameArray[row+1][column] && gameArray[row+1][column] == gameArray[row+2][column] && gameArray[row+2][column] == gameArray[row+3][column]){ //checking if 4 disks in a row are equal vertically.
                        gameStatus = "win";
                        if(gameArray[row][column] == 'R')
                            System.out.println("Red is the winner!");
                        else
                            System.out.println("Yellow is the winner!");
                        displayBoard();
                        return gameStatus;
                    }
                    else if (row < 3 && column < 4 && gameArray[row][column] == gameArray[row+1][column+1] && gameArray[row+1][column+1] == gameArray[row+2][column+2] && gameArray[row+2][column+2] == gameArray[row+3][column+3]){ //check for win diagonally up to the right. I decided to do the diagonal wins separately for each direction so that it would be easier to do the bounds checking on the array.
                        gameStatus = "win";
                        if(gameArray[row][column] == 'R')
                            System.out.println("Red is the winner!");
                        else
                            System.out.println("Yellow is the winner!");
                        displayBoard();
                        return gameStatus;
                    }
                    else if (row < 3 && column > 2 && gameArray[row][column] == gameArray[row+1][column-1] && gameArray[row+1][column-1] == gameArray[row+2][column-2] && gameArray[row+2][column-2] == gameArray[row+3][column-3]){ //check for win diagonally up to the left.
                        gameStatus = "win";
                        if(gameArray[row][column] == 'R')
                            System.out.println("Red is the winner!");
                        else
                            System.out.println("Yellow is the winner!");
                        displayBoard();
                        return gameStatus;
                    }
                    else if (column > 2 && row > 2 && gameArray[row][column] == gameArray[row-1][column-1] && gameArray[row-1][column-1] == gameArray[row-2][column-2] && gameArray[row-2][column-2] == gameArray[row-3][column-3]){ //check for win diagonally down to the left
                        gameStatus = "win";
                        if(gameArray[row][column] == 'R')
                            System.out.println("Red is the winner!");
                        else
                            System.out.println("Yellow is the winner!");
                        displayBoard();
                        return gameStatus;
                    }
                    else if (column < 4 && row > 2 && gameArray[row][column] == gameArray[row-1][column+1] && gameArray[row-1][column+1] == gameArray[row-2][column+2] && gameArray[row-2][column+2] == gameArray[row-3][column+3]){ //check for win diagonally down to the right
                        gameStatus = "win";
                        if(gameArray[row][column] == 'R')
                            System.out.println("Red is the winner!");
                        else
                            System.out.println("Yellow is the winner!");
                        displayBoard();
                        return gameStatus;
                    }

                    counter++; //This will increment the counter by 1 each time this if statement encounters an R or Y in the array. Once this reaches 42 (6 rows * 7 columns) then we will know that the array is full of disks and no winner was declared and that will be considered a draw.
                }
            }
        }

        if (counter == 42) { //this will check the counter variable for a draw if the if statement structure above does not result in a win.
            gameStatus = "draw";
            System.out.println("We have a draw!");
            displayBoard();
            return gameStatus;
        }

        return gameStatus;
    }

    private static void setGameArray(int column) { //This method iterates through the array checking each row with the column that was inputted by the user and if there is a space the character R or Y that is stored in currentPlayer will be placed there. Checking for the spaces will ensure we fill the array vertically in each given column.

        for (int i = 0; i < 6; i++) {
            if (gameArray[i][column] == ' ') {
                gameArray[i][column] = currentPlayer;
                break; //You must have a break here so that it doesn't fill the entire column with the same character.
            }
        }
    }

        public void getUserChoice () { //This method is to get the user input as well as check for input mismatches using a try catch structure, as well as alternating the player each time it is called.

            boolean retry;

            int columnChoice = 0;

            do {
                retry = false;

                Scanner input = new Scanner(System.in);

                System.out.println();

                if (currentPlayer == 'R') { //Output the correct message depending on which players turn it is.
                    System.out.println("Please choose a column (0-6) to drop the red disk.");
                } else if (currentPlayer == 'Y') {
                    System.out.println("Please choose a column (0-6) to drop the yellow disk.");
                }

                try {
                    columnChoice = input.nextInt();
                } catch (InputMismatchException ex) {
                    retry = true;
                    System.out.println("Sorry that is not a valid input for a column! Try again.");
                } catch (Exception ex) {
                    retry = true;
                    System.out.println("Sorry that is not a valid input for a column! Try again.");
                }

                if (columnChoice < 0 || columnChoice > 6) { //validate the user input for the given amount of columns.
                    System.out.println("Oops, looks like your input for the column was outside the bounds. Enter an integer 0-6");
                    retry = true;
                }

            }
            while (retry);

            setGameArray(columnChoice); //this will call the setGameArray method to place the either R or Y in the array in the chosen column.

            if (currentPlayer == 'R') //This will cause current player to alternate each time this method is called.
                currentPlayer = 'Y';
            else
                currentPlayer = 'R';
        }
}

