/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook.dao;

import com.tsguild.addressbook.dto.Address;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruce_Breslin
 */
public class AddressBookTest {

    AddressBook dao = new AddressBookFileImpl();

    public AddressBookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Address> addressList = dao.getAllAddresses();
        for (Address address : addressList) {
            dao.removeAddress(address.getLastName());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBook.
     */
    @Test
    public void testAddFindAddress() throws Exception {
        Address address = new Address("Breslin");
        address.setFirstName("Bruce");
        address.setStreetAddress("216 33rd St NW");
        address.setCity("Canton");
        address.setState("OH");
        address.setZipCode("44709");

        dao.addAddress(address.getLastName(), address);

        Address fromDao = dao.findAddress(address.getLastName());
        assertEquals(address, fromDao);
    }

    /**
     * Test of removeAddress method, of class AddressBook.
     */
    @Test
    public void testRemoveAddress() throws Exception {
        Address address = new Address("Breslin");
        address.setFirstName("Bruce");
        address.setStreetAddress("216 33rd St NW");
        address.setCity("Canton");
        address.setState("OH");
        address.setZipCode("44709");

        dao.addAddress(address.getLastName(), address);

        Address address2 = new Address("Hall");
        address2.setFirstName("Mike");
        address2.setStreetAddress("241 34th St NW");
        address2.setCity("Canton");
        address2.setState("OH");
        address2.setZipCode("44709");

        dao.addAddress(address2.getLastName(), address2);
        
        dao.removeAddress(address.getLastName());
        assertEquals(1, dao.getAllAddresses().size());
        assertNull(dao.findAddress(address.getLastName()));
        
        dao.removeAddress(address2.getLastName());
        assertEquals(0, dao.getAllAddresses().size());
        assertNull(dao.findAddress(address2.getLastName()));
        
        
    }

    /**
     * Test of getNumberOfAddresses method, of class AddressBook.
     */
    @Test
    public void testGetNumberOfAddresses() throws Exception {
        assertEquals(0, dao.getNumberOfAddresses());
        Address address = new Address("Breslin");
        address.setFirstName("Bruce");
        address.setStreetAddress("216 33rd St NW");
        address.setCity("Canton");
        address.setState("OH");
        address.setZipCode("44709");

        dao.addAddress(address.getLastName(), address);

        Address address2 = new Address("Hall");
        address2.setFirstName("Mike");
        address2.setStreetAddress("241 34th St NW");
        address2.setCity("Canton");
        address2.setState("OH");
        address2.setZipCode("44709");

        dao.addAddress(address2.getLastName(), address2);
        assertEquals(2, dao.getNumberOfAddresses());
    }

    /**
     * Test of getAllAddresses method, of class AddressBook.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
        Address address = new Address("Breslin");
        address.setFirstName("Bruce");
        address.setStreetAddress("216 33rd St NW");
        address.setCity("Canton");
        address.setState("OH");
        address.setZipCode("44709");

        dao.addAddress(address.getLastName(), address);

        Address address2 = new Address("Hall");
        address2.setFirstName("Mike");
        address2.setStreetAddress("241 34th St NW");
        address2.setCity("Canton");
        address2.setState("OH");
        address2.setZipCode("44709");

        dao.addAddress(address2.getLastName(), address2);
        
        assertEquals(2, dao.getAllAddresses().size());
    }

}
