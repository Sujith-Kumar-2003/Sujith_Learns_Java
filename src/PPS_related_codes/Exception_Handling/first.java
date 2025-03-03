package PPS_related_codes.Exception_Handling;

public class first {
    public static void main(String [] args){
        try{
            Integer.parseInt("Nigga");
        }
        catch(NumberFormatException e){
            System.out.println("Hey dude, You cant print that.");
        }
    }
}
