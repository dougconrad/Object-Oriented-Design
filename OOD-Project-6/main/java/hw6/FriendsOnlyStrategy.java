package hw6;

public class FriendsOnlyStrategy implements Strategy {

  @Override
  public void adoptStrategy() {
    System.out.println("Using Friends Only Strategy: Post visible to friends.");
  }
}
