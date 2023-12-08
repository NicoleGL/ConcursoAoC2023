import java.util.Scanner; 
import java.util.Map;
import java.util.HashMap;

public class part1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String directions = sc.nextLine() + sc.nextLine();
        Map<String, String[]> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String[] nodes = sc.nextLine().split(" = \\(|\\) *|, + *");
            System.out.println(nodes[0]);
            System.out.println(nodes[1]);
            System.out.println(nodes[2]);
            String[] adjacent = new String[]{nodes[1], nodes[2]};
            map.put(nodes[0], adjacent);
        }
        int contador = 0;
        String node = "AAA";
        while(!node.equals("ZZZ")) {
            for(int i = 0; i < directions.length() && !node.equals("ZZZ"); i++) {
                char direction = directions.charAt(i);
                String[] adjacent = map.get(node);
                node = (direction == 'L')? adjacent[0] : adjacent[1];
                contador++;
            }
        }

        System.out.println(contador);
        sc.close();
    }
}