import java.util.Scanner;

public class part1 {

    private static boolean isNumber(char a) {
        return a >= 48 && a < 58;
    }

    private static boolean isSpecialChar(char a) {
        return !(a >= 48 && a < 58) && a != 46;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String anterior = null;
        String actual = (sc.hasNextLine())? sc.nextLine() : null;
        String siguiente = (sc.hasNextLine())? sc.nextLine() : null;
        String num = "";
        boolean contar = false;

        while(actual != null) {
            for(int i = 0; i < actual.length(); i++) {
                char a = actual.charAt(i);
                if(isNumber(a)) {
                    int firstPos = i;
                    while(i < actual.length()) {
                        a = actual.charAt(i);
                        if(isNumber(a)) {
                            num = num + a;
                            i++;
                        } else
                            break;
                    }
                    int lastPos = i;

                    for(int j = firstPos - 1; j < actual.length() && j < lastPos + 1 && !contar; j++){
                        if(j >= 0) {
                            contar = isSpecialChar(actual.charAt(j));
                            if(anterior != null && !contar)
                                contar = isSpecialChar(anterior.charAt(j));
                            if(siguiente != null && !contar)
                                contar = isSpecialChar(siguiente.charAt(j));
                        }
                    }

                    if(contar) {
                        sum += Integer.parseInt(num);
                    }
                    num = "";
                    contar = false;
                }
            }
            anterior = actual;
            actual = siguiente;
            siguiente = (sc.hasNextLine())? sc.nextLine() : null;
        }
        System.out.println(sum);
        sc.close();
    }
}
