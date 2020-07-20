import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Austin Oyugi
 * @date 7/19/2020
 * @email austinoyugi@gmail.com
 */
public class MeanMedianModeAlternative {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<Double> list=new ArrayList<Double>();
        double sum=0, mean=0,median=0, mode;
        int n,c,max=0;
        double v;
        n=sc.nextInt();
        for(int i=0;i<n;i++) {
            v=sc.nextDouble();
            sum+=v;
            list.add(v);
        }

        mean=(double) sum/n;
        Collections.sort(list);
        int a=n-1;
        if(n%2==0) {
            median=(list.get((a/2))+list.get((a/2)+1))/2;
        }
        else {
            median=(list.get(a/2))/2;
        }

        mode=list.get(0);
        for(int j=0;j<n;j++) {
            double itr=list.get(j);
            c=0;
            for(int k=0;k<n;k++) {
                if((itr==list.get(k))) {
                    c++;
                    if(c>max) {
                        max=c;
                        if(max==1) {
                            mode=list.get(0);
                        }
                        mode=itr;
                    }
                }
            }
        }
        System.out.println(mean);
        System.out.println(median);
        System.out.println((int)mode);
        sc.close();
    }
}
