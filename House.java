/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  // additional attributes
  private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  public int nResidents(){
    return this.residents.size();
  }

  public void moveIn(Student s){
    this.residents.add(s);
  }

  public Student moveOut(Student s){
    this.residents.remove(s);
    return s;
  }

  public boolean isResident(Student s){
    return residents.contains(s);
  }

  public static void main(String[] args) {
    new House("Tyler", "102 Tyler Avenue", 5, true);
  }

}