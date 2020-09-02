import List.List;

public class Main {
    private static String example1 = "-5x^6+3x^2-2x+7";
    private static String example2 = "x^3-x^2+7";
    private static String example3 = "-2x^3-3x^2+x";
    private static String example4 = "-x+7";
    private static String example5 = "5";

    public static void main(String[] args) {
        List list1 = new List(example1);
        System.out.println("list1    " + list1);

        List list2 = new List(example2);
        System.out.println("list2    " + list2);

        System.out.println("list1 in point 1    " + List.Meaning(list1, 1));
        System.out.println("list2 in point 0    " + List.Meaning(list2, 0));

        System.out.println("list1 == list1    " + List.Equality(list1, list1));
        System.out.println("list1 == list2    " + List.Equality(list1, list2));

        List sum = new List();
        List.Add(list1, sum, list2);

        System.out.println("sum    " + sum);
    }

}
