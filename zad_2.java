// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class zad_2 {
    
    public static void main(String[] args) throws IOException {

        int[] nums = {15, 12, 2, 4, 788, 73, 8, 21};
        String nums_str = Arrays.toString(nums);
        boolean sorted = false;
        int temp;
        FileWriter log = new FileWriter("log2.txt", true);

        while(!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] > nums[i+1]){
                    sorted = false;
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    nums_str = Arrays.toString(nums) + "\n";
                    log.write(nums_str);
                    log.flush();
                }
            }      
        }
        log.close();
    }
}