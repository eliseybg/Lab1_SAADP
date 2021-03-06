package List;

public class ListTask2 {
    private Node startNode = new Node(null, null);
    private int size = 0;

    public ListTask2(int size, int delete) {
        for (int i = 0; i < size; i++) {
            add();
        }
        if (delete == 0) {
            System.err.println("delete equals 0");
            System.exit(0);
        }
        remove(delete);
    }

    @Override
    public String toString() {
        Node currentNode = startNode;
        int position = 0;
        while (position < size) {
            currentNode = currentNode.nextNode;
            position++;
        }
        return currentNode.value + "";
    }

    private void add() {
        Node currentNode = startNode;
        int position = 0;
        while (position < size) {
            currentNode = currentNode.nextNode;
            position++;
        }
        currentNode.nextNode = new Node(startNode.nextNode, position + 1);
        size++;
    }

    private void remove(int deleteNumber) {
        Node currentNode = startNode;
        int position = 0;
        if (size == 1)
            return;

        while (size > 1) {
            position++;
            if (position == deleteNumber) {
                currentNode.nextNode = currentNode.nextNode.nextNode;
                size--;
                position = 0;
            } else
                currentNode = currentNode.nextNode;
        }
        if (deleteNumber != 1)
            startNode.nextNode = currentNode;
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
