package PPS_related_codes.Assignments.Bonus_Assignment;

class IntList {
    class Node {
        private String value;
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;

    public IntList() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void addToEnd(String value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = new Node(value, null);
        }
    }

    public Node find(String value) {
        Node t = head;
        while (t != null) {
            if (t.value.equals(value)) {
                return t;
            }
            t = t.next;
        }
        return null;
    }

    public boolean contains(String value) {
        return find(value) != null;
    }

    public void showListContents() {
        Node temp = head;
        if (temp == null)
            System.out.println("List is empty; nothing to display.");
        else {
            System.out.println("Here are the contents of the list.");
            while (temp != null) {
                System.out.print(temp.value + " ---> ");
                temp = temp.next;
            }
            System.out.println("X");
        }
    }
}

public class MyHashTable {
    private IntList[] table;
    private int size = 10;

    public MyHashTable() {
        table = new IntList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new IntList();
        }
    }

    private int computeHash(String value) {
        // h1(z) = a0 + a1 * z + a2 * z^2 + … + ak−1 * z^k−1
        int hashCode = 0;
        int power = 1;
        for (int i = 0; i < value.length(); i++) {
            int character = (int) value.charAt(i);
            hashCode += character * power;
            power *= 3;
        }
        // h2(y) = [(a*y + b) mod p] mod size
        int hashValue = ((5 * hashCode + 9) % 33) % size;
        System.out.println(value + ": " + hashValue);
        return hashValue;
    }

    public void addToHash(String value) {
        int hashValue = computeHash(value);
        IntList list = table[hashValue];

        if (!list.contains(value)) {
            table[hashValue].addToEnd(value);
        }
    }

    public void showHashTableContents() {
        System.out.println("Here are the contents of the hash table: ");
        System.out.println("======================================== ");

        for (int i = 0; i < table.length; i++) {
            System.out.println("\nList at index " + i + " has the following information: ");
            table[i].showListContents();
        }
    }

    public void resizeHashTable() {
        // create new hashtable with double size and initialize the lists
        size = size * 2;
        IntList[] newTable = new IntList[size];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new IntList();
        }

        // define a list of tails to track the last node in each table element
        IntList.Node[] tails = new IntList.Node[newTable.length];

        for (int i = 0; i < table.length; i++) {
            IntList list = table[i];
            IntList.Node temp = list.getHead();
            IntList.Node prevTemp = null;
            while (temp != null) {
                String value = temp.getValue();
                int newHashValue = computeHash(value);

                if (newTable[newHashValue].getHead() == null) {
                    newTable[newHashValue].setHead(temp);
                } else {
                    tails[newHashValue].setNext(temp);
                }
                prevTemp = temp;
                temp = temp.getNext();
                tails[newHashValue] = prevTemp;
                prevTemp.setNext(null);
            }
        }

        table = newTable;
    }

    public static void main(String[] args) {
        String[] testStrings = {
                "apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon",
                "mango", "nectarine", "orange", "papaya", "quince", "raspberry", "strawberry", "tangerine", "ugli", "vanilla",
                "watermelon", "xigua", "yellowfruit", "zucchini", "apricot", "blackberry", "cantaloupe", "dragonfruit", "eggfruit", "feijoa",
                "guava", "hackberry", "imbe", "jackfruit", "kumquat", "lime", "mulberry", "nutmeg", "olive", "peach",
                "quenepa", "rambutan", "salak", "tamarind", "ugni", "voavanga", "wolfberry", "ximenia", "yangmei", "ziziphus"
        };

        MyHashTable hashtable = new MyHashTable();
        for (String value : testStrings) {
            hashtable.addToHash(value);
        }

        hashtable.showHashTableContents();

        hashtable.resizeHashTable();

        hashtable.showHashTableContents();
    }
}
