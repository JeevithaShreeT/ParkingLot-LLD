This project implements a command-line-based Parking Lot Management System using object-oriented principles and a clean modular design. It demonstrates real-world application of LLD (Low-Level Design), OOP, and interface-driven architecture.

📚 Table of Contents
Overview

Features

Object-Oriented Design

Class Diagram

How It Works

How to Run

Sample Commands

Tech Stack

Future Enhancements

🔍 Overview
The Parking Lot System supports:

Creating a parking lot

Adding multiple floors and slots

Parking and unparking vehicles of different types

Displaying free and occupied slots by vehicle type

This project follows LLD best practices and is built for clarity, extensibility, and interview readiness.

✨ Features
Create a parking lot with multiple floors

Add parking slots by vehicle type:

🏍️ Bike

🚗 Car

🚚 Truck

Automatically finds the lowest available slot for the vehicle

Generates a ticket on successful parking

Unparks a vehicle using its ticket

Shows:

Number of free slots per floor

Free slot numbers per floor

Occupied slot numbers per floor

🧱 Object-Oriented Design
Class	Responsibility
Vehicle	Represents a vehicle with type, registration, and color
Slot	A parking slot that can hold one specific type of vehicle
Floor	Contains a list of parking slots and provides slot availability
Ticket	Generated when a vehicle is parked
Parking	Manages all floors, parking, unparking, and displays
Main(ParkingLot)	Handles command-line inputs and invokes the system

🧩 Class Diagram (Textual)

ParkingLot
 ├── List<Floor>
Floor
 ├── List<Slot>
Slot
 ├── Vehicle (optional)
Vehicle
 ├── VehicleType (CAR, BIKE, TRUCK)
Ticket
 ├── String ticketId

⚙️ How It Works
The system initializes a parking lot (PR1234) with given floors and slots.

You can add slots (default rule: 1 Truck, 2 Bikes, rest Cars per floor).

When a vehicle is parked:

The system looks for the first valid slot (lowest floor, lowest slot number).

It assigns the slot, creates a ticket, and prints the ticket.

You can unpark the vehicle using the ticket ID.

Use display commands to check the state of the parking lot.

▶️ How to Run

javac Main.java
java Main

Then enter commands like:

create_parking_lot 2 6
park_vehicle CAR KA-01-HH-1234 Red
display free_count CAR
unpark_vehicle PR1234_1_4
exit

💬 Sample Commands

create_parking_lot <num_floors> <slots_per_floor>
park_vehicle <vehicle_type> <reg_number> <color>
unpark_vehicle <ticket_id>
display <display_type> <vehicle_type>
exit

Display Types:
free_count

free_slots

occupied_slots

🧪 Example
create_parking_lot 2 6
park_vehicle BIKE TN-22-1001 Black
park_vehicle CAR KA-01-HH-1234 Red
display free_slots CAR
unpark_vehicle PR1234_1_3
display occupied_slots BIKE

🛠️ Tech Stack
Java (Object-Oriented Design)

Command Line I/O

Java Collections (List, Map)

📁 Project Structure

/src
 ├── Main(ParkingLot).java
 ├── Parking.java
 ├── Floor.java
 ├── Slot.java
 ├── Vehicle.java
 ├── Ticket.java
 ├── VehicleType.java (Enum)
 
🧠 Learning Purpose
This project is built with interview and learning purposes in mind. It’s a great way to understand:

OOP principles

Clean class design

Command-driven architecture

**BELOW IS THE LLD PARKING LOT QUESTION TO UNDERSTAND THE PROBLEM:
(THE PROBLEM IS AVALIABLE AT work@tech website under LLD practice Problems)**

Create a command-line application for the parking lot system with the following requirements.

The functions that the parking lot system can do:
Create the parking lot.
Add floors to the parking lot.
Add a parking lot slot to any of the floors.
Given a vehicle, it finds the first available slot, books it, creates a ticket, parks the vehicle, and finally returns the ticket.
Unparks a vehicle given the ticket id.
Displays the number of free slots per floor for a specific vehicle type.
Displays all the free slots per floor for a specific vehicle type.
Displays all the occupied slots per floor for a specific vehicle type.
Details about the Vehicles:
Every vehicle will have a type, registration number, and color.
Different Types of Vehicles:
Car
Bike
Truck
Details about the Parking Slots:
Each type of slot can park a specific type of vehicle.
No other vehicle should be allowed by the system.
Finding the first available slot should be based on:
The slot should be of the same type as the vehicle.
The slot should be on the lowest possible floor in the parking lot.
The slot should have the lowest possible slot number on the floor.
Numbered serially from 1 to n for each floor where n is the number of parking slots on that floor.
Details about the Parking Lot Floors:
Numbered serially from 1 to n where n is the number of floors.
Might contain one or more parking lot slots of different types.
We will assume that the first slot on each floor will be for a truck, the next 2 for bikes, and all the other slots for cars.
Details about the Tickets:
The ticket id would be of the following format:
<parking_lot_id>_<floor_no>_<slot_no>
Example: PR1234_2_5 (denotes 5th slot of 2nd floor of parking lot PR1234)
We can assume that there will only be 1 parking lot. The ID of that parking lot is PR1234.
Input/Output Format
The code should strictly follow the input/output format and will be tested with provided test cases.

Input Format
Multiple lines with each line containing a command.

Possible commands:

create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
park_vehicle <vehicle_type> <reg_no> <color>
unpark_vehicle <ticket_id>
display <display_type> <vehicle_type>
Possible values of display_type: free_count, free_slots, occupied_slots
exit
Stop taking the input when you encounter the word exit.

Output Format
Print output based on the specific commands as mentioned below.

create_parking_lot
Created parking lot with <no_of_floors> floors and <no_of_slots_per_floor> slots per floor

park_vehicle
Parked vehicle. Ticket ID: <ticket_id>
Print "Parking Lot Full" if slot is not available for that vehicle type.

unpark_vehicle
Unparked vehicle with Registration Number: <reg_no> and Color: <color>
Print "Invalid Ticket" if ticket is invalid or parking slot is not occupied.

display free_count <vehicle_type>
No. of free slots for <vehicle_type> on Floor <floor_no>: <no_of_free_slots>
The above will be printed for each floor.

display free_slots <vehicle_type>
Free slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
The above will be printed for each floor.

display occupied_slots <vehicle_type>
Occupied slots for <vehicle_type> on Floor <floor_no>: <comma_separated_values_of_slot_nos>
The above will be printed for each floor.


## 👤 Author

- 👩‍💻 Jeevitha Shree  
- 🔗 [GitHub Profile](https://github.com/JeevithaShreeT)
