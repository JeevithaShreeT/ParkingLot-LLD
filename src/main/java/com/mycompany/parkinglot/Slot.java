
package com.mycompany.parkinglot;

public class Slot {
   
   private Vehicletype stype;
   private Vehicle parkvehicle;
   private int slotnum;
   private boolean isOccupied = false;
   
   Slot(Vehicletype stype, int slotnum){
       this.stype = stype;
       this.slotnum = slotnum;
       this.isOccupied = false;
       this.parkvehicle = null;
   }
   
   public boolean isSlotFree(){
       return !isOccupied;
   }
   
   public boolean canpark(Vehicle vehicle){
       return this.stype == vehicle.getVehicletype();
   }
   
   public boolean park(Vehicle vehicle){
       if(this.stype != vehicle.getVehicletype()){
           return false;
       }
       if(isOccupied){
           return false;
       }
       this.parkvehicle = vehicle;
       this.isOccupied = true;
       
       return true;
   }
   
   public Vehicle unpark(){
       Vehicle temp = this.parkvehicle;
       this.parkvehicle = null;
       this.isOccupied = false;
       return temp;
   }
   
   public int getslotnum(){
        return this.slotnum;      
   }
   
   public Vehicle getVehicle(){
       return this.parkvehicle;
   }
   
   public Vehicletype getslottype(){
           return this.stype;
}

}