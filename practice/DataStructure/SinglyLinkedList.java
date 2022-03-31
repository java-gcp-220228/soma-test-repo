public class SinglyLinkedList {
    private static ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }}
        public void display() {
            ListNode current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;

            }
            System.out.println("null");

        }
        public void flength () {
        int count=0;
        ListNode current=head;
        while (current!=null){
            current=current.next;
            count=count+1;
        }
            System.out.println(count);}
        public void insertlast() {
            ListNode lnode = new ListNode(15);
            if (head == null) {
                head = lnode;
            } else {
                ListNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current = lnode;
            }
        }
    public void Insertbegin(){
        ListNode newnode= new ListNode(11);
        newnode.next=head;
        head=newnode;
    }
        public static void main(String[] args) {
      head=new ListNode(10);
      ListNode second= new ListNode(8);
      ListNode third =new ListNode(12);
      head.next=second;
      second.next=third;
       SinglyLinkedList sll=new SinglyLinkedList();
            ListNode newnode= new ListNode(11);
            newnode.next=head;
            head=newnode;



       sll.display();
       sll.Insertbegin();

       sll.flength();

    }
}
