package PPS_related_codes.Assignments.Bonus_Assignment;
import java.util.*;

class CityNode {
    String name;
    CityNode next;

    public CityNode(String name) {
        this.name = name;
        this.next = null;
    }
}

class HashTable {
    private CityNode[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new CityNode[size];
    }

    // Simple hash function based on length of the city name
    private int hash(String cityName) {
        return cityName.toLowerCase().hashCode() % size;
    }

    public void insert(String cityName) {
        int index = hash(cityName);
        if (index < 0) index += size;  // fix negative index if any

        CityNode newNode = new CityNode(cityName);

        // Insert at the head of the chain (linked list) at table[index]
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            CityNode temp = table[index];
            while (temp.next != null) {
                // Optional: skip duplicates
                if (temp.name.equalsIgnoreCase(cityName)) {
                    System.out.println("City '" + cityName + "' already exists in hash table.");
                    return;
                }
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void displayTable() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            CityNode temp = table[i];
            if (temp == null) {
                System.out.println("Empty");
            } else {
                while (temp != null) {
                    System.out.print(temp.name);
                    if (temp.next != null) System.out.print(" -> ");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }
}

public class city_traversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cities to store: ");
        int count = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter size of hash table (suggested >= number of cities): ");
        int tableSize = sc.nextInt();
        sc.nextLine(); // consume newline

        HashTable hashTable = new HashTable(tableSize);

        System.out.println("Enter city names:");
        for (int i = 0; i < count; i++) {
            System.out.print("City " + (i + 1) + ": ");
            String city = sc.nextLine();
            hashTable.insert(city);
        }

        hashTable.displayTable();
    }
}
