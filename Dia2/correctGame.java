import java.util.Scanner;

public class correctGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        boolean valido = true;

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] part = line.split(":");
            int id = Integer.parseInt(part[0].split(" ")[1].trim());
            String[] subsetList = part[1].split(";");
            for(String subset : subsetList) {
                String[] cubeList = subset.split(",");
                for(String cube : cubeList){
                    String[] cubeData = cube.trim().split(" ");
                    String color = cubeData[1].trim();
                    int num = Integer.parseInt(cubeData[0].trim());
                    switch (color) {
                        case "red":
                            valido = num <= 12;
                            break;
                        case "green":
                            valido = num <= 13;
                            break;
                        case "blue":
                            valido = num <= 14;
                            break;
                        default:
                            break;
                    }
                    if(!valido)
                        break;
                }
                if(!valido) {
                    break;
                }
            }
            if(valido)
                sum += id;

        }

        sc.close();
        System.out.println(sum);
    }
}
