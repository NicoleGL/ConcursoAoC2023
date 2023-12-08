package Dia8;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class part2 {
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
        int contador = 0;
        boolean fin = false;
        while(!fin) {
            for(int i = 0; i < directions.length() && !fin; i++) {
                ArrayList<String> newNodes = new ArrayList<>();
                fin = true;
                char direction = directions.charAt(i);
                System.out.println(direction);
                for(int j = 0; j < origin.size(); j++) {
                    String[] adjacent = map.get(origin.get(j));
                    String node = (direction == 'L')? adjacent[0] : adjacent[1];
                    newNodes.add(node);
                    fin = fin && (node.charAt(2) == 'Z');
                }
                contador++;
                origin = newNodes;
            }
        }

        System.out.println(contador);
        sc.close();
    }
}
