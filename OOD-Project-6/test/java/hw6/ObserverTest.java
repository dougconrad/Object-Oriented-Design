package hw6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

  @Test
  void testAddAndRemoveObservers() {
    SocialPost post = new PostBuilder().build();
    PostObserver observer1 = new FollowerNotifier();
    PostObserver observer2 = new AnalyticsTracker();

    post.addObserver(observer1);
    post.addObserver(observer2);
    assertEquals(2, post.getObservers().size());

    post.removeObserver(observer1);
    assertEquals(1, post.getObservers().size());

    assertThrows(IllegalArgumentException.class, () -> post.removeObserver(observer1));
  }

  @Test
  void testNotifyObservers() {
    SocialPost post = new PostBuilder().setAuthor("TestUser").build();
    post.addObserver(new FollowerNotifier());
    post.addObserver(new AnalyticsTracker());

    post.notifyObservers(Event.PUBLISHED);
    post.notifyObservers(Event.LIKED);
    post.notifyObservers(Event.SHARED);
  }
}
