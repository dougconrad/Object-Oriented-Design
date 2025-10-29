package problem3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {

  Author JRRTolkien;
  Book book;
  RecordingArtist MacDemarco;
  Music preoccupied;
  ArrayList<RecordingArtist> members;
  Band theBeatles;
  Music yellowSubmarine;
  ArrayList<Item> items;
  Catalog catalog;


  @BeforeEach
  void setUp() {
    Author JRRTolkien = new Author("JRR", "Tolkien");
    Book book = new Book(JRRTolkien, "The Lord Of The Rings", 1999);
    RecordingArtist MacDemarco = new RecordingArtist("Mac", "Demarco");
    Music preoccupied = new Music(MacDemarco, "Preoccupied", 2000);
    ArrayList<RecordingArtist> members = new ArrayList<>();
    members.add(MacDemarco);
    Band theBeatles = new Band("The Beatles", members);
    Music yellowSubmarine = new Music(theBeatles, "Yellow Submarine", 2000);
    ArrayList<Item> items = new ArrayList<Item>();
    items.add(book);
    items.add(preoccupied);
    items.add(yellowSubmarine);
    Catalog catalog = new Catalog(items);
  }

  @Test
  void testSearchWithKeyword() {
    Author JRRTolkien = new Author("JRR", "Tolkien");
    Book book = new Book(JRRTolkien, "The Lord Of The Rings", 1999);
    ArrayList<Item> items = new ArrayList<Item>();
    items.add(book);
    Catalog catalog = new Catalog(items);
    assertEquals(items, catalog.search("The Lord Of The Rings"));
  }

  @Test
  void testSearchWithAuthor() {
    assertEquals(items, catalog.search(JRRTolkien));
  }

  @Test
  void testSearchWithRecordingArtist() {
    assertEquals(items, catalog.search(MacDemarco));

  }

  @Test
  void testSearchWithBand() {
    assertEquals(items, catalog.search(theBeatles));
  }
}