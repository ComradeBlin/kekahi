package Gamemodes;

// importing 2 classes that reads and distributes the cards
import Methods.CardClass;
// importing required classes for arrays and scanners
import java.util.ArrayList;
import java.util.Scanner;

public class GamemodeOne extends CardClass {
    //Global Scanners
    public static Scanner numScan = new Scanner(System.in);
    public static Scanner wordScan = new Scanner(System.in);

    public static void OptionOne(ArrayList<String>cards, ArrayList<String>currentDiscardCard, ArrayList<String>playerHand, ArrayList<String>botHand1) {
        // initiating variables for the match and the player
        boolean gameTrue = true, game1play = true;
        String currentCardColor = "";
        String playerUsedCard = "";
        String changedColor = "";

        //initiating variables for the player's deck
        int playedCardSlot = -1, wild4PlayerDown = 0, wildPlayerDown = 0, plus2PlayerDown = 0, skipPlayerDown = 0, reversePlayerDown = 0;

        // initiating variables for the bot's deck
        int wild4Bot1Down = 0, wildBot1Down = 0, plus2Bot1Down = 0, skipBot1Down = 0, reverseBot1Down = 0;

        // loops until the match is done (DONE = player/bot wins)
        while (gameTrue) {
            System.out.println();

            //Showing Player and Bot Hand in Console
            System.out.println("Karen has [" + botHand1.size() + "] cards:" + "");
            System.out.println("You have [" + playerHand.size() + "] cards:");

            // loops to show the player's hand
            for (int i = 0; i < playerHand.size(); i++) {
                System.out.print("[" + cardColorCheck(playerHand.get(i)) + "] ");
            } //end for loop

            System.out.println();

            // tells the current card on top of the discard pile
            System.out.println("The current top card in the discard pile is a " + cardColorCheck(currentDiscardCard.get(0)));
            System.out.println();

            // major if statement
            if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red Color Change +4")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue Color Change +4")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green Color Change +4")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow Color Change +4"))) && (wild4Bot1Down == 0)) {

                if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red +2")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue +2")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green +2")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow +2"))) && (plus2Bot1Down == 0)) {

                    if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red Skip")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue Skip")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green Skip")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow Skip"))) && (skipBot1Down == 0)) {

                        if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red Reverse")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue Reverse")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green Reverse")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow Reverse"))) && (reverseBot1Down == 0)) {

                            // loops and shows the cards that the player can use
                            System.out.println("Your Playable cards are :");
                            int playableCards = 0;
                            for (int i = 0; i < playerHand.size(); i++) {
                                if (cardChecker(currentDiscardCard.get(0), playerHand.get(i), cards) == true) {
                                    System.out.print("[" + cardColorCheck(playerHand.get(i)) + "]");
                                    playableCards++;
                                } //end if statement
                            } //end for loop

                            System.out.println();

                            // lets player choose a card to play
                            if (playableCards > 0) {
                                //Resets the counting system for special power cards
                                wild4PlayerDown = 0;
                                wildPlayerDown = 0;
                                plus2PlayerDown = 0;
                                skipPlayerDown = 0;
                                reversePlayerDown = 0;

                                System.out.println("Which card would you like to play?");
                                playerUsedCard = wordScan.nextLine().trim();
                            } else {
                                System.out.println("No playable cards. Get a card");
                                System.out.println("Press [ENTER] To Continue");
                                wordScan.nextLine();
                            } //end if statement

                            //If player has no cards to be played, they will get a card until they can play
                            while (playableCards == 0) {
                                playerHand.add(cardGenerate(cards));
                                System.out.println("The current top card in the discard pile is a " + cardColorCheck(currentDiscardCard.get(0)));
                                System.out.println("You picked up a [" + cardColorCheck(playerHand.get(playerHand.size() - 1)) + "] card");
                                for (int i = 0; i < playerHand.size(); i++) {
                                    if (cardChecker(currentDiscardCard.get(0), playerHand.get(i), cards) == true) {
                                        playableCards++;
                                    } //end if statement

                                } //end for loop

                                System.out.println();

                                System.out.println("You now have [" + playerHand.size() + "] cards:");
                                for (int i = 0; i < playerHand.size(); i++) {
                                    System.out.print("[" + cardColorCheck(playerHand.get(i)) + "] ");
                                } //end for loop
                                System.out.println("");
                                System.out.println("Press [ENTER] To Continue");
                                wordScan.nextLine();
                            } //end while loop

                            System.out.println();

                            //Checks if the user inputs a card that can be played
                            if (cardChecker(currentDiscardCard.get(0), playerUsedCard, cards)) {

                                //Removing the known card that the user wanted to be played inside the Array List
                                for (int i = 0; i < playerHand.size(); i++) {
                                    if (playerHand.get(i).equalsIgnoreCase(playerUsedCard)) {
                                        currentDiscardCard.set(0, playerUsedCard);
                                        playerHand.remove(i);
                                        break;
                                    } //end if statement
                                } //end for loop

                                if (plus2PlayerDown == 0) {
                                    if (currentDiscardCard.get(0).endsWith("+2")) {
                                        for (int i = 0; i < 2; i++) {
                                            botHand1.add(cardGenerate(cards));
                                        } //end for loop
                                        System.out.println("Karen has picked up 2 cards 2 Cards");
                                        plus2PlayerDown = 1;
                                    } //end if statement
                                } //end if statement

                                if (skipPlayerDown == 0) {
                                    if (currentDiscardCard.get(0).endsWith("Skip")) {
                                        skipPlayerDown = 1;
                                    } //end if statement
                                } //end if statement

                                if (reversePlayerDown == 0) {
                                    if (currentDiscardCard.get(0).endsWith("Reverse")) {
                                        reversePlayerDown = 1;
                                    } //end if statement
                                } //end if statement

                                if (wild4PlayerDown == 0) {
                                    if (currentDiscardCard.get(0).equalsIgnoreCase("Color Change +4")) {
                                        for (int i = 0; i < 4; i++) {
                                            botHand1.add(cardGenerate(cards));
                                        } //end for loop
                                        System.out.println("Karen has picked up 4 cards");
                                        boolean colorPicked = false;
                                        while (!colorPicked) {
                                            System.out.println("What color do you want to change it into?");
                                            changedColor = wordScan.nextLine();

                                            if (changedColor.equalsIgnoreCase("red")) {
                                                currentDiscardCard.set(0, "Red Color Change +4");
                                                wild4PlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_RED;
                                            } else if (changedColor.equalsIgnoreCase("blue")) {
                                                currentDiscardCard.set(0, "Blue Color Change +4");
                                                wild4PlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_RED;
                                            } else if (changedColor.equalsIgnoreCase("yellow")) {
                                                currentDiscardCard.set(0, "Yellow Color Change +4");
                                                wild4PlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_RED;
                                            } else if (changedColor.equalsIgnoreCase("green")) {
                                                currentDiscardCard.set(0, "Green Color Change +4");
                                                wild4PlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_RED;
                                            } else {
                                                colorPicked = false;
                                                currentCardColor = ANSI_BLACK;
                                            } //end if statement
                                        } //end while loop
                                    } //end if statement
                                } //end if statement
                                changedColor = "";

                                if (wildPlayerDown == 0) {
                                    if (currentDiscardCard.get(0).equalsIgnoreCase("Color Change")) {
                                        boolean colorPicked = false;
                                        while (!colorPicked) {
                                            System.out.println("What color do you want to change into?");
                                            changedColor = wordScan.nextLine();

                                            if (changedColor.equalsIgnoreCase("red")) {
                                                currentDiscardCard.set(0, "Red Color Change");
                                                wildPlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_RED;
                                            } else if (changedColor.equalsIgnoreCase("blue")) {
                                                currentDiscardCard.set(0, "Blue Color Change");
                                                wildPlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_BLUE;
                                            } else if (changedColor.equalsIgnoreCase("yellow")) {
                                                currentDiscardCard.set(0, "Yellow Color Change");
                                                wildPlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_YELLOW;
                                            } else if (changedColor.equalsIgnoreCase("green")) {
                                                currentDiscardCard.set(0, "Green Color Change");
                                                wildPlayerDown = 1;
                                                colorPicked = true;
                                                currentCardColor = ANSI_GREEN;
                                            } else {
                                                colorPicked = false;
                                                currentCardColor = ANSI_BLACK;
                                            } //end if statement
                                        } //end while loop
                                        changedColor = "";
                                    } //end if statement
                                }


                                //Showing Player Hand in Console
                                System.out.println("You currently have [" + playerHand.size() + "] cards:");
                                for (int i = 0; i < playerHand.size(); i++) {
                                    System.out.print("[" + cardColorCheck(playerHand.get(i)) + "] ");
                                } //end for loop

                                System.out.println();

                                //Tells the current card on the discard pile
                                System.out.println("The current top card in the discard pile is a " + currentCardColor + currentDiscardCard.get(0) + ANSI_RESET);
                                System.out.println();

                            } else {
                                System.out.println("Your selected card is not playable.\nPick another card");
                                playerUsedCard = wordScan.nextLine();
                            } //end if statement
                        } else {
                            System.out.println("Your turn has been skipped by a reverse card! Karen will now play.");
                        }
                    } else {
                        System.out.println("Your turn has been skipped because of a skipped card");
                    }
                } else {
                    System.out.println("Karen hit you with a +2 card! Your turn has been skipped!");
                }
            } else {
                System.out.println("Darn, you were hit by a Color Change +4! your turn has been skipped!");
            } // end major if statement

            // when the player doesnt have cards in their deck
            if (playerHand.size() == 0) {
                System.out.println("You WIN! Congratulations!");
                break;
            } // end if statement

            System.out.println("");

            System.out.println("Karen has [" + botHand1.size() + "] cards");

            //Checks if the player has placed a skip card

            int CplayableCards = 0;
            //======================================================================================================================================================================================================================================================================================================================================= O-1 Player Turn End


            //======================================================================================================================================================================================================================================================================================================================================= O-1 Karen Turn Start

            if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red Color Change +4")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue Color Change +4")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green Color Change +4")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow Color Change +4"))) && (wild4PlayerDown == 0)) {

                if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red +2")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue +2")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green +2")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow +2"))) && (plus2PlayerDown == 0)) {

                    if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red Skip")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue Skip")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green Skip")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow Skip"))) && (skipPlayerDown == 0)) {

                        if ((!(currentDiscardCard.get(0).equalsIgnoreCase("Red Reverse")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Blue Reverse")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Green Reverse")) || !(currentDiscardCard.get(0).equalsIgnoreCase("Yellow Reverse"))) && (reversePlayerDown == 0)) {

                            //Lets the bot play a card
                            for (int i = 0; i < botHand1.size(); i++) {
                                if (cardChecker(currentDiscardCard.get(0), botHand1.get(i), cards) == true) {
                                    CplayableCards++;
                                } //end if statement
                            } //end for loop


                            String cUsedCard = "";

                            if (CplayableCards > 0) {
                                //Resets the counter of the bot's power cards
                                wild4Bot1Down = 0;
                                wildBot1Down = 0;
                                plus2Bot1Down = 0;
                                skipBot1Down = 0;
                                reverseBot1Down = 0;

                                for (int i = 0; i < botHand1.size(); i++) {
                                    if (cardChecker(currentDiscardCard.get(0), botHand1.get(i), cards) == true) {
                                        cUsedCard = botHand1.get(i);
                                    } //end if statement

                                    if (botHand1.get(i).equalsIgnoreCase(cUsedCard)) {
                                        currentDiscardCard.set(0, cUsedCard);
                                        botHand1.remove(i);
                                        System.out.println("Karen Has Played " + cardColorCheck(cUsedCard));
                                        break;
                                    } //end if statement
                                } //end for loop
                            } //end if statement

                            if (CplayableCards == 0) {
                                //If bot deosn't have playable cards
                                while (CplayableCards == 0) {
                                    botHand1.add(cardGenerate(cards));
                                    System.out.println("Karen can't play");
                                    System.out.println("She picked up a card");
                                    for (int i = 0; i < botHand1.size(); i++) {
                                        if (cardChecker(currentDiscardCard.get(0), botHand1.get(i), cards) == true) {
                                            CplayableCards++;
                                        } //end if statement
                                    } //end for loop
                                    System.out.println();
                                    System.out.println("Karen has [" + botHand1.size() + "] cards");
                                    System.out.println("");
                                } //end while loop
                            } //end if statement

                            if (plus2Bot1Down == 0) {
                                if (currentDiscardCard.get(0).endsWith("+2")) {
                                    for (int i = 0; i < 2; i++) {
                                        playerHand.add(cardGenerate(cards));
                                    } //end for loop
                                    System.out.println("You picked up 2 Cards");
                                    plus2Bot1Down = 1;
                                } //end if statement
                            } //end if statement

                            if (skipBot1Down == 0) {
                                if (currentDiscardCard.get(0).endsWith("Skip")) {
                                    skipBot1Down = 1;
                                } //end if statement
                            } //end if statement

                            if (reverseBot1Down == 0) {
                                if (currentDiscardCard.get(0).endsWith("Reverse")) {
                                    reverseBot1Down = 1;
                                } //end if statement
                            } //end if statement

                            if (wild4Bot1Down == 0) {
                                if (currentDiscardCard.get(0).equalsIgnoreCase("Color Change +4")) {
                                    for (int i = 0; i < 4; i++) {
                                        playerHand.add(cardGenerate(cards));
                                    } //end for loop

                                    System.out.println("You have picked up 4 Cards");

                                    //Calling method that let bot picks the 4 colors
                                    int botRandomColor = botChooseColor();

                                    //Change changed color into a random number out of 1-4
                                    if (botRandomColor == 1) {
                                        currentDiscardCard.set(0, "Red Color Change +4");
                                        wild4Bot1Down = 1;
                                        currentCardColor = ANSI_RED;
                                    } else if (botRandomColor == 2) {
                                        currentDiscardCard.set(0, "Blue Color Change +4");
                                        wild4Bot1Down = 1;
                                        currentCardColor = ANSI_BLUE;
                                    } else if (botRandomColor == 3) {
                                        currentDiscardCard.set(0, "Yellow Color Change +4");
                                        wild4Bot1Down = 1;
                                        currentCardColor = ANSI_YELLOW;
                                    } else if (botRandomColor == 4) {
                                        currentDiscardCard.set(0, "Green Color Change +4");
                                        wild4Bot1Down = 1;
                                        currentCardColor = ANSI_GREEN;
                                    } else {
                                        System.out.println("");
                                        currentCardColor = ANSI_BLACK;
                                    } //end if statement

                                    System.out.println("The current top card in the discard pile is a " + currentCardColor + currentDiscardCard.get(0) + ANSI_RESET);
                                } //end if statement
                            }

                            if (wildBot1Down == 0) {
                                if (currentDiscardCard.get(0).equalsIgnoreCase("Color Change")) {
                                    int botRandomColor = botChooseColor();
                                    if (botRandomColor == 1) {
                                        currentDiscardCard.set(0, "Red Color Change");
                                        wildBot1Down = 1;
                                        currentCardColor = ANSI_RED;
                                    } else if (botRandomColor == 2) {
                                        currentDiscardCard.set(0, "Blue Color Change");
                                        wildBot1Down = 1;
                                        currentCardColor = ANSI_BLUE;
                                    } else if (botRandomColor == 3) {
                                        currentDiscardCard.set(0, "Yellow Color Change");
                                        wildBot1Down = 1;
                                        currentCardColor = ANSI_YELLOW;
                                    } else if (botRandomColor == 4) {
                                        currentDiscardCard.set(0, "Green Color Change");
                                        wildBot1Down = 1;
                                        currentCardColor = ANSI_GREEN;
                                    } else {
                                        System.out.println("");
                                        currentCardColor = ANSI_BLACK;
                                    } //end if statement
                                    System.out.println("The current top card in the discard pile is a " + currentCardColor + currentDiscardCard.get(0) + ANSI_RESET);
                                } //end if statement
                            }

                        } else {
                            System.out.println("You played a reverse card; that means you can play again");
                        }
                    } else {
                        System.out.println("Karen's turn has been skipped, because you played a skipped card!");
                    }
                } else {
                    System.out.println("Karen has to get 2 cards, because you placed a +2 card.");
                }
            } else {
                System.out.println("Karen's turn has been skipped, because you placed a Color Change +4.");
            }

            if (botHand1.size() == 0) {
                System.out.println("Uh-Oh! Karen won, try again.");
                break;
            } //end if statement

            //======================================================================================================================================================================================================================================================================================================================================= O-1 Karen Turn End

            //=======================================================================================================================================================================================================================================================================================================================================


            System.out.println("");
            System.out.println("Do you want to Continue to the next Turn? Type: ( Y or N )");
            String nextTurn = wordScan.nextLine().toLowerCase();
            System.out.println("");

            //Checks if either player or bot has no cards left
            if (playerHand.size() == 0) {
                System.out.println("You WIN! Congratulations!");
                break;
            } else if (botHand1.size() == 0) {
                System.out.println("Uh-Oh! Karen won, try again.");
                break;
            } //end if statement

            //If user wants to does not want to use this mode again
            if (nextTurn.contains("y")) {
                //Fail-safe if the user hits [ENTER] two times and resume to the game
            } else if (nextTurn.contains("n")) {
                break;
            } else {
                System.out.println("Again. Do you want to Continue to the next Turn? Type: ( Y or N )");
                nextTurn = wordScan.nextLine().toLowerCase();
                System.out.println();
                if (nextTurn.contains("y")) {
                    //Fail-safe if the user hits [ENTER] two times and resume to the game
                } else if (nextTurn.contains("n")) {
                    break;
                } else {
                    //Penalty of 3 cards to player
                    for (int i = 0; i < 3; i++) {
                        playerHand.add(cardGenerate(cards));
                    } //end for loop
                } //end if statement inside an if statement
            } //end if statement
        }//end while loop
    } // end OptioneOne()
} // end class GamemodeOne
