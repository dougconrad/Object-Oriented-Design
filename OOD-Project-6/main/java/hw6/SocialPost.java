package hw6;

import java.util.ArrayList;
import java.util.List;

/**
 * Social post class.
 */
public class SocialPost implements PostComponent, Cloneable, PostObservable {

  private String content;
  private String author;
  private PostType type;
  private List<String> tags;
  private double engagementScore;
  private List<PostObserver> observers;

  /**
   * Creates a new default social post.
   */
  public SocialPost() {
    this.engagementScore = 5.0;
    this.tags = new ArrayList<>();
    this.observers = new ArrayList<>();
  }

  /**
   * Gets content of post.
   *
   * @return - String, the content
   */
// Getters & Setters
  public String getContent() {
    return content;
  }

  /**
   * Sets content of post.
   *
   * @param content - String, the content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Gets author of post.
   *
   * @return - String, the author
   */
  public String getAuthor() {
    return author;
  }

  /**
   * Sets author of post.
   *
   * @param author - String, the author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Gets type of post.
   *
   * @return - PostType, the type
   */
  public PostType getType() {
    return type;
  }

  /**
   * Sets type of post.
   *
   * @param type - PostType, the type
   */
  public void setType(PostType type) {
    this.type = type;
  }

  /**
   * Gets tags of post.
   *
   * @return - List<String>, the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * Adds tag to post.
   *
   * @param tag - String, the tag
   */
  public void addTag(String tag) {
    this.tags.add(tag);
  }

  /**
   * Sets engagement score of post.
   *
   * @param engagementScore - double, the engagement score
   */
  public void setEngagementScore(double engagementScore) {
    this.engagementScore = engagementScore;
  }

  /**
   * Gets observers of post.
   *
   * @return - List<PostObserver>, the observers
   */
  public List<PostObserver> getObservers() {
    return observers;
  }

  @Override
  public double getEngagementScore() {
    return this.engagementScore;
  }

  @Override
  public void addObserver(PostObserver observer) {
    if (!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  @Override
  public void removeObserver(PostObserver observer) {
    if (!observers.contains(observer)) {
      throw new IllegalArgumentException("Observer not found.");
    }
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(Event event) {
    for (PostObserver o : observers) {
      o.update(this, event);
    }
  }

  @Override
  public SocialPost clone() {
    try {
      SocialPost cloned = (SocialPost) super.clone();
      cloned.tags = new ArrayList<>(this.tags);
      cloned.observers = new ArrayList<>();
      return cloned;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
