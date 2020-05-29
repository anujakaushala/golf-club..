package com.company;
import java.util.*;
public class Main {
    static Scanner input = new Scanner(System.in);
    static HashMap<String, Integer> hm = new HashMap<String, Integer>();
    static String name;
    static int stokes;
    private static String Y;
    private static String N;
    public static void main(String[] args) {
        decision();
    }
    private static void decision() {
        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("welcome to Springfield Golf Club.");
        System.out.println("select option");
        System.out.println("1) Enter scores");
        System.out.println("2) Find golfer");
        System.out.println("3) Display scoreboard");
        System.out.println("4) Exit program");
        System.out.println(">");
        option = input.nextInt();
        do {
            try {

                switch (option) {
                    case 1:
                        enterScore();
                        decision();
                        break;
                    case 2:
                        findGolfer();
                        break;
                    case 3:
                        displayScoreboard();
                        decision();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("invalid option!!  reenter");
                        decision();
                }
            }catch (Exception e) {
                System.out.println("invalid character");
                decision();
            }
            } while (option < 1 || option > 4) ;

        }

    private static void displayScoreboard() {      //displaying score board

        System.out.println(" --score board-- ");
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("Name:" + mentry.getKey() + " Scores:");
            System.out.println(mentry.getValue());


        }
    }

    private static void findGolfer() {        //search the golfer
        if (hm.isEmpty()) {
            System.out.println("enter details first");
            decision();
        }
        System.out.println("enter the player's name that you want to find");
        String SearchName = input.next();
        if (hm.containsKey(SearchName)) {
            System.out.println(SearchName + " scores " + hm.get(SearchName));
            decision();
        } else {
            System.out.println("player name doesn't exist");
            findGolfer();
        }

    }

    private static void enterScore() {             //getting number of golfers in the group

        Scanner input = new Scanner(System.in);
        System.out.println("how  many golfers in the group");
        int group = input.nextInt();


        for (int i = 0; group > i;group--) {

            do {

                    System.out.println("enter the name  ");
                    name = input.next();
                    System.out.println(name);
                    if (hm.containsKey(name)) {
                        System.out.println("this name is existing");
                        System.out.println("If you want to re-enter name, enter 'Y' : If you want to update stokes enter 'N' ");
                        String reenter = input.next();
                        if (reenter.equals("Y")) {

                            System.out.println("enter the name  ");
                            name = input.next();
                        } else if (reenter.equals("N")) {

                        } else {
                            System.out.println("invalid letter.");
                            System.out.println("enter the letter  ");
                            reenter = input.next();
                            System.out.println("enter name");
                            name = input.next();
                        }
                        stokes();
                    } else {
                        stokes();

                    }

            } while (stokes >= 18 && stokes <= 108);
        }
    }

    private static void stokes() {                  //getting stokes

        System.out.println("enter number of stokes");
        int stokes = input.nextInt();
        if (stokes >= 18 && stokes <= 108) {
            System.out.println(stokes);

            hm.put(name, stokes);
            Set<Map.Entry<String, Integer>> hashSet = hm.entrySet();
        } else {
            System.out.println("not in range");
            stokes();
        }
    }
    private static int validator(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("This is a non-numerical value !!!");
            input.next();
            enterScore();
        }
        return input.nextInt();
    }
}




