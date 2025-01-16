import java.util.Scanner;

public class Car {
    private double price;
    private int no_of_doors;
    private String color;

    public Car(double pr, int door, String color) {
        this.price = pr;
        this.no_of_doors = door;
        this.color = color;
    }

    public static void main(String[ ] args){
        System.out.println("Suji");
        Scanner sc = new Scanner(System.in);
        Car c1 = new Car(120.43, 4, "red");
        System.out.println(c1.color);
    }

}


//Create code to 2d array, swap the first row with last and 2nd row with n-1 row and so on.
