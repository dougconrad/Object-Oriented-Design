package hw6;

public class PrivateStrategy implements Strategy {
  
  @Override
  public void adoptStrategy() {
    System.out.println("Using Private Strategy: Post visible to author only.");
  }
}
