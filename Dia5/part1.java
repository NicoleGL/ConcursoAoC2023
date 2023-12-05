import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class part1 {

    private static Long min(Long[] seeds, List<ArrayList<Long>> maps) {
        Long min = null;
        for(Long seed : seeds) {
            Long valor = seed;
            for(int i = 0; i < maps.size(); i++) {
                List<Long> nums = maps.get(i);
                for(int j = 0; j < nums.size(); j += 3) {
                    Long minRange = nums.get(j + 1);
                    if(valor >= minRange && valor < (minRange + nums.get(j + 2))) {
                        valor = nums.get(j) + (valor - minRange);
                        break;
                    }
                }
            }
            if(min == null || valor < min)
                min = valor;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seedStr = sc.nextLine().split(" ");
        Long[] seeds = new Long[seedStr.length - 1];
        for(int i = 1; i < seedStr.length; i++) {
            seeds[i - 1] = Long.parseLong(seedStr[i].trim());
        }

        List<ArrayList<Long>> maps = new ArrayList<ArrayList<Long>>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.contains("map")) {
                ArrayList<Long> nums = new ArrayList<Long>();
                while(sc.hasNextLong()) {
                    nums.add(sc.nextLong());
                }
                maps.add(nums);
            }
        }
        Long min = min(seeds, maps);
        System.out.println(min);
        sc.close();
    }
}
