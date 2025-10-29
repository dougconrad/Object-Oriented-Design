package hw6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SocialPostTest {

  @Test
  void testClonePost() {
    SocialPost post = new PostBuilder()
        .setContent("Original")
        .setAuthor("Author")
        .addTag("#tag")
        .build();

    post.addObserver(new FollowerNotifier());

    SocialPost clone = post.clone();

    assertNotSame(post, clone);
    assertEquals(post.getContent(), clone.getContent());
    assertEquals(post.getTags(), clone.getTags());
    assertTrue(clone.getObservers().isEmpty(), "Clone should have no observers");
  }
}
