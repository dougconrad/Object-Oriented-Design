package hw6;

/**
 * Post builder class.
 */
public class PostBuilder {

  private SocialPost post;

  /**
   * Instantiates post builder.
   */
  public PostBuilder() {
    post = new SocialPost();
  }

  /**
   * Sets the content of the post.
   *
   * @param content - String, the content
   * @return - PostBuilder, the post builder
   */
  public PostBuilder setContent(String content) {
    post.setContent(content);
    return this;
  }

  /**
   * Sets the author of the post.
   *
   * @param author - String, the author
   * @return - PostBuilder, the post builder
   */
  public PostBuilder setAuthor(String author) {
    post.setAuthor(author);
    return this;
  }

  /**
   * Sets the type of post.
   *
   * @param type - PostType, the type
   * @return - PostBuilder, the post builder
   */
  public PostBuilder setType(PostType type) {
    post.setType(type);
    return this;
  }

  /**
   * Add tags to the post.
   *
   * @param tag - String, the tag
   * @return - PostBuilder, the post builder
   */
  public PostBuilder addTag(String tag) {
    post.addTag(tag);
    return this;
  }

  /**
   * Build social post.
   *
   * @return the social post
   */
  public SocialPost build() {
    return post;
  }
}
