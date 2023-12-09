import java.util.Scanner;
import java.util.ArrayList;

public class part1 {

    private static int prediccion(String[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> numsRes = new ArrayList<>();
        for(String num : nums) {
            numsRes.add(Integer.parseInt(num));
        }
        res.add(numsRes);

        boolean todoCeros = false;
        int prediccion = numsRes.get(numsRes.size() - 1);
        while(!todoCeros) {
            todoCeros = true;
            ArrayList<Integer> newArr = new ArrayList<>();
            for(int i = 1; i < numsRes.size(); i++) {
                int a = numsRes.get(i - 1);
                int b = numsRes.get(i);
                newArr.add(b - a);
                todoCeros = todoCeros && (b - a == 0);
            }
            prediccion += newArr.get(newArr.size() - 1);
            res.add(newArr);
            numsRes = newArr;
        }
        return prediccion;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(sc.hasNextLine()) {
            String[] numStr = sc.nextLine().split(" ");
            sum += prediccion(numStr);
        }

        System.out.println(sum);
        sc.close();
    }
}
