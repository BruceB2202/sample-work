/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook.ui;

import com.tsguild.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public class AddressBookView {

    private UserIO io;
    public AddressBookView(UserIO io){
        this.io = io;
    }

    public int printMenuGetUserChoice() {
        io.print("===Main Menu===");
        io.print("");
        io.print("What would you like to do?:");
        io.print("  1. Add an address");
        io.print("  2. Remove an address");
        io.print("  3. Look up an address");
        io.print("  4. Get number of addresses in address book");
        io.print("  5. Get all addresses");
        io.print("  6. Edit an address");
        io.print("  7. Exit the program");
        int userChoice = io.readInt("What would you like to do?(1-7)", 1, 7);
        return userChoice;
    }

    public void displayAddAddressBanner() {
        io.print("===Add a New Address===");
    }

    public Address getNewAddressDetails() {
        String firstNames = io.readString("Please input the first names of ALL people you want to associate with the address.");
        String lastName = io.readString("Please input the last name you would like to associate with the address.");
        String streetAddress = io.readString("House number and street name: ");
        String city = io.readString("City: ");
        String state = io.readString("State: ");
        String zipCode = io.readString("Zip Code: ");
        Address newAddress = new Address(lastName);
        newAddress.setFirstName(firstNames);
        newAddress.setStreetAddress(streetAddress);
        newAddress.setCity(city);
        newAddress.setState(state);
        newAddress.setZipCode(zipCode);
        return newAddress;
    }

    public void displaySuccessBanner() {
        io.readString("SUCCESS! Action completed. Press enter to continue.");
    }

    public void displayUnknownCommandMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void displayRemoveAddressBanner() {
        io.print("===Remove An Address===");
    }

    public String getLastName() {
        String lastNameChoice = io.readString("Please input the last name associated with the address you would like to interact with: ");
        return lastNameChoice;
    }

    public void displayFindAddressBanner() {
        io.print("===Find an Address===");
    }

    public void displayDisplayNumberOfAddressesBanner() {
        io.print("===Total Number of Addresses===");
    }

    public void displayNumberOfAddressesMessage(int numberOfAddresses) {
        io.print("The number of addresses currently in your mailbox is " + numberOfAddresses);
    }

    public void displayWantedAddress(Address wantedAddress) {
        io.print(wantedAddress.getLastName() + ", " + wantedAddress.getFirstName());
        io.print(wantedAddress.getStreetAddress());
        io.print(wantedAddress.getCity() + ", " + wantedAddress.getState() + " " + wantedAddress.getZipCode());
    }

    public void displayDisplayAllAddressesBanner() {
        io.print("===View All Addresses in the Address Book===");
    }

    public void displayAllAddresses(List<Address> allAddresses) {
        for (Address currentAddress : allAddresses) {
            displayWantedAddress(currentAddress);
            io.print("");
        }
    }

    public void displayEditAddressBanner() {
        io.print("===Edit an Address===");
    }

    public Address getEditedAddressInformation(Address addressToEdit) {
        String lastName = addressToEdit.getLastName();
        String firstName = addressToEdit.getFirstName();
        String updatedStreetAddress = io.readString("New Street Address: ");
        String updatedCity = io.readString("City: ");
        String updatedState = io.readString("State: ");
        String updatedZipCode = io.readString("Zip Code: ");
        Address updatedAddress = new Address(lastName);
        updatedAddress.setFirstName(firstName);
        updatedAddress.setStreetAddress(updatedStreetAddress);
        updatedAddress.setCity(updatedCity);
        updatedAddress.setState(updatedState);
        updatedAddress.setZipCode(updatedZipCode);
        return updatedAddress;
    }

    public void displayExitMessage() {
        io.readString("Exiting Program. Hit enter to leave.");
    }

    public void displayErrorMessage(String message) {
        io.print("===ERROR===");
        io.print(message);
    }
    
    
 
    
    
    
}
