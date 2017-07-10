    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.addressbook.addressbook;

import com.tsguild.addressbook.controller.AddressBookController;
import com.tsguild.addressbook.dao.AddressBook;
import com.tsguild.addressbook.dao.AddressBookFileImpl;
import com.tsguild.addressbook.ui.AddressBookView;
import com.tsguild.addressbook.ui.UserIO;
import com.tsguild.addressbook.ui.UserIOConsoleImpl;

/**
 *
 * @author Bruce_Breslin
 */
public class App {
    public static void main(String[] args) {
        UserIO myIO = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIO);
        AddressBook myDao = new AddressBookFileImpl();
        AddressBookController controller = new AddressBookController(myView, myDao);
        
        controller.run();
    }
}
