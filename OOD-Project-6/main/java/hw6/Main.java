package hw6;

public class Main {

  public static void main(String[] args) {

    SocialPost post = new PostBuilder()
        .setContent("Hello World!")
        .setAuthor("Alice")
        .setType(PostType.TEXT)
        .addTag("#greeting")
        .build();

    System.out.println(
        "Base Post: \"" + post.getContent() + "\" by " + post.getAuthor() + " - Engagement: "
            + post.getEngagementScore());

    PostComponent likePost = new LikeButtonDecorator(post);
    System.out.println("With Like Button: Engagement: " + likePost.getEngagementScore());

    PostComponent likeSharePost = new ShareButtonDecorator(likePost);
    System.out.println("With Like + Share: Engagement: " + likeSharePost.getEngagementScore());

    PostComponent fullPost = new CommentSectionDecorator(likeSharePost);
    System.out.println("With All Features: Engagement: " + fullPost.getEngagementScore());

    new FriendsOnlyStrategy().adoptStrategy();
    new PublicStrategy().adoptStrategy();

    SocialPost templatePost = new PostBuilder()
        .setContent("Daily announcement")
        .setAuthor("Admin")
        .setType(PostType.TEXT)
        .build();

    SocialPost clonedPost = templatePost.clone();
    System.out.println("Template post cloned: \"" + clonedPost.getContent() + "\" ready");

    post.addObserver(new FollowerNotifier());
    post.addObserver(new AnalyticsTracker());

    System.out.println("Post published!");
    post.notifyObservers(Event.PUBLISHED);

    System.out.println("Post liked!");
    post.notifyObservers(Event.LIKED);
  }
}
