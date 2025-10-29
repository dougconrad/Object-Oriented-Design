package hw6;

/**
 * Like button decorator class.
 */
public class LikeButtonDecorator implements PostComponent {

  private PostComponent post;

  /**
   * Instantiates like button decorator.
   *
   * @param post - PostComponent, the post
   */
  public LikeButtonDecorator(PostComponent post) {
    this.post = post;
  }

  @Override
  public double getEngagementScore() {
    return post.getEngagementScore() + 10;
  }
}
