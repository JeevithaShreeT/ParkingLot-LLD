
package com.mycompany.parkinglot;

import java.util.*;


public class Parking {
      private String parkingid = "PR1234";
      List<Floor> floors;
      
      Parking(String parkingid){
          this.parkingid = "PR1234";
          floors = new ArrayList<>();
      }
      
      public void addfloors(int count){
          
          for(int i=0; i<count; i++){
              Floor floor = new Floor(i);
              floors.add(floor);
              System.out.println("Added floor number "+ i);
          }
         System.out.println("floors are added");
      }
      
      public void addslotstofloors(int floorno, int slotno){
          
          if(floorno < 1 || floorno > floors.size()){
              System.out.println("Invalid floor number");
              return;
            }
           
          Floor floor = floors.get(floorno - 1);
          
          for(int i=0; i<slotno; i++){
              
              Vehicletype stype;
              
              if(i==1){
                  stype = Vehicletype.TRUCK;
              }
              else if(i==2 || i==3){
                  stype = Vehicletype.BIKE;
              }
              else{
                  stype = Vehicletype.CAR;
              }
              
              Slot slot = new Slot(stype, i);
              floor.addslots(slot);
          }
          
          System.out.println("Added "+slotno+"slots to floor "+floorno);
      }
      
      public Ticket parkvehicle(Vehicle vehicle){
          
          for(Floor f : floors){
              Slot slot = f.getfirstavaliableslot(vehicle.getVehicletype());
              
              if(slot!=null){
                  slot.park(vehicle);
                  
                  int slotnum = slot.getslotnum();
                  int floornum = f.getfloornum();
                  
                  Ticket ticket = new Ticket(floornum, slotnum, vehicle);
                  return ticket;
              }
          }
          
          System.out.println("no avaliable slots");
          return null;
      }
      
      public boolean unparkvehicle(String ticketid){
          
          try{
              String[] tick = ticketid.split("_");
              
              if(tick.length != 3 || !tick[0].equals("PR1234")){
                  System.out.println("Invalid ticket");
                  return false;
              }
              
              int floornum = Integer.parseInt(tick[1]);
              int slotnum = Integer.parseInt(tick[2]);
              
              Floor floor = floors.get(floornum-1);
              Slot slot = floor.getslot(slotnum);
              
              if(slot.isSlotFree()){
                  System.out.println("Slot already free");
                  return false;
              }
              
              slot.unpark();
              System.out.println("The slot is free to park");
              return true;
          }
          catch(Exception e){
              System.out.println("Error while unparking "+e.getMessage());
              return false;
          }
      }
      
      public void displayfreeslots(Vehicletype vtype){
          
          for(Floor f : floors){
             List<Integer> slots =f.getavailableslots(vtype);
             System.out.println("The number of free slots for "+vtype+" on floor "+f.getfloornum()+"is "+slots);
          }
      }
      
      public void displayfreeslotno(Vehicletype vtype){
              
          for(Floor f : floors){
              int count = f.gettotalfreeslotcount(vtype);
              System.out.println("The total free slots for "+vtype+"on floor "+f.getfloornum()+"is "+count);
          }
      }
      
      public void displayoccupiedslots(Vehicletype vtype){
          
          for(Floor f : floors){
              List<Integer> slots = f.getoccupiedslot(vtype);
              System.out.println("The occupied slot of "+vtype+"ont floor "+f.getfloornum()+"are "+slots);
          }
      }
}

