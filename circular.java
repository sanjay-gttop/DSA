public class circular {

    static class CircularQueue {
        private int[] arr;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        CircularQueue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(int value) {
            if (isFull()) {
                System.out.println("Queue is Full (Overflow)");
                return;
            }

            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
            System.out.println(value + " inserted");
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is Empty (Underflow)");
                return -1;
            }

            int removed = arr[front];
            front = (front + 1) % capacity;
            size--;
            return removed;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return;
            }

            System.out.print("Queue elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        q.display();

        q.enqueue(60);
        q.enqueue(70);

        q.display();
    }
}