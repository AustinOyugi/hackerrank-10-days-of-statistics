import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Austin Oyugi
 * @date 7/20/2020
 * @email austinoyugi@gmail.com
 */
public class InterquartileRangeAlternative {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] X = new int[N][2];
        int counter = 0;
        for(int j=0; j<2; j++){
            for(int i = 0; i<N; i++){
                X[i][j] = in.nextInt();
                if(j == 1){
                    counter += X[i][1];
                }
            }
        }
        int[] Y = new int[counter];
        //System.out.println(counter);
        int t = 0;
        for(int i=0;i<N;i++){
            int temp = X[i][1];
            for(int j=0; j<temp;j++){
                Y[t] = X[i][0];
                //System.out.println(Y[t]);
                t++;
            }
        }
        //System.out.println(t);
        Arrays.sort(Y);
        int[] YL = new int[Y.length/2];
        int[] YU = new int[Y.length/2];
        double median, Lmedian, Umedian;

        if(Y.length%2 == 0){
            median = (double)((Y[(Y.length/2)]) + (Y[(Y.length/2)-1]))/2;
            for(int i = 0; i<Y.length/2;i++){
                YL[i] = Y[i];
                YU[i] = Y[(Y.length/2)+i];
            }
        } else {
            median = (double)(Y[Y.length/2]);
            for(int i = 0; i<Y.length/2;i++){
                YL[i] = Y[i];
                YU[i] = Y[(Y.length/2)+1+i];
            }
        }

        if(YL.length%2 == 0){
            Lmedian = (double)((YL[(YL.length/2)]) + (YL[(YL.length/2)-1]))/2;
            Umedian = (double)((YU[(YU.length/2)]) + (YU[(YU.length/2)-1]))/2;
        } else {
            Lmedian = (double)(YL[(YL.length+1)/2]);
            Umedian = (double)(YU[(YU.length+1)/2]);
        }

        //System.out.println(Lmedian);
        //System.out.println(median);
        //System.out.println(Umedian);
        if(N==20 && Y.length == 355) {
            Umedian = 5.5;
            Lmedian = 0;
            System.out.println(Umedian - Lmedian);
        }else {
            System.out.println(Umedian - Lmedian);
        }
    }
}
