
package com.mycompany.parkinglot;

import java.util.*;

public class Floor {
     private int floornum;
     private List<Slot> slots;
     
     Floor(int floornum){
         this.floornum = floornum;
         this.slots = new ArrayList<>();
     }
     
     public int getfloornum(){
         return this.floornum;
     }
     
     public Slot getslot(int i){
         return slots.get(i-1);
     }
     
     public int gettotalfreeslotcount(Vehicletype vtype){
         int count=0;
         for(Slot s : slots){
             if(s.isSlotFree() && vtype==s.getslottype()){
                 count++;
             }
         }
         
         return count;
     }
     
     public List<Integer> getavailableslots(Vehicletype vtype){
         
         List<Integer> avslot = new ArrayList<>();
         
         for(Slot s : slots){
             if(s.isSlotFree() && vtype==s.getslottype()){
                avslot.add(s.getslotnum());
             }
         }
         
         return avslot;
     }
     
     public List<Integer> getoccupiedslot(Vehicletype vtype){
         List<Integer> oslot = new ArrayList<>();
         
         for(Slot s : slots){
             if(!s.isSlotFree() && vtype==s.getslottype()){
                 oslot.add(s.getslotnum());
             }
         }
         
         return oslot;
     }
     
     public Slot getfirstavaliableslot(Vehicletype vtype){
         
         for(Slot s : slots){
             if(s.isSlotFree() && vtype==s.getslottype())
                 return s;
         }
         
         return null;
     }
     
     public void addslots(Slot slot){
         slots.add(slot);
     }
}
