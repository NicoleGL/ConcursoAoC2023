import java.util.Scanner;

public class part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 1;
        String[] timeStr = sc.nextLine().split(" + *");
        String[] distanceStr = sc.nextLine().split(" + *");
        for(int i = 1; i < timeStr.length; i++) {
            int time = Integer.parseInt(timeStr[i]);
            int distance = Integer.parseInt(distanceStr[i]);
            System.out.println(time);
            System.out.println(distance);
            int j = (time%2 == 0)? time/2 -1: time/2;
            int contador = 0;
            while(j > 0 && (time - j)*j > distance) {
                contador += 2;
                j--;
            }
            if(time%2 == 0 && (time/2)*(time/2) > distance)
                contador++;
            System.out.println(contador);
            total *= contador;
        }
        System.out.println(total);
        sc.close();
    }
}
