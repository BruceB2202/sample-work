/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook.dao;

import com.tsguild.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class AddressBookFileImpl implements AddressBook{
    public static final String ADDRESS_BOOK_FILE = "addressBook.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Address> addresses = new HashMap<>();
    
    
    

    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookException{
        Address newAddress = addresses.put(lastName, address);
        writeAddressBook();
        return newAddress;
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookException{
        Address removedAddress = addresses.remove(lastName);
        writeAddressBook();
        return removedAddress;
    }

    @Override
    public Address findAddress(String lastName) throws AddressBookException{
        loadAddressBook();
        Address wantedAddress = addresses.get(lastName);
        return wantedAddress;
    }

    @Override
    public int getNumberOfAddresses() throws AddressBookException{
        loadAddressBook();
        int numberOfAddresses = addresses.size();
        return numberOfAddresses;
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookException{
        loadAddressBook();
        return new ArrayList<>(addresses.values());
    }

    private void loadAddressBook() throws AddressBookException{
        Scanner scanner;
        try{
            scanner = new Scanner(new BufferedReader(new FileReader(ADDRESS_BOOK_FILE)));
        }catch(FileNotFoundException e){
            throw new AddressBookException("Address Book File Could Not Be Found!!", e);
        }
        
        String currentLine;
        String[] currentTokens;
        
        while(scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            
            Address currentAddress = new Address(currentTokens[0]);
            currentAddress.setFirstName(currentTokens[1]);
            currentAddress.setStreetAddress(currentTokens[2]);
            currentAddress.setCity(currentTokens[3]);
            currentAddress.setState(currentTokens[4]);
            currentAddress.setZipCode(currentTokens[5]);
            
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        
        scanner.close();
    }

    private void writeAddressBook() throws AddressBookException{
        PrintWriter out;
        
        try{
            out = new PrintWriter(new FileWriter(ADDRESS_BOOK_FILE));
        }catch(IOException e){
            throw new AddressBookException("Could not save address data.", e);
        }
        
        List<Address> addressBook = this.getAllAddresses();
        for(Address currentAddress: addressBook){
            out.println(currentAddress.getLastName() + DELIMITER + currentAddress.getFirstName() + DELIMITER + currentAddress.getStreetAddress() + DELIMITER + currentAddress.getCity() + DELIMITER + currentAddress.getState() + DELIMITER + currentAddress.getZipCode());
            
            out.flush();
        }
        
        out.close();
    }
}