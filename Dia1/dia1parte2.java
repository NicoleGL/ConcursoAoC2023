import java.util.Scanner;

public class dia1parte2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        Integer first = null;
        int firstPos = -1;
        Integer last = null;
        int lastPos = -1;

        String[] nums = new String[]{"one","two","three","four","five","six","seven","eight","nine"};

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            
            for(int i = 0; i < line.length(); i++) {
                char a = line.charAt(i);
                if(a >= 48 && a < 58) {
                    if(first == null) {
                        first = a - 48;
                        firstPos = i;
                    }
                    last = a - 48;
                    lastPos = i;
                }
            }
            for(int j = 0; j < nums.length; j++) {
                int index = line.indexOf(nums[j]);
                if(index != -1 && (index < firstPos || firstPos == -1)) {
                    firstPos = index;
                    first = j + 1;
                }
                index = line.lastIndexOf(nums[j]);
                if(index > lastPos) {
                    lastPos = index;
                    last = j + 1;
                }
                
            }
            

            if(first != null){
                int num = first * 10 + last;
                sum += num;
            }

            firstPos = -1;
            lastPos = -1;
            first = null;

        }

        System.out.println(sum);
        sc.close();
    }
}