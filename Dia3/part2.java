package Dia3;

import java.util.Scanner;

public class part2 {

    private static boolean isNumber(char a) {
        return a >= 48 && a < 58;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        String anterior = null;
        String actual = (sc.hasNextLine())? sc.nextLine() : null;
        String siguiente = (sc.hasNextLine())? sc.nextLine() : null;
        String num1 = "";
        String num2 = "";
        int numOfNums = 0;

        while(actual != null) {
            for(int i = 0; i < actual.length(); i++) {
                char a = actual.charAt(i);
                if(a == 42) {
                    
                    int j = i - 1;
                    boolean guardar = false;
                    boolean hayNum = false;
                    numOfNums = 0;
                    num1 = "";
                    num2 = "";
                    if(anterior != null) {
                        while(j < anterior.length() && (j <= i + 1 || hayNum)) {
                            if(j >= 0) {
                                char b = anterior.charAt(j);
                                if(isNumber(b)) {
                                    if(!guardar) {
                                        hayNum = true;
                                        j--;
                                    } else {
                                        if(numOfNums == 0){
                                            num1 += b;
                                        } else {
                                            num2 += b;
                                        }
                                        j++;
                                    }
                                } else {
                                    if(!guardar) {
                                        if(hayNum) {
                                            guardar = true;
                                        }
                                        j++;
                                    } else {
                                        numOfNums++;
                                        guardar = false;
                                        hayNum = false;
                                        j++;
                                    }
                                }
                            } else {
                                guardar = true;
                                j++;
                            }
                        }
                        if(hayNum) {
                            numOfNums++;
                            guardar = false;
                            hayNum = false;
                        }

                    }

                    j = i - 1;

                    if(numOfNums < 3) {
                        while(j < actual.length() && (j <= i + 1 || hayNum)) {
                            if(j >= 0) {
                                char b = actual.charAt(j);
                                if(isNumber(b)) {
                                    if(!guardar) {
                                        hayNum = true;
                                        j--;
                                    } else {
                                        if(numOfNums == 0){
                                            num1 += b;
                                        } else {
                                            num2 += b;
                                        }
                                        j++;
                                    }
                                } else {
                                    if(!guardar) {
                                        if(hayNum) {
                                            guardar = true;
                                        }
                                        j++;
                                    } else {
                                        numOfNums++;
                                        guardar = false;
                                        hayNum = false;
                                        j++;
                                    }
                                }
                            }  else {
                                guardar = true;
                                j++;
                            }
                        }
                        if(hayNum) {
                            numOfNums++;
                            guardar = false;
                            hayNum = false;
                        }
                    }

                    j = i - 1;

                    if(numOfNums < 3 && siguiente != null) {
                        while(j < siguiente.length() && (j <= i + 1 || hayNum)) {
                            if(j >= 0) {
                                char b = siguiente.charAt(j);
                                if(isNumber(b)) {
                                    if(!guardar) {
                                        hayNum = true;
                                        j--;
                                    } else {
                                        if(numOfNums == 0){
                                            num1 += b;
                                        } else {
                                            num2 += b;
                                        }
                                        j++;
                                    }
                                } else {
                                    if(!guardar) {
                                        if(hayNum) {
                                            guardar = true;
                                        }
                                        j++;
                                    } else {
                                        numOfNums++;
                                        guardar = false;
                                        hayNum = false;
                                        j++;
                                    }
                                }
                            }  else {
                                guardar = true;
                                j++;
                            }
                        }
                        if(hayNum) {
                            numOfNums++;
                            guardar = false;
                            hayNum = false;
                        }
                    }

                    if(numOfNums == 2) {
                        sum += Integer.parseInt(num1) * Integer.parseInt(num2);
                    }
                        
                    
                }
            }
            anterior = actual;
            actual = siguiente;
            siguiente = (sc.hasNextLine())? sc.nextLine() : null;
        }

        sc.close();
        System.out.println(sum);
    }
    
}
