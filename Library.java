/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{
    private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    public boolean containsTitle(String title){
      return this.collection.containsKey(title);
    }
    public boolean isAvailable(String title){
      return this.collection.getOrDefault(title, false);
    }
    public void printCollection(){
      System.out.println("============================================");
      System.out.println("PRINTED LIST OF "+this.name+" COLLECTION");
      for (String key : collection.keySet()){
        if (this.collection.get(key)){
          System.out.println(key+" - AVALIABLE");
        } else{
          System.out.println(key+" - CHECKED OUT");
        }
      }
      System.out.println("============================================");
    }

    public void addTitle(String title){
      if (!this.containsTitle(title)){
        this.collection.put(title, true);
      } else {
        System.out.println("The book "+title+" is already in the collection and thus cannot be added.");
      }
    }

    public String removeTitle(String title){
      if (this.containsTitle(title)){
        this.collection.remove(title);
      } else {
        System.out.println("The book "+title+" is not in the collection and thus cannot be removed.");
      }
      return title;
    }

    public void checkOut(String title){
      if (this.isAvailable(title)){
        this.collection.put(title, false);
      } else {
        System.out.println("The book "+title+" is unavailiable and thus cannot be checked out.");
      }
    }

    public void returnBook(String title){
      if (!this.isAvailable(title)){
        this.collection.put(title, true);
      } else {
        System.out.println("The book title "+title+" is still in the collection and thus cannot be returned.");
      }
    }

    public static void main(String[] args) {
      System.out.println("test");
      Library frostLibrary = new Library("Robert Frost Library", "12 Mammoth Street", 6);
      frostLibrary.addTitle("The Lorax by Dr. Seuss");
      frostLibrary.printCollection();
      frostLibrary.checkOut("The Lorax by Dr. Seuss");
      frostLibrary.printCollection();
      frostLibrary.returnBook("The Lorax by Dr. Seuss");
      frostLibrary.printCollection();
      frostLibrary.removeTitle("The Lorax by Dr. Seuss");
      frostLibrary.printCollection();
    }
  
  }