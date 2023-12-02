import java.util.Scanner;

public class part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            int maxRed = 0;
            int maxGreen = 0;
            int maxBlue = 0;
            String[] subsetList = line.split(":")[1].split(";");

            for(String subset : subsetList) {
                String[] cubeList = subset.split(",");
                for(String cube : cubeList){
                    String[] cubeData = cube.trim().split(" ");
                    String color = cubeData[1].trim();
                    int num = Integer.parseInt(cubeData[0].trim());
                    switch (color) {
                        case "red":
                            if(num > maxRed) maxRed = num;
                            break;
                        case "green":
                            if(num > maxGreen) maxGreen = num;
                            break;
                        case "blue":
                            if(num > maxBlue) maxBlue = num;
                            break;
                        default:
                            break;
                    }
                }
            }
            sum += (maxBlue * maxGreen * maxRed);

        }

        sc.close();
        System.out.println(sum);
    }
}
