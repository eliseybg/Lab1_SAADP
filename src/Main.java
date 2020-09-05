import List.*;

import java.util.Scanner;

public class Main {
    private static String example1 = "-5x^6+3x^2-2x+7";
    private static String example2 = "x^3-x^2+7";
    private static String example3 = "-2x^3-3x^2+x";
    private static String example4 = "-x+7";
    private static String example5 = "5";

    public static void main(String[] args) {
        System.out.println("task 1:");
        List list1 = new List(example1);
        System.out.println("list1    " + list1);

        List list2 = new List(example2);
        System.out.println("list2    " + list2);

        System.out.println("list1 in point 1    " + List.Meaning(list1, 1));
        System.out.println("list2 in point 0    " + List.Meaning(list2, 0));

        System.out.println("list1 == list1    " + List.Equality(list1, list1));
        System.out.println("list1 == list2    " + List.Equality(list1, list2));

        List sum = new List();
        List.Add(sum, list1, list2);

        System.out.println("sum    " + sum);

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("task 2:");
        System.out.println("enter k to delete:");
        int k = scanner.nextInt();
        System.out.println("+-----+------+");
        System.out.println("|  n  | last |");
        System.out.println("+-----+------+");
        for (int i = 0; i < 64; i++) {
            System.out.printf("| %3d | %4S |\n", i + 1, new RoundList(i + 1, k).toString());
            System.out.println("+-----+------+");
        }

        System.out.println();
        System.out.println("task 3:");
        ListTask3 list = new ListTask3();
        list.add(1323, "ab");
        list.add(1223, "af");
        list.add(1233, "ac");
        list.add(123, "ad");
        System.out.println("whole list   " + list);
        System.out.println("name for number 123     " + list.getName(123));
        System.out.println("number for name af     " + list.getNumber("af"));


    }

}
