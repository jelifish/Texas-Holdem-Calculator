import java.util.Scanner;

public class Main {

    public static void main(String[] args) { //hand value optimizer based on existing calculated values
       Scanner in = new Scanner(System.in);
        StartingHandRater rater = new StartingHandRater(in);

        in.close();
    }

}
