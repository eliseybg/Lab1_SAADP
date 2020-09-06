package List;

public class ListTask3 {
    private Node startNode = new Node(null, null, null);
    int size = 0;

    @Override
    public String toString() {
        String result = "{";
        Node currentNode = startNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            result += "(" + currentNode.number + ", " + currentNode.name + "), ";
        }
        result = result.substring(0, result.length() - 2) + "}";
        return result;
    }

    public String getName(int number) {
        Node currentNode = startNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            if (currentNode.number == number)
                return currentNode.name;
        }
        return null;
    }

    public Integer getNumber(String name) {
        Node currentNode = startNode;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            if (currentNode.name == name)
                return currentNode.number;
        }
        return null;
    }

    public void add(Integer number, String name) {
        Node currentNode = startNode;
        size++;
        try {
            loop:
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
                int minSize = Math.min(name.length(), currentNode.nextNode.name.length());
                for (int i = 0; i < minSize; i++) {
                    if (currentNode.nextNode.name.charAt(i) > name.charAt(i)) {
                        break loop;
                    }
                }
            }
        } catch (NullPointerException e) {
            currentNode.nextNode = new Node(number, name, null);
            return;
        }
        currentNode.nextNode = new Node(number, name, currentNode.nextNode);
    }

    private class Node {
        Node nextNode;
        Integer number;
        String name;

        Node(Integer number, String name, Node nextNode) {
            this.nextNode = nextNode;
            this.number = number;
            this.name = name;
        }
    }
}
