package Split_Chk_Sum;

import java.util.*;

/**
 * input: 55
 * output: 
 * 7,8,10,13,17
 * 17,18,20
 * 27,28
 */
public class Main {
    

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine().trim());

        List<String> outputs = new ArrayList<>();
        for(int i = 1; i <= input; i++) {
            int sum = i;
            String line = i + ",";
            int increment = 1;
            for(int j = i + increment; j <= input; j+=increment) {
                increment ++;
                sum += j;
                if(sum < input) {
                    line += (j + ",");
                } else {
                    if(sum == input) {
                        line += j;
                        outputs.add(line);
                    }
                    break;
                }
            }
        }
        for(int i = 0; i < outputs.size(); i++) {
            if(i < outputs.size() -1) {
                System.out.println(outputs.get(i));
            } else {
                System.out.print(outputs.get(i));
            }
        }
    } 
}
