package Methods;

import java.util.ArrayList;

public class CardClass {
    // initiating array list(s)
    ArrayList<String> cards = new CardReader().loadStringList("data/cardInfo.txt");


    //This method checks if the known card can be played by having the same color or same number
    public static Boolean cardChecker(String topCard, String playerCard, ArrayList<String> cards) {
        //Variable(s)
        String topNum = "";
        String playerNum = "";

        for (int i = 0; i < cards.size(); i++) {
            String cardIndex = cards.get(i).substring(3);

            if (topCard.equalsIgnoreCase(cardIndex)) {
                topNum = cards.get(i).substring(0, 2);
            } //end if statement
        } //end for loop

        for (int i = 0; i < cards.size(); i++) {
            String cardIndex = cards.get(i).substring(3);

            if (playerCard.equalsIgnoreCase(cardIndex)) {
                playerNum = cards.get(i).substring(0, 2);
            } //end if statement
        } //end for loop

        //This checks if the known card has the same color or same number of the last known used card
        if (playerNum.equalsIgnoreCase("61")) {
            //can play a color change +4
            return true;
        } else if (topNum.equalsIgnoreCase("61")) {
            //checks a color change +4
            return true;
        } else if (playerNum.equalsIgnoreCase("60")) {
            //can play a color change
            return true;
        } else if (topNum.equalsIgnoreCase("60")) {
            //checks a color change
            return true;
        } else if (playerNum.equalsIgnoreCase("40") && (topNum.equalsIgnoreCase("50") || topNum.equalsIgnoreCase("70") ||topNum.equalsIgnoreCase("80"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("41") && (topNum.equalsIgnoreCase("51") || topNum.equalsIgnoreCase("71") ||topNum.equalsIgnoreCase("81"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("42") && (topNum.equalsIgnoreCase("52") || topNum.equalsIgnoreCase("72") ||topNum.equalsIgnoreCase("82"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("43") && (topNum.equalsIgnoreCase("53") || topNum.equalsIgnoreCase("73") ||topNum.equalsIgnoreCase("83"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("50") && (topNum.equalsIgnoreCase("40") || topNum.equalsIgnoreCase("70") ||topNum.equalsIgnoreCase("80"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("51") && (topNum.equalsIgnoreCase("41") || topNum.equalsIgnoreCase("71") ||topNum.equalsIgnoreCase("81"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("52") && (topNum.equalsIgnoreCase("42") || topNum.equalsIgnoreCase("72") ||topNum.equalsIgnoreCase("82"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("53") && (topNum.equalsIgnoreCase("43") || topNum.equalsIgnoreCase("73") ||topNum.equalsIgnoreCase("83"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("70") && (topNum.equalsIgnoreCase("50") || topNum.equalsIgnoreCase("40") ||topNum.equalsIgnoreCase("80"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("71") && (topNum.equalsIgnoreCase("51") || topNum.equalsIgnoreCase("41") ||topNum.equalsIgnoreCase("81"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("72") && (topNum.equalsIgnoreCase("52") || topNum.equalsIgnoreCase("42") ||topNum.equalsIgnoreCase("82"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("73") && (topNum.equalsIgnoreCase("53") || topNum.equalsIgnoreCase("43") ||topNum.equalsIgnoreCase("83"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("80") && (topNum.equalsIgnoreCase("40") || topNum.equalsIgnoreCase("70") ||topNum.equalsIgnoreCase("40"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("81") && (topNum.equalsIgnoreCase("41") || topNum.equalsIgnoreCase("71") ||topNum.equalsIgnoreCase("41"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("82") && (topNum.equalsIgnoreCase("42") || topNum.equalsIgnoreCase("72") ||topNum.equalsIgnoreCase("42"))) {

            return true;
        } else if (playerNum.equalsIgnoreCase("83") && (topNum.equalsIgnoreCase("43") || topNum.equalsIgnoreCase("73") ||topNum.equalsIgnoreCase("43"))) {

            return true;
        } else if (topNum.equalsIgnoreCase("50") && (playerNum.equalsIgnoreCase("10") || playerNum.equalsIgnoreCase("20") || playerNum.equalsIgnoreCase("30"))) {
            //checks playability with red reverse card and +2s
            return false;
        } else if (topNum.equalsIgnoreCase("51") && (playerNum.equalsIgnoreCase("01") || playerNum.equalsIgnoreCase("21") || playerNum.equalsIgnoreCase("31"))) {
            //checks playability with blue reverse card and card #1s
            return false;
        } else if (topNum.equalsIgnoreCase("52") && (playerNum.equalsIgnoreCase("02") || playerNum.equalsIgnoreCase("12") || playerNum.equalsIgnoreCase("32"))) {
            //checks playability with yellow reverse card and card #2s
            return false;
        } else if (topNum.equalsIgnoreCase("53") && (playerNum.equalsIgnoreCase("03") || playerNum.equalsIgnoreCase("13") || playerNum.equalsIgnoreCase("23"))) {
            //checks playability with green reverse card and card #3s
            return false;
        } else if (topNum.equalsIgnoreCase("40") && (playerNum.equalsIgnoreCase("10") || playerNum.equalsIgnoreCase("20") || playerNum.equalsIgnoreCase("30"))) {
            //checks playability with red skip card and +2s
            return false;
        } else if (topNum.equalsIgnoreCase("41") && (playerNum.equalsIgnoreCase("01") || playerNum.equalsIgnoreCase("21") || playerNum.equalsIgnoreCase("31"))) {
            //checks playability with blue skip card and card #1s
            return false;
        } else if (topNum.equalsIgnoreCase("42") && (playerNum.equalsIgnoreCase("02") || playerNum.equalsIgnoreCase("12") || playerNum.equalsIgnoreCase("32"))) {
            //checks playability with yellow skip card and card #2s
            return false;
        } else if (topNum.equalsIgnoreCase("43") && (playerNum.equalsIgnoreCase("03") || playerNum.equalsIgnoreCase("13") || playerNum.equalsIgnoreCase("23"))) {
            //checks playability with green  skipcard and card #3s
            return false;
        } else if (topNum.equalsIgnoreCase("80") && (playerNum.equalsIgnoreCase("10") || playerNum.equalsIgnoreCase("20") || playerNum.equalsIgnoreCase("30"))) {
            //checks playability with red color change +4 card and +2s
            return false;
        } else if (topNum.equalsIgnoreCase("81") && (playerNum.equalsIgnoreCase("01") || playerNum.equalsIgnoreCase("21") || playerNum.equalsIgnoreCase("31"))) {
            //checks playability with blue color change +4 and card #1s
            return false;
        } else if (topNum.equalsIgnoreCase("82") && (playerNum.equalsIgnoreCase("02") || playerNum.equalsIgnoreCase("12") || playerNum.equalsIgnoreCase("32"))) {
            //checks playability with yellow color change +4 and card #2s
            return false;
        } else if (topNum.equalsIgnoreCase("83") && (playerNum.equalsIgnoreCase("03") || playerNum.equalsIgnoreCase("13") || playerNum.equalsIgnoreCase("23"))) {
            //checks playability with green color change +4 and card #3s
            return false;
        } else if (topNum.equalsIgnoreCase("70") && (playerNum.equalsIgnoreCase("10") || playerNum.equalsIgnoreCase("20") || playerNum.equalsIgnoreCase("30"))) {
            //checks playability with red color change card and +2s
            return false;
        } else if (topNum.equalsIgnoreCase("71") && (playerNum.equalsIgnoreCase("01") || playerNum.equalsIgnoreCase("21") || playerNum.equalsIgnoreCase("31"))) {
            //checks playability with blue color change and card #1s
            return false;
        } else if (topNum.equalsIgnoreCase("72") && (playerNum.equalsIgnoreCase("02") || playerNum.equalsIgnoreCase("12") || playerNum.equalsIgnoreCase("32"))) {
            //checks playability with yellow color change and card #2s
            return false;
        } else if (topNum.equalsIgnoreCase("73") && (playerNum.equalsIgnoreCase("03") || playerNum.equalsIgnoreCase("13") || playerNum.equalsIgnoreCase("23"))) {
            //checks playability with green color change and card #3s
            return false;
        } else if (playerNum.charAt(0) == topNum.charAt(0)) {
            //checks same color
            return true;
        } else if (playerNum.charAt(0) != '4' && playerNum.charAt(0) != '5' && playerNum.charAt(1) == topNum.charAt(1)) {
            //checks same number
            return true;
        } else if ((playerNum.charAt(0) == '4' && playerNum.charAt(1) == topNum.charAt(0))) {
            //checks for skip cards that player places
            return true;
        } else if (topNum.charAt(0) == '4' && playerNum.charAt(0) == topNum.charAt(1)) {
            //checks for skip cards when the discard pile is skip cards
            return true;
        } else if (playerNum.charAt(0) == '5' && playerNum.charAt(1) == topNum.charAt(0)) {
            //checks for reverse cards that player places
            return true;
        } else if (topNum.charAt(0) == '5' && playerNum.charAt(0) == topNum.charAt(1)) {
            //checks for reverse cards when the discard pile is reverse cards
            return true;
        } else if (playerNum.charAt(0) == '8' && playerNum.charAt(1) == topNum.charAt(0)) {
            //
            return true;
        } else if (topNum.charAt(0) == '8' && playerNum.charAt(0) == topNum.charAt(1)) {
            return true;
        } else if (playerNum.charAt(0) == '7' && playerNum.charAt(1) == topNum.charAt(0)) {
            return true;
        } else if (topNum.charAt(0) == '7' && playerNum.charAt(0) == topNum.charAt(1)) {
            return true;
        } else if (playerNum.charAt(0) == '6') {
            //checks for the "wild cards"
            return true;
        }//end if statement
        //Returns if the known card has neither the same color or number
        return false;
    } //end cardChecker()



    //Random Number between 0 to 50 to generate cards
    public static int randomCard() {
        return (int) (Math.random() * (50));
    } //end randomCard()



    //Random Number between 0 to 48 to generate cards
    //Not including the two wild cards
    public static int firstRandomCard() {
        return (int) (Math.random() * (48));
    } //end randomCard()



    //Searching and printing a single card's information/serial number.
    public static String cardGenerate(ArrayList<String> cards) {
        //Variable(s)
        int searchTerm = randomCard();

        for (int i = 0; i < cards.size(); i++) {
            String cardIndex = cards.get(i).substring(0, 2);
            String cardSearch = (i < 10 ? "0" : "") + Integer.toString(searchTerm);

            if (cards.get(i).substring(0, 2).equals(cards.get(searchTerm).substring(0, 2))) {
                return cards.get(i).substring(3);
            } //end if statement
        } //end for loop
        return "-1";
    } //end cardSearch()

    public static String firstCardGen(ArrayList<String> cards) {
        int fSearchTerm = firstRandomCard();

        for (int i = 0; i < cards.size(); i++) {
            String cardIndex = cards.get(i).substring(0, 2);
            String cardSearch = (i < 10 ? "0" : "") + Integer.toString(fSearchTerm);

            if (cards.get(i).substring(0, 2).equals(cards.get(fSearchTerm).substring(0, 2))) {
                return cards.get(i).substring(3);
            } //end if statement
        } //end for loop
        return "-1";
    } //end firstCardGen

    public static int botChooseColor() {
        //Bot picks one of the 4 colors for any Color Changes
        return (int) (Math.random() * (4) + 1);

    } //end botChooseColor()

    public static void genKekahiCards(ArrayList<String> cards, ArrayList<String> playerHand, ArrayList<String> botHand1, ArrayList<String> botHand2, ArrayList<String> botHand3) {
        //Generates cards for ALL
        for (int i = 0; i < 7; i++) {
            playerHand.add(cardGenerate(cards));
            botHand1.add(cardGenerate(cards));
            botHand2.add(cardGenerate(cards));
        } //end for loop
    } //end genKekahiCards



    //Researched, learned, and used the following code from WhiteFang34 and edited by SergeyB
    //https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";



    //Colors the cards into their respective colors
    public static String cardColorCheck(String card) {
        if (card.toLowerCase().lastIndexOf("red") > -1) {
            return ANSI_RED + card + ANSI_RESET;
        } else if (card.toLowerCase().lastIndexOf("blue") > -1) {
            return ANSI_BLUE + card + ANSI_RESET;
        } else if(card.toLowerCase().lastIndexOf("yellow") > -1) {
            return ANSI_YELLOW + card + ANSI_RESET;
        } else if(card.toLowerCase().lastIndexOf("green") > -1) {
            return ANSI_GREEN + card + ANSI_RESET;
        } else {
            return card;
        } //end if statement
    } //end cardColorCheck



    public static void genBrutalCards(ArrayList<String> cards, ArrayList<String> maximusHand1) {
        //Generates cards for ALL
        for (int i = 0; i < 7; i++) {
            maximusHand1.add("Color Change +4");
        } //end for loop
    } //end genBrutalCards()



    public static String genBRUTALCards(ArrayList<String> cards) {
        return "Color Change +4";
    } //end genBRUTALCards()
} //end class



