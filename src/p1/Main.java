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
            System.out.println("Main Menu\n" +  "  (1) Create Balloon\n" +
                    "  (2) Destroy Balloon\n" + "  (3) Inflate Balloon\n" + "  (4) Show Balloons\n" + "  (5) Exit");
            System.out.println("choose: ");
            option = input.nextInt();

            //balloon default creation

            //balloon creation
            if (option == 1){
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
            else if (option == 2){
                if(isValidBalloon(list))
                    System.out.println("There are no balloons to destroy.");
                else {
                    for (balloon each : list)
                        System.out.println(each.toString());

                    System.out.println("Which balloon would you like to destroy? (Size and Color)\n" +
                            "Choose the size (6, 8, 10, 12): ");
                    int s = input.nextInt();
                    while (s != 6 && s != 8 && s != 10 && s != 12) {
                        System.out.println("Choose from the following list\nChoose the size (6, 8, 10, 12): ");
                        s = input.nextInt();
                    }
                    System.out.println("Choose the color(red, blue, green, yellow): ");
                    String c = input.next();
                    while(!c.equals("red") && !c.equals("blue") && !c.equals("green")
                            && !c.equals("yellow")) {
                        System.out.println("Choose from the following list\nChoose the color(red, blue, green, yellow): ");
                        c = input.next();
                    }
                    for ( balloon each : list)
                        if (each.getColor().equals(c) && each.getSize() == s){
                            list.remove(each);
                        }
                }
            }
            //balloon inflation
            else if (option == 3){
                isBalloonInflated(list);
            }
            //show balloons
            else if (option == 4){
                for (balloon each : list)
                    System.out.println(each.toString());
                    System.out.println("Number of balloons " + list.size());
            }
        }while(option != 5);
    }
    //////////METHODS//////////
    //Checking if Array full
    public static boolean isArrayFull(ArrayList<balloon> arg){
        return arg.size() != 5;
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
    //validating if balloons are in the ArrayList
    public static boolean isValidBalloon(ArrayList<balloon> arg){
        return arg.size() == 0;
    }
    //inflating a balloon
    public static void isBalloonInflated(ArrayList<balloon> arg){
        Scanner input = new Scanner(System.in);

        if (isValidBalloon(arg))
            System.out.println("There are no balloons to inflate");
        else {
            for (balloon each : arg)
                System.out.println(each.toString());

            System.out.println("Which balloon would you like to inflate? (Size and Color)\n" +
                    "Choose the size (6, 8, 10, 12): ");
            int s = input.nextInt();
            while (s != 6 && s != 8 && s != 10 && s != 12) {
                System.out.println("Choose from the following list\nChoose the size (6, 8, 10, 12): ");
                s = input.nextInt();
            }
            System.out.println("Choose the color(red, blue, green, yellow): ");
            String c = input.next();
            while(!c.equals("red") && !c.equals("blue") && !c.equals("green")
                    && !c.equals("yellow")) {
                System.out.println("Choose from the following list\nChoose the color(red, blue, green, yellow): ");
                c = input.next();
            }
            for ( balloon each : arg)
                if (each.getColor().equals(c) && each.getSize() == s){
                    each.setInflated();
                    System.out.println(each);
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
    //custom constructor
    balloon(int s, String c){
        size = s;
        color = c;
        inflated = false;
    }
    int getSize(){
        return size;
    }
    String getColor(){
        return color;
    }
    public boolean setInflated(){
        return inflated = true;
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