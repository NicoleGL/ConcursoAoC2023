package Dia6;

import java.util.Scanner;

public class part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] times = sc.nextLine().split(" + *");
        String[] distances = sc.nextLine().split(" + *");
        String timeStr = "";
        String distanceStr = "";
        for(int i = 1; i < times.length; i++) {
            timeStr += times[i];
            distanceStr += distances[i];
        }
        Long time = Long.parseLong(timeStr);
        Long distance = Long.parseLong(distanceStr);
        Long j = (time%2 == 0)? time/2 -1: time/2;
        int contador = 0;
        while(j > 0 && (time - j)*j > distance) {
            contador += 2;
            j--;
        }
        if(time%2 == 0 && (time/2)*(time/2) > distance)
            contador++;
        System.out.println(contador);
        sc.close();
    }
}
