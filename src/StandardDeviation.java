import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Austin Oyugi
 * @date 7/22/2020
 * @email austinoyugi@gmail.com
 */
public class StandardDeviation {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int numberOFElements = scanner.nextInt();
      List<Integer> integerList = new ArrayList<>();
      for (int i=0; i<numberOFElements; i++){
        integerList.add(scanner.nextInt());
      }

      double mean = getMean(integerList);
      double sum = 0;
      for (Integer integerElement: integerList){
            sum += Math.pow(integerElement.doubleValue() - mean, 2);
      }

      DecimalFormat decimalFormat = new DecimalFormat("#.0");
      System.out.println(decimalFormat.format(Math.sqrt(sum/numberOFElements)));
  }

    public static double getMean(List<Integer> numArray) {
        int total = numArray.stream().mapToInt(x -> x).sum();
        return (double) total / numArray.size();
    }
}
