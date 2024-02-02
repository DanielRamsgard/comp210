package assn02;
import java.util.Scanner;

// Here is a starter code that you may optionally use for this assignment.
// TODO: You need to complete these sections

public class JavaWarmUp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        System.out.println("Input number of items:");
        int n = s.nextInt();
        // Date Time1 Category Fee Quantity Time2 AsmCost

        // create corresponding size arrays
        String[] date = new String[n];
        String[] time1 = new String[n];
        String[] category = new String[n];
        double[] fee = new double[n];
        int[] quantity = new int[n];
        double[] time2 = new double[n];
        double[] asmCost = new double[n];

		// TODO: Fill in the above arrays with data entered from the console.
        for (int i = 0; i < n; i++) {
            System.out.println("Input date:");
            date[i] = s.next();
            System.out.println("Input time1:");
            time1[i] = s.next();
            System.out.println("Input category:");
            category[i] = s.next();
            System.out.println("Input fee:");
            fee[i] = s.nextDouble();
            System.out.println("Input quantity:");
            quantity[i] = s.nextInt();
            System.out.println("Input time2:");
            time2[i] = s.nextDouble();
            System.out.println("Input asmCost:");
            asmCost[i] = s.nextDouble();

        }

        // Find items with highest and lowest price per unit
        int highestItemIndex = getMaxPriceIndex(fee);
        int lowestItemIndex = getMinPriceIndex(fee);

		// TODO: Print items with highest and lowest price per unit.
        // make sure the format is correct!
		// Your code starts here:

        // highest index data
        System.out.println(date[highestItemIndex]);
        System.out.println(time1[highestItemIndex]);
        System.out.println(category[highestItemIndex]);
        System.out.println(fee[highestItemIndex]);

        // lowest index data
        System.out.println(date[lowestItemIndex]);
        System.out.println(time1[lowestItemIndex]);
        System.out.println(category[lowestItemIndex]);
        System.out.println(fee[lowestItemIndex]);
		// Your code ends here.

        // Calculate the # of batches, total Fee, total Quantity, total Labor and Assembly costs by category.
        // Maintain following category-wise total stats in the following Category Arrays
        int[] numOfBatchesC = new int[categoriesList.length];// so numOfBatchesC[0] = # of batches in category categoriesList[0]
        double[] totFeeC = new double[categoriesList.length]; // total fee of each category = sum(fee * qty)
        int[] totQuantityC = new int[categoriesList.length];    // total qty of each category = sum (qty)
        double[] totLaborCostC = new double[categoriesList.length]; // total labor cost of each category = sum(time2 x 16)
        double[] totAsmCostC = new double[categoriesList.length]; // total Assembly cost of each category = sum(AsmCost)

		// TODO: for each item i, incrementally total the values in the above arrays
        for (int i = 0; i < n; i++) {
            int catIndex = 0;
            // set the value of catIndex for each i to be such that category[i] == categoriesList[catIndex]
            // TODO: Your code for setting catIndex here

            numOfBatchesC[catIndex]++;
            // TODO: fill in rest of the Category arrays here

        }

		// TODO: Calculate & Print Category-wise Statistics
        for (int j = 0; j < categoriesList.length; j++) {
            if (numOfBatchesC[j] > 0) {
                System.out.println( categoriesList[j]);
                // TODO: print the remaining stats

            }
        }
    }

    // TODO: Find index of item with the highest price per unit.
    static int getMaxPriceIndex(double[] priceT){
		// Your code starts here:
        double max = priceT[0];
        int index = 0;
        for (int i = 0; i < priceT.length; i++){
            if (max <= priceT[i]){
                index = i;
                max = priceT[i];
            }
        }

        return index; // modify this as well
		// Your code ends here.
    }

    // TODO: Find index of item with the lowest price per unit.
    static int getMinPriceIndex(double[] priceT){
        // Your code starts here:
        double min = priceT[0];
        int index = 0;
        for (int i = 0; i < priceT.length; i++){
            if (min >= priceT[i]){
                index = i;
                min = priceT[i];
            }
        }

        return index; // modify this as well
        // Your code ends here.
    }
}
