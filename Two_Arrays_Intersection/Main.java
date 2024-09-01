package Two_Arrays_Intersection;

import java.util.*;

public class Main {
    
    private static Integer[] Two_Arrays_Intersection(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return null;
        }
        
        int[] fewer_num = nums1.length < nums2.length ? nums1 : nums2;
        int[] more_num = nums1.length <  nums2.length ? nums2 : nums1;
        Set<Integer> set = new HashSet<>();
        for(int num: fewer_num) {
            set.add(num);
        }

        Set<Integer> ans = new HashSet<>();
        for(int num: more_num) {
            if(set.contains(num)) {
                ans.add(num);
            }
        }

        Integer[] last = ans.toArray(new Integer[0]);
        Arrays.sort(last, (a, b) -> { return a - b; });
        return last;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().trim().split(";");

        String[] line1 = inputs[0].split(",");
        String[] line2 = inputs[1].split(",");

        int[] nums1 = new int[line1.length];
        int[] nums2 = new int[line2.length];

        for(int i = 0; i < line1.length; i++) {
            nums1[i] = Integer.parseInt(line1[i]);
        }

        for(int i = 0; i < line2.length; i++) {
            nums2[i] = Integer.parseInt(line2[i]);
        }

        Integer[] list = Two_Arrays_Intersection(nums1, nums2);

        for(int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if(i < list.length -1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

}
