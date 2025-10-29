package hw6;

/**
 * Share button decorator class.
 */
public class ShareButtonDecorator implements PostComponent {

  private PostComponent post;

  /**
   * Instantiates a new Share button decorator.
   *
   * @param post PostComponent, the post
   */
  public ShareButtonDecorator(PostComponent post) {
    this.post = post;
  }

  @Override
  public double getEngagementScore() {
    return post.getEngagementScore() + 15;
  }
}
