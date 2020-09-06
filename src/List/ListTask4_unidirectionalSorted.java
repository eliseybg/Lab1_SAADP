package List;

public class ListTask4_unidirectionalSorted {
    private Node startNode = new Node(null, null);
    private int size = 0;

    @Override
    public String toString() {
        String result = "{";
        Node currentNode = startNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            result += "(" + currentNode.value + "), ";
        }
        if (size != 0)
            result = result.substring(0, result.length() - 2);
        result += "}";
        return result;
    }

    public void add(Integer number) {
        if (number < 999)
            return;

        Node currentNode = startNode;
        size++;
        try {
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
                if (currentNode.nextNode.value > number)
                    break;
            }
        } catch (NullPointerException e) {
            currentNode.nextNode = new Node(null, number);
            return;
        }
        currentNode.nextNode = new Node(currentNode.nextNode, number);
    }

    private class Node {
        Node nextNode;
        Integer value;

        Node(Node nextNode, Integer value) {
            this.nextNode = nextNode;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + value + ')';
        }
    }
}
