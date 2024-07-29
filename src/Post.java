
class Post implements Comparable<Post> {
    String id;
    String userId;
    String content;
    int priority;

    public Post(String id, String userId, String content, int priority) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.priority = priority;
    }

    @Override
    public int compareTo(Post other) {
        return Integer.compare(other.priority, this.priority);
    }
}
