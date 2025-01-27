import java.util.Scanner;
import java.util.Random;

public class Transcript_name_printing {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String [] st = sc.nextLine().split(" ");
        String middle_name = "";
        String last_name = "";
//
//        for (String word : st){
//            System.out.println(word);
//        }

        String first_name = st[0];
        if (st.length <= 2){
             last_name = st[1];
        }
        else{
             middle_name = st[1];
             last_name = st[st.length - 1];
        }
        System.out.println(last_name + " " + first_name + " " + middle_name);

    }
}


//abc
//def

//adbecf
