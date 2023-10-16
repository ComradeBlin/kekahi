// importing 2 classes that reads and distributes the cards
import Gamemodes.GamemodeOne;
import Methods.CardClass;
import Methods.CardReader;
// importing packages for arrays and scanners
import java.util.ArrayList;
import java.util.Scanner;


class CardMain extends CardClass {

    //Global Scanners
    public static Scanner numScan = new Scanner(System.in);
    public static Scanner wordScan = new Scanner(System.in);

    public static void main(String[] args) {
        // initiating array list(s)
        ArrayList<String> cards = new CardReader().loadStringList("data/cardInfo.txt");
        ArrayList<String> playerHand = new ArrayList<String>();
        ArrayList<String> botHand1 = new ArrayList<String>();
        ArrayList<String> botHand2 = new ArrayList<String>();
        ArrayList<String> botHand3 = new ArrayList<String>();
        ArrayList<String> maximusHand1 = new ArrayList<String>();
        ArrayList<String> currentDiscardCard = new ArrayList<String>();

        // initiating variables
        boolean gameTrue = true;
        boolean game1play = true;
        String currentCardColor = "";
        String playerUsedCard = "";
        String changedColor = "";
        int playedCardSlot = -1;

        int wild4Bot1Down = 0;
        int wild4Bot2Down = 0;
        int wild4Bot3Down = 0;
        int wild4PlayerDown = 0;

        int wildBot1Down = 0;
        int wildBot2Down = 0;
        int wildBot3Down = 0;
        int wildPlayerDown = 0;

        int plus2Bot1Down = 0;
        int plus2Bot2Down = 0;
        int plus2Bot3Down = 0;
        int plus2PlayerDown = 0;

        int skipBot1Down = 0;
        int skipBot2Down = 0;
        int skipBot3Down = 0;
        int skipPlayerDown = 0;

        int reverseBot1Down = 0;
        int reverseBot2Down = 0;
        int reverseBot3Down = 0;
        int reversePlayerDown = 0;


        // loops until the player chooses to quit
        while (true) {
            //Main Menu
            System.out.println("=== Welcome To Kekahi ===");
            System.out.println("How Would You Like To Play?");
            System.out.println("1. Against 1 Computers");
            System.out.println("2. Against 2 Computers");
            System.out.println("3. BRUTAL Mode");
            System.out.println("=========================");
            System.out.println("You can choose by typing the corresponding number down below.");
            int userOption = numScan.nextInt();

            // redundancy: makes sure the user uses either the numbers: 1, 2, or 3
            while (!(userOption == 1 || userOption == 2 || userOption == 3)  ) {
                System.out.println("Try again user. If you reply with something else, this message will repeat itself!");
                System.out.println("Choose by typing the corresponding number down below");
                userOption = numScan.nextInt();
            } //end while loop

            // redundancy: clearing the player and bots hand for the upcomong match
            playerHand.clear();
            currentDiscardCard.clear();
            botHand1.clear();

            // generating the player's and bot's hand
            genKekahiCards(cards, playerHand, botHand1, botHand2, botHand3);

            // MAJOR if statement that enables the user to use either of the 3 modes
            if (userOption == 1) {
                // generates a random first card and will be on top of the discard pile
                currentDiscardCard.add(firstCardGen(cards));

                // calls a function to initiate the match
                GamemodeOne.OptionOne(cards, currentDiscardCard, playerHand, botHand1);

            } else if (userOption == 2) {
                // generates a random first card and will be on top of the discard pile
                currentDiscardCard.add(firstCardGen(cards));

                // calls a function to initiate the match
                GamemodeOne.OptionOne(cards, currentDiscardCard, playerHand, botHand1, botHand2);
            } else if (userOption == 3) {

                //Initializing the counter for power cards
                wild4Bot1Down = 0;
                plus2Bot1Down = 0;
                skipBot1Down = 0;
                reverseBot1Down = 0;
                wild4PlayerDown = 0;
                plus2PlayerDown = 0;
                skipPlayerDown = 0;
                reversePlayerDown = 0;

            } //end major if loop

            System.out.println("Do you want to use this program again? Type: yup");
            String tryAgain = wordScan.nextLine().toLowerCase();
            System.out.println();

            //If user wants to does not want to use program again
            if (!(tryAgain.equalsIgnoreCase("yup"))) {
                System.out.println("Thank you for using the program.");
                break;
            } //end if statement
        } //end major while loop
    } //end main
} //end class
