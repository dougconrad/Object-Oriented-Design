package hw6;

/**
 * Post observable interface.
 */
public interface PostObservable {

  /**
   * Adds an observer.
   *
   * @param observer - PostObserver, the observer
   */
  void addObserver(PostObserver observer);

  /**
   * Removes an observer.
   *
   * @param observer - PostObserver, the observer
   */
  void removeObserver(PostObserver observer);

  /**
   * Notifies observers.
   *
   * @param event - Event, the event
   */
  void notifyObservers(Event event);

}
