package PPS_related_codes.Binary_files_io;

import java.util.Scanner;
import java.io.*;

class Car implements Serializable {
    private int num_of_doors;
    private double price;
    private int num_of_seats;

    public Car(){
        num_of_doors = 4;
        price = 10000; // Changed default price to match expected output.
        num_of_seats = 5;
    }
    public Car(int nd, double pr, int ns){
        this.num_of_doors = nd;
        this.price = pr;
        this.num_of_seats = ns;
    }

    public Car(Car c){
        num_of_doors = c.num_of_doors;
        price = c.price;
        num_of_seats = c.num_of_seats;
    }
    public int getNum_of_doors(){
        return num_of_doors;
    }
    public double getPrice(){
        return price;
    }
    public int getNum_of_seats(){
        return num_of_seats;
    }
    public void setNum_of_doors(int nd){
        num_of_doors = nd;
    }
    public void setPrice(double pr){
        price = pr;
    }
    public void setNum_of_seats(int ns){
        num_of_seats = ns;
    }

    public String toString(){
        return "The car has " + num_of_doors + " Doors and the price of the car is $ " +
                price + " and the car has " + num_of_seats + " seats.";
    }
}

public class FileIo14 {


    public static void main(String[] args) throws IOException {
            Car c1 = new Car(4, 3000, 5);
            Car c2 = new Car(2, 23000, 2);
            Car c3 = new Car();
            System.out.println(c1.getPrice());
            System.out.println(c2.getPrice());
            Car c4 = new Car(c3);
            System.out.println(c4.getNum_of_doors());

            String fileName;
            Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name for the binary file: ");
        fileName = sc.next();

        ObjectOutputStream oos = null;
        try{
    oos = new ObjectOutputStream(new FileOutputStream(fileName));
    oos.writeObject(c1);
    oos.writeObject(c2);
    oos.writeObject(c3);
    oos.writeObject(c4);
    oos.close();
    System.out.println("THe file has been written out");
} catch (IOException e) {
    System.out.println("Cannot find the file");
    System.out.println("The system will now stop");
    System.exit(0);
}

ObjectInputStream ois = new ObjectInputStream(new FileInputStream("suji.dat"));
Car cr;
int i = 1;
        System.out.println("This will now display the contetns of the dat file");

        try{
            while(true){
                cr = (Car)ois.readObject();
                System.out.println("Her is the info of the object #" + i++ + ": ");
                System.out.println(cr);
            }

        } catch (ClassNotFoundException e){
            System.out.println("THe class cant be found");
        }
        catch (EOFException e){
            System.out.println("This si the end pf the file");
            System.exit(0);
        }
        ois.close();


    }
}
