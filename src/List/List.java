package List;

public class List {
    private Node startNode = new Node(null, null, null);

    public List(String line) {
        line = line.substring(line.indexOf("=") + 1);
//        перед каждым минусом, кроме первого, добавить знак +,
//        чтоб через регуларное выражение поделить строку
        int searchMinusFrom = line.indexOf("=") + 2;
        while (line.indexOf("-", searchMinusFrom) != -1) {
            line = line.substring(0, line.indexOf("-", searchMinusFrom)) + "+"
                    + line.substring(line.indexOf("-", searchMinusFrom));
            searchMinusFrom = line.indexOf("-", searchMinusFrom) + 1;
        }

        String[] symbols = line.split("(x\\^)|(x)|[+]");

        for (int i = 0; i < symbols.length; i += 2) {
            try {
                int num1 = switch (symbols[i + 1]) {
                    case "" -> 1; // если у х нет степени
                    default -> Integer.parseInt(symbols[i + 1]);
                };
                int num2 = switch (symbols[i]) {
                    case "" -> 1; // если у х нет степени
                    case "-" -> -1; // если перед х будет стоять знак -
                    default -> Integer.parseInt(symbols[i]);
                };
                add(num1, num2);
//                вылетит исключение об выходе из массива, если будет стоять простое число,
//                потому что отсутствует х, а значит и в строке нет коэффициента при х
            } catch (ArrayIndexOutOfBoundsException e) {
                add(0, Integer.parseInt(symbols[i]));
            }
        }
    }

    public List() {

    }

    public static void Add(List firstList, List resultList, List secondList) {
        resultList.clear();
        Node nodeForFirstList = firstList.startNode;
        while (nodeForFirstList.nextNode != null) {
            nodeForFirstList = nodeForFirstList.nextNode;
            resultList.add(nodeForFirstList.degree, nodeForFirstList.ratio);
        }
        Node nodeForSecondList = secondList.startNode;
        resultList:
        while (nodeForSecondList.nextNode != null) {
            nodeForSecondList = nodeForSecondList.nextNode;
            Node nodeForResultList = resultList.startNode;
            while (nodeForResultList.nextNode != null) {
                nodeForResultList = nodeForResultList.nextNode;
                if (nodeForSecondList.degree.equals(nodeForResultList.degree)) {
                    if (nodeForSecondList.ratio + nodeForResultList.ratio != 0)
                        nodeForResultList.ratio = nodeForSecondList.ratio + nodeForResultList.ratio;
                    continue resultList;
                }
            }
            resultList.add(nodeForSecondList.degree, nodeForSecondList.ratio);
        }
    }

    public static int Meaning(List list, int x) {
        Node currentNode = list.startNode;
        int result = 0;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            result += Math.pow(x, currentNode.degree) * currentNode.ratio;
        }
        return result;
    }

    public static boolean Equality(List firstList, List secondList) {
        Node nodeForFirstList = firstList.startNode;
        firstListCompare:
        while (nodeForFirstList.nextNode != null) {
            nodeForFirstList = nodeForFirstList.nextNode;
            Node nodeForSecondList = secondList.startNode;
            while (nodeForSecondList.nextNode != null) {
                nodeForSecondList = nodeForSecondList.nextNode;
                if (nodeForFirstList.degree.equals(nodeForSecondList.degree) &&
                        nodeForFirstList.ratio.equals(nodeForSecondList.ratio)) {
                    continue firstListCompare;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "{";
        Node currentNode = startNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            result += "(" + currentNode.degree + ", " + currentNode.ratio + "), ";
        }
        result = result.substring(0, result.length() - 2) + "}";
        return result;
    }

    private void add(Integer degree, Integer ratio) {
        Node currentNode = startNode;
        while (currentNode.nextNode != null)
            currentNode = currentNode.nextNode;
        currentNode.nextNode = new Node(degree, ratio, null);
    }

    private void clear() {
        startNode = new Node(null, null, null);
    }

    private class Node {
        Node nextNode;
        Integer degree;
        Integer ratio;

        Node(Integer degree, Integer ratio, Node nextNode) {
            this.nextNode = nextNode;
            this.degree = degree;
            this.ratio = ratio;
        }
    }
}
