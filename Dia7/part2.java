package Dia7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class part2 {
    public enum types {FIVE, FOUR, FULLHOUSE, THREE, TWOPAIR, ONEPAIR, HIGHCARD};

    private static types getType(String hand){
        Map<String, Integer> map = new HashMap<String, Integer>();
        int max = 0;
        int numOfJs = 0;
        for(int i = 0; i < hand.length(); i++) {
            String a = hand.substring(i, i+1);
            if(a.equals("J"))
                numOfJs++;
            else {
                Integer times = map.get(a);
                if(times == null)
                    times = 0;
                map.put(a, times + 1);
                if(times + 1 > max)
                    max = times + 1;
            }
            
            
        }
        max += numOfJs;
        switch(max) {
            case 5:
                return types.FIVE;
            case 4:
                return types.FOUR;
            case 3:
                return (map.size() == 3)? types.THREE : types.FULLHOUSE;
            case 2:
                return (map.size() == 3)? types.TWOPAIR : types.ONEPAIR;
            default:
                return types.HIGHCARD;
        }
    }

    private static boolean stronger(String hand1, String hand2) {
        Map<String, Integer> values = Map.of("A", 14, "K", 13, "Q", 12, "J", 1, "T", 10);
        for(int i = 0; 0 < hand1.length(); i++) {
            String c1 = hand1.substring(i, i+1);
            String c2 = hand2.substring(i, i+1);
            Integer v1 = values.get(c1);
            Integer v2 = values.get(c2);
            if(v1 == null) {
                v1 = Integer.parseInt(c1);
            } if(v2 == null)
                v2 = Integer.parseInt(c2);
            if(v1 != v2)
                return v1 > v2;
        }
        return false;
    }

    private static void addInOrder(List<String> list, String el) {
        for(int i = 0; i < list.size(); i++) {
            String elList = list.get(i);
            int comp = getType(elList).compareTo(getType(el));
            if(comp > 0 ||(comp == 0 && stronger(el, elList))) {
                list.add(i, el);
                return;
            }
        }
        list.add(el);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> bets = new HashMap<>();
        List<String> order = new ArrayList<>();
        while(sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" + *");
            String hand = line[0];
            int bet = Integer.parseInt(line[1]);
            bets.put(hand, bet);
            addInOrder(order, hand);
        }
        int tam = order.size();
        int sum = 0;
        for(int i = 0; i < tam; i++) {
            System.out.println("Card: " + order.get(i));
            sum += bets.get(order.get(i)) * (tam-i);
        }
        System.out.println(sum);
        sc.close();
    } 
}
