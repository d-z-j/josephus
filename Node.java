//创建一个Node类，表示一个节点
class  Node{
    private int data;  //编号
    private Node next;  //指向下一个节点，默认null
    public Node(int data) {
        this.data = data;
    }
    public int getData() {//返回结点的data值
        return data;
    }
    public void setNo(int data) {//修改结点的data值
        this.data = data;
    }
    public Node getNext() {//返回结点的后继next
        return next;
    }
    public void setNext(Node next) {//修改结点的后继
        this.next = next;
    }
}
