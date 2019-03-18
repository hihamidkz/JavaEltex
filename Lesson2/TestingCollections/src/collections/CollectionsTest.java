package collections;

import java.util.*;

public class CollectionsTest {
    private List<User> usersArray = new ArrayList<>();
    private Set<User> usersSet = new TreeSet<>();
    private Queue<User> usersQueue = new PriorityQueue<>();
    private Map<Integer, User> usersHash = new HashMap();

    private final int COUNT = 1000000;

    public CollectionsTest() {
    	long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            User user = new User();
            usersArray.add(user);
        }
        long finish = System.nanoTime();
        System.out.println("Insert into ArrayList (avg time): " + ((finish - start) / COUNT) + "us");
    }

    public void insert() {
        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            User user = usersArray.get(i);
            usersSet.add(user);
        }
        long finish = System.nanoTime();
        System.out.println("Insert into TreeSet (avg time): " + ((finish - start) / COUNT) + "us");

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            User user = usersArray.get(i);
            usersQueue.add(user);
        }
        finish = System.nanoTime();
        System.out.println("Insert into PriorityQueue (avg time): " + ((finish - start) / COUNT) + "us");

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            User user = usersArray.get(i);
            usersHash.put(i, user);
        }
        finish = System.nanoTime();
        System.out.println("Insert into HashMap (avg time): " + ((finish - start) / COUNT) + "us");
    }

    public void size() {
        long start = System.nanoTime();
        usersSet.size();
        long finish = System.nanoTime();
        System.out.println("Size of TreeSet: " + (finish - start) + "us");

        start = System.nanoTime();
        usersQueue.size();
        finish = System.nanoTime();
        System.out.println("Size of PriorityQueue: " + (finish - start) + "us");

        start = System.nanoTime();
        usersHash.size();
        finish = System.nanoTime();
        System.out.println("Size of HashMap: " + (finish - start) + "us");
    }

    public void remove() {
        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            User user = usersArray.get(i);
            usersSet.remove(user);
        }
        long finish = System.nanoTime();
        System.out.println("Remove from TreeSet (avg time): " + ((finish - start) / COUNT) + "us");

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            User user = usersArray.get(i);
            usersQueue.remove(user);
        }
        finish = System.nanoTime();
        System.out.println("Remove from PriorityQueue (avg time): " + ((finish - start) / COUNT) + "us");

        start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            User user = usersArray.get(i);
            usersHash.remove(user);
        }
        finish = System.nanoTime();
        System.out.println("Remove from HashMap (avg time): " + ((finish - start) / COUNT) + "us");
    }
}
