public class Main{
    public static void main(String[] args){
        int term = fibRecursive(10);
        System.out.print("Nth Term: "+ term);
        return;
    }
    
    public static int fibRecursive(int n){
        if (n<=2)
            return 1;
        return fibRecursive(n-1) + fibRecursive(n-2);
    }
}