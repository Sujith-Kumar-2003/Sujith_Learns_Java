import java.util.Scanner;
import java.util.Random;

public class fourth {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int row_size = sc.nextInt();
//        int col_size = sc.nextInt();
//        sc.nextLine();
//
        int [][] arr = new int[20][];
        int rowcount = 0;
            while (true){
                String input = sc.nextLine().trim();
                if (input.isEmpty()){
                    break;
                }
                String [] inputnums = input.split(" ");
                int [ ] nextRow = new int[inputnums.length];

                for (int i = 0; i< inputnums.length; i++){
                    nextRow[i] = Integer.parseInt(inputnums[i]);
                }
                arr[rowcount] = nextRow;
                rowcount++;
            }
            for (int i = 0;i < rowcount; i++){
                for (int j = 0; j < arr[i].length; j ++)
                System.out.print(arr[i][j]+ " ");
            }
    System.out.println("");

    }
}


//Sample input?
//4 6

