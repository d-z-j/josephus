//创建一个环形的单向链表
public class CircleLinkedList{
    //创建一个first节点
    private Node first=null;
    //添加结点，构成一个环形单链表
    public void add(int nums){
        if(nums<1){                             //判断参数值nums是否合法
            System.out.println("输入值不正确");
            return ;
        }
        Node cur =null;  //辅助指针
        //用for循环创建环形链表
        for (int i = 1; i <=nums ; i++) {
            Node node = new Node(i);
            if(i==1){  //如果为第一个结点
                first=node;
                first.setNext(first);  //一个节点本身构成一个环
                cur = first;  //辅助指针指向第一个结点
            }else{
                cur.setNext(node);
                node.setNext(first);  //形成环状
                cur=node; //指针后移
            }
        }
    }
    //遍历环形链表
    public void Show(){
        //先判断链表是否为空
        if(first==null){
            System.out.println("请放入结点");
            return ;
        }
        //first不能动，需要一个辅助变量
        Node cur=first;
        while(true){
            System.out.printf("结点的编号 %d \n",cur.getData());
            if(cur.getNext()==first){ //遍历完成
                break;
            }
            cur=cur.getNext();
        }
    }
//根据输入，计算结点出圈顺序
    /**
     * @param startdata  从第几个结点开始数
     * @param countNum   数几下
     * @param nums   最初结点个数
     */
    public void Count(int startdata,int countNum,int nums){
        if(first==null||startdata<1||startdata>nums){
            System.out.println("参数错误");
            return;
        }
        //创建辅助变量帮助结点出圈，事先指向环形链表的最后一个节点
        Node cur =first;
        while(true){
            if(cur.getNext()==first){  //将cur指向环形链表的最后一个节点
                break;
            }
            cur =cur.getNext();
        }
        //结点报数前，先让first和cur指针同时移动startdata-1次,移动到startdata的位置
        for (int i = 0; i <startdata-1 ; i++) {
            first=first.getNext();
            cur=cur.getNext();
        }
        //结点报数时，先让first和cur指针同时移动countNum-1次，然后出圈
        while(true){
            if(cur==first){   //圈中只有一个结点
                break;
            }
            //让first和cur指针同时移动countNum-1次
            for (int i = 0; i <countNum-1 ; i++) {
                first=first.getNext();
                cur=cur.getNext();
            }
            //first指向的结点，就是要出圈的结点
            System.out.printf("结点%d出圈\n",first.getData());
            first=first.getNext();
            cur.setNext(first);
        }
        System.out.printf("最后留在圈中的结点%d \n" ,first.getData());
    }
}
