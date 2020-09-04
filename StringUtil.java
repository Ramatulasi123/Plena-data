
import java.util.*;

public class StringUtil {
    public static void main(String[] args) {
        System.out.println("============Test started ============");
        System.out.println("please enter your input string :");
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        System.out.println("User input : " + input);
        System.out.println("First unique char: " + findFirstCharacter(input));
        System.out.println("final output  String: " + printString(input));

    }

    public static Character findFirstCharacter(String str) {
        Map<Character, Integer> countMap = new HashMap();

        for (int i = 0; i < str.length(); i++) {
            countMap.put(Character.toUpperCase(str.charAt(i)), countMap.getOrDefault(Character.toUpperCase(str.charAt(i)), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (countMap.get(Character.toUpperCase(str.charAt(i))) == 1) return str.charAt(i);
        }
        return null;
    }

    public static String printString(String str) {
        Map<Character, Integer> countMap = new HashMap();
        Map<Integer, List<Character>> printOrder = new TreeMap<>();

        for (int i = 0; i < str.length(); i++) {
            countMap.put(Character.toUpperCase(str.charAt(i)), countMap.getOrDefault(Character.toUpperCase(str.charAt(i)), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            List<Character> list;
            if (printOrder.containsKey(countMap.get(Character.toUpperCase(str.charAt(i))))) {
                list = printOrder.get(countMap.get(Character.toUpperCase(str.charAt(i))));

            } else {
                list = new LinkedList<Character>();
                printOrder.put(countMap.get(Character.toUpperCase(str.charAt(i))), list);
            }

            list.add(str.charAt(i));


        }
        for (int val : printOrder.keySet()) {
            List<Character> list = printOrder.get(val);
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
