import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Austin Oyugi
 * @date 7/20/2020
 * @email austinoyugi@gmail.com
 */
public class WeightedMean {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int numberOfElements = scanner.nextInt();
      double[] arrayX = new double[numberOfElements];

      for (int i = 0; i<numberOfElements; i++){
          arrayX[i] = scanner.nextInt();
      }

      double sumProduct = 0;
      double sumWeights = 0;
      for (int i = 0; i<numberOfElements; i++){
          double input = scanner.nextDouble();
          sumProduct += input * arrayX[i];
          sumWeights += input;
      }
      scanner.close();

      DecimalFormat decimalFormat = new DecimalFormat("#.0");
      double weightedMean = sumProduct/sumWeights;
      System.out.println(decimalFormat.format(weightedMean));
  }
}
