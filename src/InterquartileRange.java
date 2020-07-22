import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Austin Oyugi
 * @date 7/20/2020
 * @email austinoyugi@gmail.com
 */
public class InterquartileRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();

        List<Integer> elements = new ArrayList<>();
        List<Integer> integerList = new ArrayList<Integer>(){
            public boolean add(Integer integer) {
                int index = Collections.binarySearch(this, integer);
                if (index < 0) index = ~index;
                super.add(index, integer);
                return true;
            }
        };

        for (int i = 0; i<numberOfElements; i++){
            elements.add(scanner.nextInt());
        }

        for (int i =0 ; i<numberOfElements; i++){
            int frequency = scanner.nextInt();
            for (int x =0; x<frequency; x++)
                integerList.add(elements.get(i));
        }

        double median = getMedian(integerList);
        List<Integer> lowerQuartiles = new ArrayList<>();
        List<Integer> upperQuartiles = new ArrayList<>();

        integerList.forEach(x->{
            if (x<median)
                lowerQuartiles.add(x);
            else if (x>median)
                upperQuartiles.add(x);
        });

        double lowerQuartile = getMedian(lowerQuartiles);
        double uppperQuartile = getMedian(upperQuartiles);

        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println(decimalFormat.format(uppperQuartile - lowerQuartile));
    }

    public static double getMedian(List<Integer> theArray) {
        int position = theArray.size()/2;
        double median;
        if (theArray.size()%2 == 0)
            median =  Math.ceil((double) (theArray.get(position-1) + theArray.get(position))/2);
        else
            median = (double) theArray.get((int) (Math.ceil((double) theArray.size()/2))-1);
        return (median);
    }
}