package greedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
     public double fractionalKnapsack(int[] val, int[] wt, long cap) 
    {
        int n = val.length;

        double ratio[][] = new double[n][2];
        // 0th col => index, 1st col => ratio

        for (int i = 0; i < n; i++) 
        {
            ratio[i][0] = i;
            ratio[i][1] = (double) val[i] / wt[i];
        }

        // sort in ascending order of ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        double finalVal = 0.0;

        // traverse from highest ratio
        for (int i = n - 1; i >= 0; i--) 
        {
            int idx = (int) ratio[i][0];

            if (cap >= wt[idx]) 
            {
                // take full item
                finalVal += val[idx];
                cap -= wt[idx];
            } 
            else 
            {
                // take fraction
                finalVal += ratio[i][1] * cap;
                break;
            }
        }

        // round to 6 decimal places
        return Math.round(finalVal * 1e6) / 1e6;
    }
}
