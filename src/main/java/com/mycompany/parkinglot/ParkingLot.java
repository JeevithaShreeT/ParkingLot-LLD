
package com.mycompany.parkinglot;

import java.util.Scanner;


public class ParkingLot {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Parking park = null;
       
       while(scanner.hasNextLine()){
       String input = scanner.nextLine();
       
       String[] inputs = input.split(" ");
       
       String command = inputs[0];
       
       switch(command){
           case "create_parking_lot":
               String parkingid = inputs[1];
               int floorno = Integer.parseInt(inputs[2]);
               int slotsperfloor = Integer.parseInt(inputs[3]);
               
               park = new Parking(parkingid);
               park.addfloors(floorno);
               for(int i=1; i<=floorno; i++){
               park.addslotstofloors(i, slotsperfloor);
               }
               System.out.println("Parking lot is created with "+floorno+" floors, having "+slotsperfloor+" slots per floor");
               break;
               
           case "park_vehicle":  
               Vehicletype type = Vehicletype.valueOf(inputs[1]);
               String regno = inputs[2];
               String color = inputs[3];
               
               Vehicle vehicle = new Vehicle(type, regno, color);
               Ticket ticket = park.parkvehicle(vehicle);
               if(ticket != null){
                   System.out.println("Vehicle is parked and the ticket id is "+ticket.getticket());
               }
               else{
                   System.out.println("The vehicle is not parked, no slots available");
               }
               
               break;
               
           case "unpark_vehicle":
                 String ticketid = inputs[1];
                 boolean success = park.unparkvehicle(ticketid);
                 if(success){
                     System.out.println("Unparked the vehicle");
                 }
                 else{
                     System.out.println("Invalid ticket ID");
                 }
                  
                 break;
                 
           case "display" :
               String dtype = inputs[1];
               Vehicletype vtype = Vehicletype.valueOf(inputs[2]);
               
               if(dtype.equalsIgnoreCase("free_count")){
                   park.displayfreeslotno(vtype);
               }
               else if(dtype.equalsIgnoreCase("free_slots")){
                   park.displayfreeslots(vtype);
               }
               else if(dtype.equalsIgnoreCase("occupied_slots")){
                   park.displayoccupiedslots(vtype);
               }
               else{
                   System.out.println("Invalid Request");
               }
               break;
               
               
           case "exit":
               return;
               
       }
       }
       scanner.close();
    }
}
