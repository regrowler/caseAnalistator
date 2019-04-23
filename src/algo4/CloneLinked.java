package algo4;
public class CloneLinked {
    Node2 startNode;
    public CloneLinked() {
        Node2 node1 = new Node2(1);
        Node2 node2 = new Node2(2);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(4);
        Node2 node5 = new Node2(5);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node1.setRandom(node3);
        node2.setRandom(node1);
        node4.setRandom(node1);
        node5.setRandom(node4);
        this.startNode = node1;
        printNodes(startNode);
        Node2 clonedStart1 = cloneLinkedList(startNode);
       System.out.println("Копия ");
        printNodes(clonedStart1);
    }
    public String printout(){
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(printNodes(startNode));
        printNodes(startNode);
        Node2 clonedStart1 = cloneLinkedList(startNode);
        System.out.println("Копия ");
        printNodes(clonedStart1);
        stringBuilder.append("<br>");
        stringBuilder.append("Копия ");

        stringBuilder.append(printNodes(clonedStart1));
        return stringBuilder.toString();
    }
    private String printNodes(Node2 startNode) {
        StringBuilder stringBuilder=new StringBuilder();
        System.out.println();
        stringBuilder.append("<br>");
        if (startNode == null)
            return stringBuilder.toString();

        Node2 temp = startNode;
        while (temp != null) {
            System.out.println(temp.getData() + " " + ((temp.getRandom() == null) ? "null" : temp.getRandom().getData()));
            stringBuilder.append(temp.getData() + " " + ((temp.getRandom() == null) ? "null" : temp.getRandom().getData()));
            stringBuilder.append("<br>");
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }
    private Node2 cloneLinkedList(Node2 startNode) {
        if (startNode == null)
            return null;
       Node2 originalNode = startNode;
        while(originalNode != null){
            Node2 next = originalNode.getNext();

            Node2 copy = new Node2(originalNode.getData());

            originalNode.setNext(copy);

            copy.setNext(next);

            originalNode = originalNode.getNext().getNext();
        }
        boolean isFirst = true;
        Node2 originalNode1 = startNode;
        Node2 cloneStart = null;
        Node2 cloneStartTemp = null;
        while(originalNode1 != null && originalNode1.getNext()!=null){
            if(isFirst){
                cloneStart = originalNode1.getNext();
                cloneStartTemp = originalNode1.getNext();
                isFirst = false;
            }
            Node2 clonedNode = originalNode1.getNext();
            if(originalNode1.getRandom() == null){
                clonedNode.setRandom(null);
            }else{

                clonedNode.setRandom(originalNode1.getRandom().getNext());
            }
            originalNode1.setNext(clonedNode.getNext());
            cloneStartTemp.setNext(originalNode1.getNext());
            originalNode1 = originalNode1.getNext();
            cloneStartTemp = cloneStartTemp.getNext();
        }
        return cloneStart;
    }
}
class Node2{
    private int data;
    private Node2 next;
    private Node2 random;
    public Node2(int data) {
        this.data = data;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node2 getNext() {
        return next;
    }
    public void setNext(Node2 next) {
        this.next = next;
    }
    public Node2 getRandom() {
        return random;
    }
    public void setRandom(Node2 random) {
        this.random = random;
    }
}

