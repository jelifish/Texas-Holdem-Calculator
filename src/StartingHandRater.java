import java.util.Scanner;

public class StartingHandRater { //Bill Chen Formula
    int[][] hand = new int[7][2]; //2d array to allow for the entire board/properties

    public StartingHandRater(Scanner in) {
        System.out.println("Enter your first card (EX:2s, jh, ac): ");
        hand[0] = cardParser(in.next().toLowerCase());
        System.out.println("Enter your second card (EX:2s, jh, ac): ");
        hand[1] = cardParser(in.next().toLowerCase());
        largestCard();
        System.out.println(handValuer());
    }

    public void largestCard() {
        int[] temp1 = hand[0];
        int[] temp2 = hand[1];
        if (temp1[0] < temp2[0]) {
            hand[0] = temp2;//swap two cards
            System.out.println("cards were swapped");
            hand[1] = temp1;
        }
    }

    public double handValuer() {
        double value = 0;
        int card1 = hand[0][0];
        int card2 = hand[1][0];
        System.out.println(card1 + " " + card2);
        if (card1 <= 10)
            value = (double)hand[0][0] / 2;
        else if (card1 == 14) {
            value = 10;
        } else if (card1 == 13) {
            value = 8;
        } else if (card1 == 12) {
            value = 7;
        } else if (card1 == 11) {
            value = 6;
        }

        if (card2 == card1) { //check for pockets
            value = value * 2;
            if (value < 5) {
                value = 5;
            }
        }

        if (ifSuitedHand()) { //check for suits
            value = value + 2;
        }

        if(card1 - card2 == 0){}
        else if(card1 - card2 == 1){
            value = value + 1;
        }
        else if(card1 - card2 == 2){
            value = value -1;
        }
        else if(card1 - card2 == 3){
            value = value -2;
        }
        else if(card1 - card2 == 4){
            value = value -4;
        }
        else {value = value-5;}


        return value;
    }

    public boolean ifSuitedHand() {
        if (hand[0][1] == hand[1][1]) {
            return true;

        } else return false;
    }

    public int[] cardParser(String a) { //spade=28 heart=17 club=12 diamond=13
        if (a.length() > 3 || a.length() < 2) throw new IllegalArgumentException("incorrect input");
        char[] charArray = a.toCharArray();
        int[] array = new int[2];
        //spades=1,hearts=2,clubs=3,diamond=4
        array[0] = Character.getNumericValue(charArray[0]);
        if (array[0] == 10) {
            array[0] = 14;
            array[1] = Character.getNumericValue(charArray[1]);
        }
        else if (array[0] == 20) {
            array[0] = 13;
            array[1] = Character.getNumericValue(charArray[1]);
        }
        else if (array[0] == 26) {
            array[0] = 12;
            array[1] = Character.getNumericValue(charArray[1]);
        }
        else if (array[0] == 19) {
            array[0] = 11;
            array[1] = Character.getNumericValue(charArray[1]);
        } else if (array[0] == 1 && Character.getNumericValue(charArray[1]) == 0) {
            array[0] = 10;
            array[1] = Character.getNumericValue(charArray[2]);
        } else {
            array[1] = Character.getNumericValue(charArray[1]);
        }
        System.out.println(array[0]+ " " + array[1]);

        return array;
    }

}
