package p1;

import java.util.ArrayList;
import java.util.Scanner;
/*
Chungsing Arguello
CSC164
Balloon Project
 */

public class Main {

    public static void main(String[] args) {
        //array of balloons/Menu selection
        ArrayList<balloon> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option;
        int userSize;
        String userColor;

        // main menu
        do{
            System.out.println("Main Menu\n" + "  (1) Create default balloon\n" + "  (2) Create Balloon\n" +
                    "  (3) Destroy Balloon\n" + "  (4) Inflate Balloon\n" + "  (5) Show Balloons\n" + "  (6) Exit");
            System.out.println("choose: ");
            option = input.nextInt();

            //balloon default creation
            if(option == 1){
                if(!isArrayFull(list))
                    System.out.println("It's full, please destroy a balloon before creating another.");
                else {
                    balloon b1 = new balloon();
                    list.add(b1);
                }
            }
            //balloon creation
            else if (option == 2){
                if (!isArrayFull(list))
                    System.out.println("It's full, please destroy a balloon before creating another.");
                else {
                    System.out.println("Choose a size (6, 8, 10, 12): ");
                    userSize = input.nextInt();
                    isValidSize(userSize);

                    System.out.println("Choose a color(red, blue, green, yellow): ");
                    userColor = input.next();
                    isValidColor(userColor);

                    balloon b2 = new balloon(userSize, userColor);
                    list.add(b2);
                }
            }
            //balloon destroy
            else if (option == 3){
                if(isValidBalloon(list))
                    System.out.println("There are no balloons to destroy.");
                else {
                    for (balloon each : list)
                        System.out.println(each.toString());

                    System.out.println("which balloon would you like to destroy? (1, 2, 3, 4, 5): ");
                    int selection = input.nextInt();
                    while (selection < 1 || selection > 5) {
                        System.out.println("Choose from the following list (1, 2, 3, 4, 5): ");
                        selection = input.nextInt();
                    }
                    list.remove(selection);
                }
            }
            //balloon inflation
            else if (option == 4){
                isBalloonInflated(list);
            }
            //show balloons
            else if (option == 5){
                for (balloon each : list)
                    System.out.println(each.toString());
            }
        }while(option != 6);
    }
    //Checking if Array full
    public static boolean isArrayFull(ArrayList<balloon> arg){
       if (arg.size() == 5)
           return false;
        else
           return true;
    }
    //validating the size of balloon input
    public static void isValidSize(int size){
        Scanner input = new Scanner(System.in);

        while (size != 6 && size != 8 && size != 10 && size != 12) {
            System.out.println("Choose from the following list\nChoose a size (6, 8, 10, 12): ");
            size = input.nextInt();
        }
    }
    //Validating the color of the balloon
    public static void isValidColor(String color){
        Scanner input = new Scanner(System.in);

        while(!color.equals("red") && !color.equals("blue") && !color.equals("green")
                && !color.equals("yellow")) {
            System.out.println("Choose from the following list\nChoose a color(red, blue, green, yellow): ");
            color = input.next();
        }
    }
    public static boolean isValidBalloon(ArrayList<balloon> arg){
        if (arg.size() == 0)
            return true;
        else
            return false;
    }
    public static void isBalloonInflated(ArrayList<balloon> arg){
        Scanner input = new Scanner(System.in);

        if (isValidBalloon(arg))
            System.out.println("There are no balloons to inflate");
        else {
            for (balloon each : arg)
                System.out.println(each.toString());

            System.out.println("Which balloon would you like to inflate? (1, 2, 3, 4, 5) ");
            int selection = input.nextInt();
            while(selection < 1 || selection > 5){
                System.out.println("Choose again, from the following list (1, 2, 3, 4, 5): ");
                selection = input.nextInt();
            }
            if (arg == selection)){

            }
        }


    }
}
//class of balloon
class balloon {
    //properties
    private int size;
    private String color;
    private boolean inflated;
    private static int quantity;

    balloon() {
        size = 6;
        color = "red";
        inflated = false;
        quantity++;
    }
    balloon(int s, String c){
        size = s;
        color = c;
        inflated = false;
        quantity++;
    }
    static int getQuantity(){
        return quantity;
    }
    public boolean isInflated() {
        return inflated;
    }
    public void setInflated(boolean arg) {
        inflated = arg;
    }
    @Override
    public String toString() {
        return "balloon{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", inflated=" + inflated +
                '}';
    }
}

