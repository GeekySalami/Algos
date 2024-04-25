import java.util.Scanner;

public class Fifpuzz {
    Pieces scrambledboard [][] = new Pieces[4][4];

    final int targetboard [][]={{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12},
                      {13,14,15,0}
        };

    public void initboard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of puzzle to be solved row by row(0 for the missing puzzle key): ");
        
        for (int i = 0; i < scrambledboard.length; i++) {
            for (int j = 0; j < scrambledboard.length; j++) {
                scrambledboard[i][j] = new Pieces();
                scrambledboard[i][j].val = sc.nextInt();

                if (i == 0) {
                    scrambledboard[i][j].moves[0] = false;
                }
                else if (i == 3) {
                    scrambledboard[i][j].moves[1] = false;
                }
                else if (j == 0) {
                    scrambledboard[i][j].moves[2] = false;
                    
                }
                else if (j == 3) {
                    scrambledboard[i][j].moves[3] = false;
                }
            }
        }
        sc.close();
    }

    public static void main(String[] args) {
        Fifpuzz ob = new Fifpuzz();
        ob.initboard();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ob.scrambledboard[i][j].val + ", ");
            }
            System.out.println();
        }

        /*
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("{");
                for (int j2 = 0; j2 < 4; j2++) {
                    System.out.print(ob.scrambledboard[i][j].moves[j2] + ", ");
                }
                System.out.print("}, ");
            }
            System.out.println();
        }
        */

        boolean can = ob.checksolvable(ob.scrambledboard);

        System.out.println("***can***? = "+can);

        if (can) {
            
        }
    }

    public boolean checksolvable(Pieces scrambled[][]){
        int checkarray [] = new int[16], k = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                checkarray[k] = scrambled[i][j].val;
                k++;
            }
        }
        /*
        for (int i = 0; i < checkarray.length; i++) {
            System.err.print(checkarray[i]+",");
        }
        */
        int invct = 0;
    for (int i = 0; i < checkarray.length - 1; i++) {
        if (checkarray[i] == 0) continue; 
        for (int j = i + 1; j < checkarray.length; j++) {
            if (checkarray[j] == 0) continue; 
            if (checkarray[i] > checkarray[j]) {
                invct++;
            }
        }
    }
        System.out.println(invct);
        if (invct%2 != 0) {
            return true;
        }
        else{
            return false;
        }
    }
}

class Pieces{
    int val;
    //                 {0=up, 2=down, 2=left, 3=right};                      
    boolean moves [] = {true, true  , true  , true   };
}
