package src.linkedlist.Singlylinkedlist;

import java.util.ArrayList;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends; // store friend IDs
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialNetwork {
    User head;

    /* Add new user */
    void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    /* Find user by ID */
    User findById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    /* Search user by name */
    void searchByName(String name) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("User not found.");
    }

    /* Add friend connection */
    void addFriend(int id1, int id2) {
        User u1 = findById(id1);
        User u2 = findById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        if (!u1.friends.contains(id2))
            u1.friends.add(id2);
        if (!u2.friends.contains(id1))
            u2.friends.add(id1);

        System.out.println("Friend connection added.");
    }

    /* Remove friend connection */
    void removeFriend(int id1, int id2) {
        User u1 = findById(id1);
        User u2 = findById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        u1.friends.remove(Integer.valueOf(id2));
        u2.friends.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed.");
    }

    /* Display all friends of a user */
    void displayFriends(int id) {
        User user = findById(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int friendId : user.friends) {
            User f = findById(friendId);
            if (f != null)
                System.out.println("- " + f.name);
        }
    }

    /* Find mutual friends */
    void mutualFriends(int id1, int id2) {
        User u1 = findById(id1);
        User u2 = findById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Mutual Friends:");
        boolean found = false;

        for (int f : u1.friends) {
            if (u2.friends.contains(f)) {
                User mutual = findById(f);
                if (mutual != null) {
                    System.out.println("- " + mutual.name);
                    found = true;
                }
            }
        }

        if (!found)
            System.out.println("No mutual friends.");
    }

    /* Count number of friends for each user */
    void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(
                temp.name + " has " + temp.friends.size() + " friends."
            );
            temp = temp.next;
        }
    }

    /* Display user details */
    void displayUser(User u) {
        System.out.println(
            "ID: " + u.userId +
            ", Name: " + u.name +
            ", Age: " + u.age +
            ", Friends: " + u.friends.size()
        );
    }
}

public class SocialMediaFriendManagement {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();

        sn.addUser(1, "Alice", 20);
        sn.addUser(2, "Bob", 22);
        sn.addUser(3, "Charlie", 21);
        sn.addUser(4, "Diana", 23);

        sn.addFriend(1, 2);
        sn.addFriend(1, 3);
        sn.addFriend(2, 3);
        sn.addFriend(2, 4);

        sn.displayFriends(1);
        sn.mutualFriends(1, 2);
        sn.searchByName("Charlie");
        sn.countFriends();

        sn.removeFriend(1, 2);
        sn.displayFriends(1);
    }
}

