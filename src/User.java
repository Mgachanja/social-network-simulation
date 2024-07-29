public class User {
    String id;
    String name;
    MyArrayList<String> friends;
    MyArrayList<Message> directMessages;
    MyHashMap<String, String> posts;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.friends = new MyArrayList<>();
        this.directMessages = new MyArrayList<>();
        this.posts = new MyHashMap<>();
    }
}

