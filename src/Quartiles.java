import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Austin Oyugi
 * @date 7/20/2020
 * @email austinoyugi@gmail.com
 */
public class Quartiles {
  public static void main(String[] args) {

      Scanner scanner = new Scanner(System.in);
      int numberOfElements = scanner.nextInt();
      Integer[] elementArray = new Integer[numberOfElements];

      for (int i = 0; i<numberOfElements; i++){
          elementArray[i] = scanner.nextInt();
      }
      Arrays.sort(elementArray);

      double median = getMedian(elementArray);
      List<Integer> lowerQuartiles = new ArrayList<>();
      List<Integer> upperQuartiles = new ArrayList<>();

      for (int x: elementArray){
        if (x<median)
            lowerQuartiles.add(x);
        else if (x>median)
            upperQuartiles.add(x);
      }

      Integer[] lowers = lowerQuartiles.toArray(new Integer[0]);
      double lowerQuartile = getMedian(lowers);

      Integer[] uppers = upperQuartiles.toArray(new Integer[0]);
      double uppperQuartile = getMedian(uppers);

      System.out.println((int) lowerQuartile);
      System.out.println((int) median);
      System.out.println((int)uppperQuartile);
  }

  public static double getMedian(Integer[] theArray) {
      int position = theArray.length/2;
      double median;
      if (theArray.length%2 == 0)
          median = (double) (theArray[position-1] + theArray[position])/2;
      else
          median = (double) theArray[(int) (Math.ceil((double) theArray.length/2))-1];
      return (median);
  }
}