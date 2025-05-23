
package com.mycompany.parkinglot;


public class Vehicle {
    private Vehicletype vtype;
    private String registernum;
    private String color;
    
    Vehicle(Vehicletype vtype, String registernum, String color){
        this.vtype = vtype;
        this.registernum = registernum;
        this.color = color;
    }
    
    public Vehicletype getVehicletype(){
        return vtype;
    }
    
    public String getredisternum(){
        return registernum;
    }
    
}
