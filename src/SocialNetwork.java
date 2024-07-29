import java.util.*;

public class SocialNetwork {
    MyHashMap<String, User> users;
    MyHashMap<String, Post> posts;
    MyPriorityQueue<Post> newsFeed;

    public SocialNetwork() {
        this.users = new MyHashMap<>();
        this.posts = new MyHashMap<>();
        this.newsFeed = new MyPriorityQueue<>();
    }

    public void addUser(String id, String name) {
        users.put(id, new User(id, name));
    }

    public void addFriend(String userId, String friendId) {
        User user = users.get(userId);
        User friend = users.get(friendId);
        if (user != null && friend != null) {
            user.friends.add(friendId);
            friend.friends.add(userId);
        }
    }

    public void addPost(String postId, String userId, String content, int priority) {
        User user = users.get(userId);
        if (user != null) {
            Post post = new Post(postId, userId, content, priority);
            posts.put(postId, post);
            newsFeed.add(post);
            user.posts.put(postId, content);
        }
    }

    public void addDirectMessage(String senderId, String receiverId, String content) {
        User sender = users.get(senderId);
        User receiver = users.get(receiverId);
        if (sender != null && receiver != null) {
            Message message = new Message(senderId, content);
            receiver.directMessages.add(message);
        }
    }

    public void displayNewsFeed(String userId) {
        User user = users.get(userId);
        if (user != null) {
            MyPriorityQueue<Post> userNewsFeed = new MyPriorityQueue<>();
            List<Post> tempList = new ArrayList<>();

            // Add elements to a temporary list for processing
            while (newsFeed.size() > 0) {
                tempList.add(newsFeed.poll());
            }

            // Restore the elements back to the priority queue
            for (Post post : tempList) {
                if (user.friends.contains(post.userId)) {
                    userNewsFeed.add(post);
                }
            }

            // Display the user's news feed
            while (userNewsFeed.size() > 0) {
                Post post = userNewsFeed.poll();
                System.out.println("Post ID: " + post.id + ", User ID: " + post.userId + ", Content: " + post.content + ", Priority: " + post.priority);
            }
        }
    }


    public void displayFriends(String userId) {
        User user = users.get(userId);
        if (user != null) {
            System.out.println("Friends of User ID: " + userId);
            for (String friendId : user.friends) {
                System.out.println(friendId);
            }
        } else {
            System.out.println("User ID not found.");
        }
    }

    public void displayPosts(String userId) {
        User user = users.get(userId);
        if (user != null) {
            System.out.println("Posts of User ID: " + userId);
            for (String postId : user.posts.keySet()) {
                Post post = posts.get(postId);
                if (post != null) {
                    System.out.println("Post ID: " + post.id + ", Content: " + post.content + ", Priority: " + post.priority);
                }
            }
        }
    }


    public void displayDirectMessages(String userId) {
        User user = users.get(userId);
        if (user != null) {
            System.out.println("Direct Messages of User ID: " + userId);
            for (Message message : user.directMessages) {
                System.out.println("From User ID: " + message.getSenderId() + ", Message: " + message.getContent());
            }
        }
    }

  public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("1. Add User");
                System.out.println("2. Add Friend");
                System.out.println("3. Add Post");
                System.out.println("4. Add Direct Message");
                System.out.println("5. Display News Feed");
                System.out.println("6. Display Friends");
                System.out.println("7. Display Posts");
                System.out.println("8. Display Direct Messages");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Clear the invalid input
                    continue;
                }
                
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume the remaining newline

                switch (option) {
                    case 1:
                        System.out.print("Enter user ID: ");
                        String userId = scanner.nextLine();
                        System.out.print("Enter user name: ");
                        String userName = scanner.nextLine();
                        socialNetwork.addUser(userId, userName);
                        break;
                    case 2:
                        System.out.print("Enter user ID: ");
                        String userId1 = scanner.nextLine();
                        System.out.print("Enter friend ID: ");
                        String friendId = scanner.nextLine();
                        socialNetwork.addFriend(userId1, friendId);
                        break;
                    case 3:
                        System.out.print("Enter post ID: ");
                        String postId = scanner.nextLine();
                        System.out.print("Enter user ID: ");
                        String userId2 = scanner.nextLine();
                        System.out.print("Enter post content: ");
                        String postContent = scanner.nextLine();
                        System.out.print("Enter post priority: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // Clear the invalid input
                            continue;
                        }
                        int postPriority = scanner.nextInt();
                        scanner.nextLine(); // Consume the remaining newline
                        socialNetwork.addPost(postId, userId2, postContent, postPriority);
                        break;
                    case 4:
                        System.out.print("Enter user ID: ");
                        String userId3 = scanner.nextLine();
                        System.out.print("Enter receiver user ID: ");
                        String userId8 = scanner.nextLine();
                        System.out.print("Enter direct message: ");
                        String directMessage = scanner.nextLine();
                        socialNetwork.addDirectMessage(userId3,userId8, directMessage);
                        break;
                    case 5:
                        System.out.print("Enter user ID: ");
                        String userId4 = scanner.nextLine();
                        
                        socialNetwork.displayNewsFeed(userId4);
                        break;
                    case 6:
                        System.out.print("Enter user ID: ");
                        String userId5 = scanner.nextLine();
                        socialNetwork.displayFriends(userId5);
                        break;
                    case 7:
                        System.out.print("Enter user ID: ");
                        String userId6 = scanner.nextLine();
                        socialNetwork.displayPosts(userId6);
                        break;
                    case 8:
                        System.out.print("Enter user ID: ");
                        String userId7 = scanner.nextLine();
                        socialNetwork.displayDirectMessages(userId7);
                        break;
                    case 9:
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
  	}
  }
