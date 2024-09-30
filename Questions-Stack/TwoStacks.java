import java.util.*;

public class TwoStacks {

    static int twoStacks(int x, int[] a, int[] b){
        return twoStacks(x, a, b, 0, 0) - 1;
    }

    private static int twoStacks(int x, int[] a, int[] b, int sum, int count){
        if(sum > x){
            return count;
        }

        if(a.length == 0 || b.length == 0){
            return count;
        }

        int ans1 = twoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
        int ans2 = twoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum + a[0], count + 1);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // size of array 'a'
            int m = sc.nextInt(); // size of array 'b'
            int x = sc.nextInt();
            int[] a = new int[n]; // array 'a' having size 'n'
            int[] b = new int[m]; // array 'b' having size 'm'

            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }

            for (int j = 0; j < m; j++) {
                b[j] = sc.nextInt();
            }
            
            System.out.println(twoStacks(x, a, b));

            sc.close();
        }
    }
}