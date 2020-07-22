import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Austin Oyugi
 * @date 7/19/2020
 * @email austinoyugi@gmail.com
 */
public class MeanMedianMode {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    double[] numArray = new double[n];

    for (int x = 0; x < n; x++) {
      numArray[x] = input.nextInt();
    }

    System.out.println(getMean(numArray));
    System.out.println(getMedian(numArray));
    System.out.println(getMode(numArray));
  }

  public static String getMean(double[] numArray) {
    int total = 0;
    for (double i : numArray) {
      total += i;
    }

    DecimalFormat decimalformat = new DecimalFormat("#.#");
    double mean = (double) total / numArray.length;
    return String.valueOf(decimalformat.format(mean));
  }

  public static String getMedian(double[] theArray) {
    Arrays.sort(theArray);
    int position = theArray.length / 2;

    DecimalFormat decimalformat = new DecimalFormat("#.#");
    double median;
    if (theArray.length % 2 == 0) {
      median = (theArray[position] + theArray[position - 1]) / 2;
    }
    median = (theArray[position - 1] + theArray[position]) / 2;
    return String.valueOf(decimalformat.format(median));
  }


  public static String getMode(double[] numArray) {
    Map<Double, Integer> occurrence = new HashMap<>();

    for (double i : numArray) {
      if (occurrence.containsKey(i)) {
        int value = occurrence.get(i);
        occurrence.put(i, value + 1);
      } else {
        occurrence.put(i, 1);
      }
    }

    Map<Double, Integer> sorted = new TreeMap<>(occurrence);
    AtomicInteger largest = new AtomicInteger(1);
    AtomicBoolean changed = new AtomicBoolean(false);
    sorted.forEach(
        (key, value) -> {
          if (value > largest.get()) {
            largest.set(value);
            changed.set(true);
          }
        });

    if (changed.get()) {
      return "" + largest;
    }
    return "" + sorted.keySet().stream().findFirst().get();
  }
}
