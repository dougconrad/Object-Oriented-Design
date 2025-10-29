package hw6;

public class FollowerNotifier implements PostObserver {

  @Override
  public void update(SocialPost post, Event event) {
    switch (event) {
      case PUBLISHED -> System.out.println(
          "Follower Notifier: " + post.getObservers().size() + " followers notified.");
      case LIKED ->
          System.out.println("Follower Notifier: Like notification sent to " + post.getAuthor());
      case SHARED ->
          System.out.println("Follower Notifier: Share notification sent to " + post.getAuthor());
    }
  }

}
