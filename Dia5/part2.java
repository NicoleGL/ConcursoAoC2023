import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class part2 {
    private static Long min(ArrayList<Long> seeds, List<ArrayList<Long>> maps) {
        Long min = null;
        ArrayList<Long> locations = seeds;
        for(int i = 0; i < maps.size(); i++) {
            List<Long> nums = maps.get(i);
            ArrayList<Long> newLocations = new ArrayList<>();
        
            for(int k = 0; k < locations.size(); k += 2) {
                Long start = locations.get(k);
                Long r = locations.get(k + 1);
                Long finish = start + r;
                
                boolean terminado = false;
                while(!terminado) {     
                    for(int j = 0; j < nums.size(); j += 3) {
                        Long minNum = nums.get(j + 1);
                        Long range = nums.get(j + 2);
                        Long maxNum = minNum + range;
                        if(start >= minNum && start < maxNum) {
                            newLocations.add(nums.get(j) + (start - minNum));
                            if(finish <= maxNum) {
                                newLocations.add(r);
                                terminado = true;
                                break;
                            } else {
                                range = maxNum - start;
                                newLocations.add(range);
                                r = r - range;
                                start = maxNum;
                                j = -3;
                            }
                        }
                    }
                    if(!terminado) {
                        newLocations.add(start);
                        newLocations.add(r);
                        terminado = true;
                        break;
                    }    
                }
            }

            locations = newLocations;
        }
        for(int i = 0; i < locations.size(); i+=2) {
            if(min == null || locations.get(i) < min)
                min = locations.get(i);
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] seedStr = sc.nextLine().split(" ");
        ArrayList<Long> seeds = new ArrayList<Long>();
        for(int i = 1; i < seedStr.length; i++) {
            seeds.add(Long.parseLong(seedStr[i].trim()));
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
