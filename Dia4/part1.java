package Dia4;

import java.util.Scanner;

public class part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int counter;

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            counter = 0;
            String[] parts = line.split(":|\\|");
            String[] winningNums = parts[1].trim().split(" + *");
            String[] nums = parts[2].trim().split(" + *");
            for(String winningNum : winningNums) {
                for(String num : nums) {
                    if(num.trim().equals(winningNum.trim())) {
                        counter++;
                    }
                }
            }
            if(counter > 0)
                sum += Math.pow(2, (counter - 1));
        }

        sc.close();
        System.out.println(sum);
    }
}
