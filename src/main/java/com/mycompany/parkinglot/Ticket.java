
package com.mycompany.parkinglot;


public class Ticket {

      private String parkingid = "PR1234";
      private int floorno;
      private int slotno;
      private Vehicle vehicle;
      
      Ticket(int floorno, int slotno, Vehicle vehicle){
          
          this.floorno = floorno;
          this.slotno = slotno;
          this.vehicle = vehicle;
      }
      
      public int getfloorno(){
          return this.floorno;
      }
      
      public int getslotno(){
          return this.slotno;
      }
      
      public Vehicle getvehicle(){
          return this.vehicle;
      }
      
      public String getticket(){
          return parkingid+"_"+floorno+"_"+slotno;
      }
}
