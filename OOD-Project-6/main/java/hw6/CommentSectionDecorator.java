package hw6;

/**
 * Comment section decorator class.
 */
public class CommentSectionDecorator implements PostComponent {

  private PostComponent post;

  /**
   * Instantiates comment section decorator.
   *
   * @param post - PostComponent, the post
   */
  public CommentSectionDecorator(PostComponent post) {
    this.post = post;
  }

  @Override
  public double getEngagementScore() {
    return post.getEngagementScore() + 20;
  }
}
