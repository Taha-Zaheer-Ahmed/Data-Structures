package DataStructures;

import java.util.ArrayList;

public class LinkedList<T> {

    Node head;
    Node tail;
    int size;

    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    LinkedList(LinkedList<T> list) {
        this.head = list.head;
        this.tail = list.tail;
        this.size = list.size;
    }

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        public String toString() {
            return "" + this.data;
        }
    }

    public void add(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size += 1;
    }

    public void addfirst(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size += 1;
    }

    public void addAt(T data, int index) {
        if (head == null) {
            add(data);
        } else {
            Node node = new Node(data);
            Node cur = head;
            int pointer = 0;
            Node prev = null;
            try {
                while (pointer != index) {

                    prev = cur;
                    pointer += 1;
                    cur = cur.next;

                }
                this.size += 1;
                prev.next = node;
                node.next = cur;
            } catch (NullPointerException e) {
                System.out.println(e);

            }
        }
    }

    public void addfromlast(T data, int indexfromlast) {
        if (head == null) {
            add(data);
        } else {
            indexfromlast = this.size - indexfromlast;
            addAt(data, indexfromlast);
        }

    }

    @Override
    public String toString() {
        Node i = head;
        String Out = "";
        while (true) {
            if (i == tail) {
                Out += i.data + "";
                break;
            } else {
                Out += i.data + "-->";
                i = i.next;
            }
        }
        return Out;
    }

    public void removefirst() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            this.head = this.head.next;
            size -= 1;
        }
    }

    public void pop() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node j = head;
            int ref = 1;
            while (ref <= size - 2) {
                j = j.next;
                ref += 1;
            }
            this.tail = j;
            this.tail.next = null;
            size -= 1;

        }
    }

    public void removeAt(int index) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            try {
                Node cur = head;
                Node prev = null;
                int pointer = 0;

                while (pointer != index) {

                    prev = cur;
                    pointer += 1;
                    cur = cur.next;

                }
                this.size -= 1;
                prev.next = cur.next;
                cur = null;
            } catch (NullPointerException e) {

                System.out.println("Index out of range");

            }

        }

    }

    public void removefromlast(int indexfromlast) {

        indexfromlast = this.size - indexfromlast - 1;
        removeAt(indexfromlast);

    }

    public void reverse() {

        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node prev = null;
            Node cur = head;
            Node next = null;

            while (cur != null) {

                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;

            }

            this.tail = this.head;
            this.head = prev;
        }

    }

    public T get(int index) {
        Node cur = head;
        int pointer = 0;
        try {
            while (pointer != index) {

                cur = cur.next;
                pointer += 1;

            }
            return cur.data;
        } catch (Exception e) {
            System.out.println("Index out of range");
            return null;
        }

    }

    public void set(T data, int index) {
        Node cur = head;
        int pointer = 0;
        try {
            while (pointer != index) {

                cur = cur.next;
                pointer += 1;

            }

            cur.data = data;
        } catch (NullPointerException e) {
            System.out.println(e);

        }
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arraylist = new ArrayList<T>();
        Node node = this.head;
        arraylist.add(node.data);
        while (node != this.tail) {
            node = node.next;
            arraylist.add(node.data);
        }
        return arraylist;

    }

    public void isPalindrome() {
        ArrayList<T> original = toArrayList();
        reverse();
        ArrayList<T> reversed = toArrayList();
        if (original.equals(reversed)) {
            System.out.println("The list is a Palindrome");
        } else {
            System.out.println("The List is not a Palindrome");
        }
    }

    public T getter(int value) {
        Node current = head;
        int c = 0;
        while (c != value) {
            current = current.next;
            c++;
        }
        return current.data;
    }

    public boolean isPalindrome(Node head) {

        Node cur = head;
        Boolean result = true;
        int i = 0;
        int j;
        int size = 1;

        while (cur.next != null) {
            cur = cur.next;
            size += 1;
        }

        cur = head;

        while (i < size) {
            j = size - i - 1;
            if (getter(i) == getter(j)) {
                result = result && true;
            } else {
                result = result && false;
            }
            i += 1;
        }

        return result;

    }

    public boolean hasCycle() {
        Node hare = this.head;
        Node turtle = this.head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (hare == turtle) {
                return true;
            }
        }
        return false;
    }

    public Node detectCycle() {
        Node hare = this.head;
        Node turtle = this.head;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (hare == turtle) {
                turtle = head;
                while (hare != turtle) {
                    turtle = turtle.next;
                    hare = hare.next;
                }
                return hare;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> List1 = new LinkedList<Integer>();
        LinkedList<String> names = new LinkedList<String>();
        List1.add(10);
        List1.add(50);
        List1.add(30);
        List1.addfirst(70);
        List1.addfirst(92);
        List1.add(105);
        List1.add(60);

        names.add("Taha");
        names.add("Fakhir");
        names.add("Humza");
        names.add("Yahya");
        names.add("Saadi");
        names.addfirst("Anas");
        names.pop();

        System.out.println(names);
        names.reverse();
        System.out.println(names);

        // LinkedList<String>.Node i = names.head;
        // while (i != null) {
        // System.out.println(i.data);
        // i = i.next;
        // }

        System.out.println(List1);
        List1.reverse();
        System.out.println(List1);
        System.out.println(List1.get(3));
        System.out.println(names);
        names.set("Wasif", 3);
        System.out.println(names);
        names.addAt("Sameer", 3);
        names.addAt("Saadi", 4);
        System.out.println(names);
        names.removeAt(4);
        System.out.println(names);
        names.removeAt(1);
        System.out.println(names);
        names.addfromlast("Taha", 2);
        System.out.println(names);
        names.removefromlast(2);
        System.out.println(names);
        names.removefromlast(3);
        System.out.println(names);

        LinkedList<String> list2 = new LinkedList<String>();

        list2.add("r");
        list2.add("a");
        list2.add("c");
        list2.add("e");
        list2.add("c");
        list2.add("a");
        list2.add("r");

        list2.isPalindrome();
        System.out.println(list2.isPalindrome(list2.head));

        // ArrayList<String> stringarray = names.toArrayList();
        // System.out.println(stringarray);

    }

}
