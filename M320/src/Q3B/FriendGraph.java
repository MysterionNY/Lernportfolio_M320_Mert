package Q3B;

import java.util.*;

public class FriendGraph {
    private Map<String, Person> people = new HashMap<>();
    private Map<String, List<String>> friendships = new HashMap<>();

    public void addPerson(String name) {
        people.putIfAbsent(name, new Person(name));
        friendships.putIfAbsent(name, new ArrayList<>());
    }

    public void addFriendship(String a, String b) {
        addPerson(a);
        addPerson(b);
        friendships.get(a).add(b);
        friendships.get(b).add(a);
    }

    public void setHasCar(String name, boolean hasCar) {
        addPerson(name);
        people.get(name).setHasCar(hasCar);
    }

    public Set<String> getFriendCircle(String startName) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (!friendships.containsKey(startName)) return visited;

        visited.add(startName);
        queue.add(startName);

        while (!queue.isEmpty()) {
            String current = queue.remove();
            for (String friend : friendships.getOrDefault(current, List.of())) {
                if (!visited.contains(friend)) {
                    visited.add(friend);
                    queue.add(friend);
                }
            }
        }

        visited.remove(startName);
        return visited;
    }

    public String findNearestPersonWithCar(String startName) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (!friendships.containsKey(startName)) return null;

        visited.add(startName);
        queue.add(startName);

        while (!queue.isEmpty()) {
            String current = queue.remove();

            Person p = people.get(current);
            if (p != null && p.hasCar()) {
                return current;
            }

            for (String friend : friendships.getOrDefault(current, List.of())) {
                if (!visited.contains(friend)) {
                    visited.add(friend);
                    queue.add(friend);
                }
            }
        }
        return null;
    }
}

