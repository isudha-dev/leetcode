package leetcode;

class MyLinkedList {

    Node head;
    Node tail;
    int size;

    class Node {
        int val;
        Node next;
        Node prev;
        public Node() {

        }
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if(index < size - 1) {
            Node temp = head;
            while(index > 0) {
                temp = temp.next;
                index--;
            }
            return temp.val;
        } else if (index == size - 1) {
            return tail.val;
        } else {
            return -1;
        }
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        if(tail == null)
            tail = head;
        size++;
    }

    public void addAtTail(int val) {
        if(size == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        if(index == size && tail != null) {
            addAtTail(val);
            return;
        }
        if (index < size) {
            Node temp = head;
            while(index > 1) {
                temp = temp.next;
                index--;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(head == null) {
            return;
        }
        if(index == 0 && head != null) {
            head = head.next;
            if(head == null) {
                tail = head;
            }
            size--;
            return;
        }
        if(index < size) {
            Node temp = head;
            while(index > 1) {
                temp = temp.next;
                index--;
            }
            if(temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
            size--;
        }
    }

    public static void main(String[] args) {
        /*
        ["MyLinkedList","addAtHead","get","addAtIndex","addAtIndex","deleteAtIndex","addAtHead","addAtHead",
        "deleteAtIndex","addAtIndex","addAtHead","deleteAtIndex"]
        [[],[9],[1],[1,1],[1,7],[1],[7],[4],[1],[1,4],[2],[5]]
         */
        MyLinkedList ll  = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtIndex(1, 2);
        ll.deleteAtIndex(1);
    }
}
