package List;

public class ListTask4_bidirectional {
    private Node fstNode;
    private Node lstNode;
    private int size = 0;

    public ListTask4_bidirectional() {
        lstNode = new Node(null, fstNode, null);
        fstNode = new Node(null, null, lstNode);
    }

    @Override
    public String toString() {
        String line = "{";
        Node current = fstNode.nextElement;
        for (int i = 0; i < size - 1; i++) {
            line += current.number + ", ";
            current = current.nextElement;
        }
        if (size != 0)
            line += current.number;
        line += "}";
        return line;
    }

    @Override
    public boolean equals(Object object) {
        return this.toString().equals(object.toString());
    }

    public boolean add(Integer number) {
        Node prev = lstNode;
        prev.number = number;
        lstNode = new Node(null, prev, null);
        prev.nextElement = lstNode;
        size++;
        return false;
    }

    public void showFromRightToLeft() {
        Node target = lstNode.prevElement;
        for (int i = 0; i < size; i++) {
            System.out.print(target.number + " ");
            target = target.prevElement;
        }
        System.out.println();
    }

    public ListTask4_unidirectionalSorted getUnidirectionalList() {
        ListTask4_unidirectionalSorted list = new ListTask4_unidirectionalSorted();
        Node target = fstNode.nextElement;
        while (target.nextElement != null) {
            list.add(target.number);
            target = target.nextElement;

        }
        return list;
    }

    private class Node {
        public Integer number;
        public Node nextElement;
        public Node prevElement;

        Node(Integer number, Node prevElement, Node nextElement) {
            this.number = number;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }

}
