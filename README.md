# Social Network Platform

## Overview

This project implements a simple social network platform using custom data structures in Java. The platform models users, friendships, posts, and direct messages. It utilizes:
- Graphs for user connections.
- Hash maps for storing user data.
- Priority queues for managing the news feed.
- Lists/arrays for friend lists and direct messages.

## Features

1. **User Management**: Add users to the network.
2. **Friendship Management**: Add friends to a user's friend list.
3. **Post Management**: Users can create posts with varying priorities.
4. **Direct Messaging**: Send direct messages to specific users.
5. **News Feed**: Display a prioritized news feed based on user posts.

## Custom Data Structures

1. **MyArrayList**: Custom implementation of an array list.
2. **MyHashMap**: Custom implementation of a hash map.
3. **MyPriorityQueue**: Custom implementation of a priority queue.

## Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher.
- An IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor (e.g., VSCode) with Java support.
- Command line/terminal.

### Project Structure

/src
├── MyArrayList.java
├── MyHashMap.java
├── MyPriorityQueue.java
├── User.java
├── Message.java
├── Post.java
└── SocialNetwork.java

### Compilation and Execution

1. **Clone the repository**:
   ```sh
   git clone https://github.com/Mgachanja/social-network-simulation.git
   cd social-network-simulation

2. Compile the Java files:
    javac -d bin src/*.java


 3.  Run the application:
       java -cp bin SocialNetwork

 5.  Usage
Once the application is running, you will see a menu with options to manage users, friends, posts, and direct messages. Select an option by entering the corresponding number and follow the prompts.

Example Usage
Add a User:

Choose option 1.
Enter a unique user ID and name when prompted.
Add a Friend:

Choose option 2.
Enter your user ID and your friend's user ID when prompted.
Add a Post:

Choose option 3.
Enter the post ID, user ID, content, and priority when prompted.
Send a Direct Message:

Choose option 4.
Enter your user ID, the recipient's user ID, and the message content when prompted.
Display News Feed:

Choose option 5.
Enter your user ID to view the news feed.
Display Friends:

Choose option 6.
Enter your user ID to view your friends list.
Display Posts:

Choose option 7.
Enter your user ID to view your posts.
Display Direct Messages:

Choose option 8.
Enter your user ID to view messages sent to you along with the sender's user name.
Exit:

Choose option 9 to exit the application.
Notes
Ensure all IDs (user, post) are unique.
Follow the prompts accurately to avoid input errors.
This is a console-based application and currently does not support a graphical user interface (GUI).

