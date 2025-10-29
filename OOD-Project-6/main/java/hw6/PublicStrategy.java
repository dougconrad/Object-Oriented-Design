package hw6;

public class PublicStrategy implements Strategy {

  @Override
  public void adoptStrategy() {
    System.out.println("Using Public Strategy: Post visible to everyone.");
  }
}
