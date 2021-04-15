
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static int [] towers;
    private static BufferedWriter bw;
    public static void main(String[] args) throws Exception {

      Scanner sc=new Scanner(System.in);
      bw = new BufferedWriter(new FileWriter("output.txt"));

        int m=Integer.parseInt(sc.nextLine());

        for (int i = 0; i < m; i++) {

            int n=Integer.parseInt(sc.nextLine());

            towers=new int[3];
    
            towers[0]=n;
    
            bw.write(print(towers));
            soluction(n,1,2,3,towers);

            if (i!=m-1){
                bw.write("\n");
            }
            
        }

        bw.flush();
        bw.close();
        sc.close();
    }




    public static void soluction(int n,int init,int aux,int dest,int []towers ) throws IOException{

        if (n==1){
            towers[init-1]--;
            towers[dest-1]++;
            bw.write(print(towers));
        }else{
            soluction(n-1, init, dest, aux,towers);
            towers[init-1]--;
            towers[dest-1]++;
            bw.write(print(towers));
            soluction(n-1, aux, init, dest,towers);
        }   


    }


    public static String print(int [] towers){
        return (towers[0]+" "+towers[1]+" "+towers[2]+"\n");

    }
}
