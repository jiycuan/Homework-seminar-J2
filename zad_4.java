// 4. Добавить логгирование в калькулятор из задания 3 семинара 1. 

import java.io.FileWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class zad_4 {

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.println("Выберите тип операции. 1 - сложение. 2 - вычитание. 3 - умножение. 4 - деление. ");
        double oper = in.nextInt();

        System.out.print("Введите первое число: ");
        double num_1 = in.nextInt();

        System.out.print("Введите второе число: ");
        double num_2 = in.nextInt();
        in.close();

        double result = 0;

        if (oper == 1) {
            result = num_1 + num_2;
            printed(result);
        }
        if (oper == 2) {
            result = num_1 - num_2;
            printed(result);
        }
        if (oper == 3) {
            result = num_1 * num_2;
            printed(result);
        }
        if (oper == 4) {
            result = num_1 / num_2;
            printed(result);
        }
    
            String time = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
            time = time + ", Тип операции: " + Double.toString(oper) + ", Результат: " + Double.toString(result) + "\n";
            FileWriter log = new FileWriter("log4.txt", true);
            log.write(time);
            log.flush();
            log.close();
    
    }

    public static void printed(double result) {

        System.out.print("Результат равен: ");
        System.out.println(result);
        
    }

}
