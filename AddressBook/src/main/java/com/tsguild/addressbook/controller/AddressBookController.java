/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook.controller;

import com.tsguild.addressbook.dao.AddressBook;
import com.tsguild.addressbook.dao.AddressBookException;
import com.tsguild.addressbook.dto.Address;
import com.tsguild.addressbook.ui.AddressBookView;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public class AddressBookController {

    AddressBookView view;
    AddressBook dao;
    
    public AddressBookController(AddressBookView view, AddressBook dao){
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuChoice;
       try{ 
            while (keepGoing) {

                menuChoice = getMenuChoice();

                switch (menuChoice) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        removeAddress();
                        break;
                    case 3:
                        findAddress();
                        break;
                    case 4:
                        displayNumberOfAddresses();
                        break;
                    case 5:
                        displayAllAddresses();
                        break;
                    case 6:
                        editAnAddress();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            
        }
            exitMessage();
    }catch(AddressBookException e){
        view.displayErrorMessage(e.getMessage());
    }
    }

    private int getMenuChoice() {
        int userMenuChoice = view.printMenuGetUserChoice();
        return userMenuChoice;
    }

    private void unknownCommand() {
        view.displayUnknownCommandMessage();
    }

    private void addAddress() throws AddressBookException {
        view.displayAddAddressBanner();
        Address currentAddress = view.getNewAddressDetails();
        dao.addAddress(currentAddress.getLastName(), currentAddress);
        view.displaySuccessBanner();
    }

    private void removeAddress() throws AddressBookException {
        view.displayRemoveAddressBanner();
        String lastNameToRemove;
        lastNameToRemove = view.getLastName();
        dao.removeAddress(lastNameToRemove);
        view.displaySuccessBanner();
    }

    private void findAddress() throws AddressBookException {
        view.displayFindAddressBanner();
        String wantedAddressLastName = view.getLastName();
        Address wantedAddress = dao.findAddress(wantedAddressLastName);
        view.displayWantedAddress(wantedAddress);
        view.displaySuccessBanner();
    }

    private void displayNumberOfAddresses() throws AddressBookException {
        view.displayDisplayNumberOfAddressesBanner();
        int numberOfAddresses = dao.getNumberOfAddresses();
        view.displayNumberOfAddressesMessage(numberOfAddresses);
        view.displaySuccessBanner();
    }

    private void displayAllAddresses() throws AddressBookException {
        view.displayDisplayAllAddressesBanner();
        List<Address> allAddresses = dao.getAllAddresses();
        view.displayAllAddresses(allAddresses);
        view.displaySuccessBanner();
    }

    private void editAnAddress() throws AddressBookException {
        view.displayEditAddressBanner();
        String nameOfAddressToEdit = view.getLastName();
        Address addressToEdit = dao.findAddress(nameOfAddressToEdit);
        Address updatedAddress = view.getEditedAddressInformation(addressToEdit);
        dao.addAddress(updatedAddress.getLastName(), updatedAddress);
        view.displaySuccessBanner();
    }

    private void exitMessage() {
        view.displayExitMessage();
    }
}
