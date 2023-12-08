package Dia8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class part2b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String directions = sc.nextLine() + sc.nextLine();
        Map<String, String[]> map = new HashMap<>();
        ArrayList<String> origin = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] nodes = sc.nextLine().split(" = \\(|\\) *|, + *");
            String[] adjacent = new String[]{nodes[1], nodes[2]};
            map.put(nodes[0], adjacent);
            if(nodes[0].charAt(2) == 'A')
                origin.add(nodes[0]);
        }

        for(int j = 0; j < origin.size(); j++) {
            String node = origin.get(j);
            int contador = 0;
            while(!(node.charAt(2) == 'Z')) {
                for(int i = 0; i < directions.length() && !(node.charAt(2) == 'Z'); i++) {
                    char direction = directions.charAt(i);
                    String[] adjacent = map.get(node);
                    node = (direction == 'L')? adjacent[0] : adjacent[1];
                    contador++;
                }
            }
            System.out.println(contador);
        }

        sc.close();
    }
}
