package hw6;

/**
 * Post observer interface.
 */
public interface PostObserver {

  /**
   * Updates a post with the given event.
   *
   * @param post  - SocialPost, the post
   * @param event - Event, the event
   */
  void update(SocialPost post, Event event);

}
