package Dia4;

import java.util.Scanner;
import java.util.ArrayList;

public class part2 {

    private static int numOfWinners(String card) {
        int counter = 0;
        String[] parts = card.split(":|\\|");
        String[] winningNums = parts[1].trim().split(" + *");
        String[] nums = parts[2].trim().split(" + *");
        for(String winningNum : winningNums) {
            for(String num : nums) {
                if(num.trim().equals(winningNum.trim())) {
                    counter++;
                }
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numOfCards = new int[220];
        int sum = 0;
        int counter;

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            int id = Integer.parseInt(line.split(":")[0].split(" + *")[1]);
            System.out.println(id);
            numOfCards[id]++;
            counter = numOfWinners(line);
            for(int i = 1; i <= counter; i++) {
                numOfCards[id + i] += numOfCards[id];
            }
            System.out.println(numOfCards[id]);
            System.out.println(counter);
            System.out.println("---");
        }

        for(int num : numOfCards)
            sum += num;

        sc.close();
        System.out.println(sum);
    }
}
