/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.vendingmachine;

import brucebreslin.swg.vendingmachine.VendControl.VendingMachineController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Bruce_Breslin
 */
public class VendingMachineApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        VendingMachineController controller = ctx.getBean("myController", VendingMachineController.class);
        controller.runVendingMachine();
    }
    /*
    UserIO io = new UserIOConsoleImpl();
        VendingMachineView myView = new VendingMachineView(io);
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
        Change myChange = new Change();// I thought that this should be injected in case of other machines that may have the ability to give dollar bills back as change.
        VendingMachineService myService = new VendingMachineServiceImpl(myDao, myChange);
        VendingMachineController myController = new VendingMachineController(myView, myService, myChange);

        myController.runVendingMachine();
    */

}