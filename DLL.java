
public class DLL {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;


    public void insertEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;      
        }
        temp.next = newNode;        
        newNode.prev = temp;
    }

    public void insertStart(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public int delete(int key) {
        if (head == null) {
            System.out.println("The list is empty");
            return -1;
        }

        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Key not found in the list");
            return -1;
        }

        if (temp == head) {
            head = head.next;
            if (head != null) {         
                head.prev = null;
            }
            return temp.data;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }

        return temp.data;          
    }

    // Display forward
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Test
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(30);
        list.insertStart(5);
        list.display();      

        list.delete(10);
        list.display();          

        list.delete(5);           
        list.display();        
    }
}