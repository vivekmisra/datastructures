package org.vivek.myinterview.demo.customlibimpl;

public class LinkedHashMapCustom<K, V> {
    
    private HashEntry<K,V>[] bucket;   //Array of Entry.
    private int capacity= 2;  //Initial capacity of HashMap
    private HashEntry<K,V> header; //head of the doubly linked list.
    private HashEntry<K,V> last; //last of the doubly linked list.

    /*
     * before and after are used for maintaining insertion order.
     */
    static class HashEntry<K, V> {
        K key;
        V value;
        HashEntry<K,V> next;
        HashEntry<K,V> before;
        HashEntry<K,V> after;
           
        public HashEntry(K key, V value, HashEntry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    

   @SuppressWarnings("unchecked")
   public LinkedHashMapCustom(){
      bucket = new HashEntry[capacity];
   }

  

   /**
    * Method allows you put key-value pair in LinkedHashMapCustom.
    * If the map already contains a mapping for the key, the old value is replaced.
    * Note: method does not allows you to put null key thought it allows null values.
    * Implementation allows you to put custom objects as a key as well.
    * Key Features: implementation provides you with following features:-
    *     >provide complete functionality how to override equals method.
    *  >provide complete functionality how to override hashCode method.
    * @param newKey
    * @param data
    */
   public void put(K newKey, V data){
      if(newKey==null)
          return;    //does not allow to store null.
     
      int index=getIndex(newKey);
      
      HashEntry<K,V> newEntry = new HashEntry<K,V>(newKey, data, null);
      maintainOrderAfterInsert(newEntry);       
       if(bucket[index] == null){
        bucket[index] = newEntry;
       }else{
          HashEntry<K,V> previous = null;
          HashEntry<K,V> current = bucket[index];
          while(current != null){ //we have reached last entry of bucket.
          if(current.key.equals(newKey)){                  
              if(previous==null){  //node has to be insert on first of bucket.
                    newEntry.next=current.next;
                    bucket[index]=newEntry;
                    return;
              }
              else{
                  newEntry.next=current.next;
                  previous.next=newEntry;
                  return;
              }
          }
          previous=current;
            current = current.next;
        }
        previous.next = newEntry;
       }
   }

  
   /**
    * below method helps us in ensuring insertion order of LinkedHashMapCustom after new key-value pair is added.
    */
   private void maintainOrderAfterInsert(HashEntry<K, V> newEntry) {
          
      if(header==null){
          header=newEntry;
          last=newEntry;
          return;
      }
     
      if(header.key.equals(newEntry.key)){
          deleteFirst();
          insertFirst(newEntry);
          return;
      }
     
      if(last.key.equals(newEntry.key)){
          deleteLast();
          insertLast(newEntry);
          return;
      }
     
      HashEntry<K, V> beforeDeleteEntry=    deleteSpecificEntry(newEntry);
      if(beforeDeleteEntry==null){
          insertLast(newEntry);
      }
      else{
          insertAfter(beforeDeleteEntry,newEntry);
      }
     
     
   }

   /**
    * below method helps us in ensuring insertion order of LinkedHashMapCustom, after deletion of key-value pair.
    */
   private void maintainOrderAfterDeletion(HashEntry<K, V> deleteEntry) {
          
      if(header.key.equals(deleteEntry.key)){
          deleteFirst();
          return;
      }
     
      if(last.key.equals(deleteEntry.key)){
          deleteLast();
          return;
      }
     
      deleteSpecificEntry(deleteEntry);
     
   }

   /**
    * returns entry after which new entry must be added.
    */
   private void insertAfter(HashEntry<K, V> beforeDeleteEntry, HashEntry<K, V> newEntry) {
      HashEntry<K, V> current=header;
          while(current!=beforeDeleteEntry){
                 current=current.after;  //move to next node.
          }
          
          newEntry.after=beforeDeleteEntry.after;
          beforeDeleteEntry.after.before=newEntry;
          newEntry.before=beforeDeleteEntry;
          beforeDeleteEntry.after=newEntry;
          
   }


   /**
    * deletes entry from first.
    */
   void deleteFirst(){

      if(header==last){ //only one entry found.
                 header=last=null;
                 return;
          }
          header=header.after;
          header.before=null;
          
   }
   
   /**
    * inserts entry at first.
    */
   void insertFirst(HashEntry<K, V> newEntry){      
          
          if(header==null){ //no entry found
                 header=newEntry;
                 last=newEntry;
                 return;
          }
          
          newEntry.after=header;
          header.before=newEntry;
          header=newEntry;
          
   }

   /**
    * inserts entry at last.
    */
   void insertLast(HashEntry<K, V> newEntry){
          
          if(header==null){
                 header=newEntry;
                 last=newEntry;
                 return;
          }
          last.after=newEntry;
          newEntry.before=last;
          last=newEntry;
                 
   }
   
   /**
    * deletes entry from last.
    */
   void deleteLast(){
          
          if(header==last){
                 header=last=null;
                 return;
          }
          
          last=last.before;
          last.after=null;
   }
   

   /**
    * deletes specific entry and returns before entry.
    */
   private HashEntry<K, V> deleteSpecificEntry(HashEntry<K, V> newEntry){
                       
          HashEntry<K, V> current=header;
          while(!current.key.equals(newEntry.key)){
                 if(current.after==null){   //entry not found
                       return null;
                 }
                 current=current.after;  //move to next node.
          }
          
          HashEntry<K, V> beforeDeleteEntry=current.before;
          current.before.after=current.after;
          current.after.before=current.before;  //entry deleted
          return beforeDeleteEntry;
   }


   /**
    * Method returns value corresponding to key.
    * @param key
    */
   public V get(K key){
       int hash = getIndex(key);
       if(bucket[hash] == null){
        return null;
       }else{
        HashEntry<K,V> temp = bucket[hash];
        while(temp!= null){
            if(temp.key.equals(key))
                return temp.value;
            temp = temp.next; //return value corresponding to key.
        }         
        return null;   //returns null if key is not found.
       }
   }


   /**
    * Method removes key-value pair from HashMapCustom.
    * @param key
    */
   public boolean remove(K deleteKey){
      
      int hash=getIndex(deleteKey);
             
     if(bucket[hash] == null){
           return false;
     }else{
       HashEntry<K,V> previous = null;
       HashEntry<K,V> current = bucket[hash];
       
       while(current != null){ //we have reached last entry node of bucket.
          if(current.key.equals(deleteKey)){
              maintainOrderAfterDeletion(current);
              if(previous==null){  //delete first entry node.
                    bucket[hash]=bucket[hash].next;
                    return true;
              }
              else{
                    previous.next=current.next;
                  return true;
              }
          }
          previous=current;
            current = current.next;
         }
       return false;
     }
   
   }
  

   /**
    * Method displays all key-value pairs present in HashMapCustom.,
    * insertion order is not guaranteed, for maintaining insertion order refer linkedHashMapCustom.
    * @param key
    */
   public void display(){
      
      HashEntry<K, V> currentEntry=header;
      while(currentEntry!=null){
          System.out.print("{"+currentEntry.key+"="+currentEntry.value+"}" +"   ");
          currentEntry=currentEntry.after;
      }
   
   }
   /**
    * Method implements hashing functionality, which helps in finding the appropriate bucket location to store our data.
    * This is very important method, as performance of HashMapCustom is very much dependent on  this method's implementation.
    * @param key
    */
   private int getIndex(K key){
       return Math.abs(key.hashCode()) % capacity;
   }



/** Copyright (c), AnkitMittal  JavaMadeSoEasy.com */
/**
* Main class- to test HashMap functionality.
*/

    
   public static void main(String[] args) {
      LinkedHashMapCustom<Employee, Integer> linkedHashMapCustom = new LinkedHashMapCustom<Employee, Integer>();

      linkedHashMapCustom.put(new Employee("10", "sam"), 12);
      linkedHashMapCustom.put(new Employee("21", "amy"), 121);
      linkedHashMapCustom.put(new Employee("31", "rob"), 151);
      linkedHashMapCustom.put(new Employee("41", "sam"), 15);
      linkedHashMapCustom.put(new Employee("42", "wil"), 89);
     
          System.out.println("Display values corresponding to keys>");
          System.out.println("value corresponding to employee with id=21 & name='amy' : "+linkedHashMapCustom.get(new Employee("21", "amy")));
          System.out.println("value corresponding to employee with id=51 & name='pat' : "+linkedHashMapCustom.get(new Employee("51", "pat")));
          
       System.out.print("Displaying : ");
       linkedHashMapCustom.display();
      
       System.out.println("\n\nvalue corresponding to employee with id=21 & name='amy' removed: "+linkedHashMapCustom.remove(new Employee("21", "amy")));
       System.out.println("value corresponding to employee with id=51 & name='pat' removed: "+linkedHashMapCustom.remove(new Employee("51", "pat")));
          
          System.out.print("Displaying : ");
       linkedHashMapCustom.display();
     
   }
   static class Employee {
	    private String id;
	    private String name;
	    
	    /**
	     * Employee constructor
	     */
	    public Employee(String id, String name) { // constructor
	           this.id = id;
	           this.name = name;
	    }
	 
	    @Override
	    public String toString() {
	           return "Employee[id=" + id + ", name=" + name + "] ";
	    }
	 
	 
	    @Override
	    public boolean equals(Object o){
	           
	           if(o==null)
	                  return false;
	           if(this.getClass()!=o.getClass())
	                  return false;
	    
	           Employee e=(Employee)o;
	           return e.id.equals(this.id) && e.name.equals(this.name);          
	    }
	           
	    @Override
	    public int hashCode(){
	           return id.hashCode() + name.hashCode();      
	    }
	 
	}
}
