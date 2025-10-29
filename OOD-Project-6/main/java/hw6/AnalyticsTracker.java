package hw6;

public class AnalyticsTracker implements PostObserver {

  @Override
  public void update(SocialPost post, Event event) {
    switch (event) {
      case PUBLISHED -> System.out.println("Analytics Tracker: Post engagement logged.");
      case LIKED -> System.out.println(
          "Analytics Tracker: Like count increased to " + (post.getEngagementScore() - 10));
      case SHARED -> System.out.println(
          "Analytics Tracker: Shared count increased to " + (post.getEngagementScore() - 15));
    }
  }

}
