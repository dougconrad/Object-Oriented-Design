package hw6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {

  @Test
  void testEngagementScoreWithDecorators() {
    SocialPost post = new PostBuilder().build();

    PostComponent withLike = new LikeButtonDecorator(post);
    assertEquals(15.0, withLike.getEngagementScore());

    PostComponent withLikeShare = new ShareButtonDecorator(withLike);
    assertEquals(30.0, withLikeShare.getEngagementScore());

    PostComponent withAll = new CommentSectionDecorator(withLikeShare);
    assertEquals(50.0, withAll.getEngagementScore());
  }
}
