package hw6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostBuilderTest {

  @Test
  void testBuilderCreatesPostCorrectly() {
    SocialPost post = new PostBuilder()
        .setContent("Test Post")
        .setAuthor("Tester")
        .setType(PostType.TEXT)
        .addTag("#unit")
        .build();

    assertEquals("Test Post", post.getContent());
    assertEquals("Tester", post.getAuthor());
    assertEquals(PostType.TEXT, post.getType());
    assertTrue(post.getTags().contains("#unit"));
    assertEquals(5.0, post.getEngagementScore());
  }
}
