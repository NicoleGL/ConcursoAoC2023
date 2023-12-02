import java.util.Scanner;

public class dia1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        char first = '\0';
        char last = '\0';

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            first = '\0';
            for(int i = 0; i < line.length(); i++) {
                char a = line.charAt(i);
                if(a >= 48 && a < 58) {
                    if(first == '\0') {
                        first = a;
                    }
                    last = a;
                }
            }
            if(first != '\0'){
                String numStr = "" + first + last;
                int num = Integer.parseInt(numStr);
                sum += num;
            }
        }
        
        System.out.println(sum);

        sc.close();
    }
}