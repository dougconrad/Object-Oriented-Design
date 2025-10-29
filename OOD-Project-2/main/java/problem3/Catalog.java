package problem3;

import java.util.ArrayList;

public class Catalog {

  public ArrayList<Item> catalog;

  /**
   * Constructor for class Catalog
   *
   * @param catalog - ArrayList, list of all items in catalog
   */
  public Catalog(ArrayList<Item> catalog) {
    this.catalog = catalog;
  }

  /**
   * Searches for items based on keyword
   *
   * @param keyword - String, word being searched for in catalog
   * @return - ArrayList, list of all items containing keyword
   */
  public ArrayList<Item> search(String keyword) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : catalog) {
      if (item.title.contains(keyword)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Searches for items based on author
   *
   * @param author - Author, author being searched for
   * @return - ArrayList, list of all items with Author author
   */
  public ArrayList<Item> search(Author author) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : catalog) {
      if (item.creator.equals(author) && item instanceof Book) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Searches for items based on recording artist
   *
   * @param artist - RecordingArtist, artist being searched for
   * @return - ArrayList, list of all items with RecordingArtist artist
   */
  public ArrayList<Item> search(RecordingArtist artist) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : catalog) {
      if (item.creator.equals(artist) && item instanceof Music) {
        result.add(item);
      }
    }
    return result;
  }

  public ArrayList<Item> search(Band band) {
    ArrayList<Item> result = new ArrayList<>();
    for (Item item : catalog) {
      if (item.creator.equals(band) && item instanceof Music) {
        result.add(item);
      }
    }
    for (Item item : catalog) {
      for (RecordingArtist m : band.members) {
        if (item.creator.equals(m)) {
          result.add(item);
        }
      }
    }
    return result;
  }
}
