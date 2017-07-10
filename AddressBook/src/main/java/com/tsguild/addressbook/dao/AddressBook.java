/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook.dao;

import com.tsguild.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public interface AddressBook {
    /**
     * Adds an address to the address book. If there is already an address associated with the last name it will return the address object, otherwise it will return null.
     * @param lastName the last name to be associated with the address object
     * @param address address to be added to the address book
     * @return the Address object previously associated with the last name, null otherwise
     * @throws com.tsguild.addressbook.dao.AddressBookException
     */
    Address addAddress(String lastName, Address address)throws AddressBookException;
    /**
     * Removes an address from the address book. Returns the address being removed, or returns null if no address is associated with the given last name.
     * @param lastName the last name associated with the address to be removed
     * @return the address to be removed, or null if no address associated with the last name
     * @throws com.tsguild.addressbook.dao.AddressBookException
     */
    Address removeAddress(String lastName)throws AddressBookException;
    /**
     * Find an address in the address book. Returns the address object associated with the last name provided, or null if no address is associated with the last name given.
     * @param lastName last name associated with the address object to be found
     * @return The address to be looked up, or null if no address associated with last name
     * @throws com.tsguild.addressbook.dao.AddressBookException
     */
    Address findAddress(String lastName)throws AddressBookException;
    
    /**
     * Get the total number of address in the address book. Calculates the amount of addresses in the address book
     * @return integer value of addresses in address book
     * @throws com.tsguild.addressbook.dao.AddressBookException
     */
    int getNumberOfAddresses()throws AddressBookException;
    /**
     * Returns a string array of all last names associated with addresses in the address book. 
     * @return address objects of all last names in the list, null if no such address exists
     * @throws com.tsguild.addressbook.dao.AddressBookException
     */
    List<Address> getAllAddresses()throws AddressBookException;
}
