import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main{
    public static void main(String[] args){
        // int term = fibRecursive(50);

        // HashMap<Integer, Integer> map = new HashMap<>();
        // int termDP = fibRecursiveDP(40, map);
        // System.out.println("Nth Term: "+ term);
        // System.out.println("Nth Term Using DP: "+ termDP);
        System.out.println("Grid Traveller Normal: " + gridTraveller(2, 3));

        //GridTraveller
        // HashMap<String, Integer> memoGridTraveller = new HashMap<>();
        // System.out.println("Grid Traveller using DP: " + gridTravellerDP(3,7,memoGridTraveller));

        // List<Integer> memo = new ArrayList<>();
        int ar[] = {2,2,2,5,290,31};

        HashMap<Integer, List<Integer>> memo = new HashMap<>();
        System.out.println("HowSum:"+howSum(300, ar, memo));
    }
    
    public static int fibRecursive(int n){
        if (n<=2)
            return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }
    
    //Fibonaaci nth Term Using Dynamic Programming
    public static int fibRecursiveDP(int n, HashMap<Integer, Integer> map)
    {        
        if(n<=2) return 1;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        else {
            int value = fibRecursiveDP(n-1, map) + fibRecursiveDP(n-2, map);
            map.put(n, value);
            return value; 
        }
    }

    //In how many ways can a traveller travel in the grid(m x n), if they can travel only down and right
    public static int gridTraveller(int m, int n) {
        if (m==1 && n==1) return 1;
        else if (m==0 || n==0) return 0;
        return gridTraveller(m-1, n) + gridTraveller(m, n-1);
    }

    public static int gridTravellerDP(int m, int n, HashMap <String, Integer>memo) {
        if (m==1 && n==1) return 1;
        else if (m==0 || n==0) return 0;
        String key = m + ","+ n;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int value = gridTravellerDP(m-1, n, memo) + gridTravellerDP(m, n-1, memo);
        memo.put(key, value);
        return value;
    }

    public static boolean canSum(int targetSum, int ar[], List<Integer> falseCases) {
        if(targetSum == 0) return true;
        if(falseCases.contains(targetSum)) return false;
        if(targetSum < 0) return false;

        for(int i=0; i<ar.length; i++){
            boolean value = canSum(targetSum-ar[i], ar, falseCases);
            if(value) return true;
            if(!falseCases.contains(targetSum-ar[i])) falseCases.add(targetSum-ar[i]);
        }
        return false;
    }

    public static List<Integer> howSum(int targetSum, int ar[], HashMap<Integer, List<Integer>> memo) {
        if(targetSum == 0) {
            return new ArrayList<>();
        }
        if(targetSum<0) return null;
        if(memo.containsKey(targetSum)) return memo.get(targetSum);

        List<Integer> prevSequence;
        for(int i = 0; i<ar.length; i++){
            int diff = targetSum - ar[i];
            prevSequence = howSum(diff, ar, memo);
            if(prevSequence != null) {
                prevSequence.add(ar[i]);
                memo.put(ar[i], prevSequence);
                return memo.get(ar[i]);
            }
        }
        return null;
    }
}