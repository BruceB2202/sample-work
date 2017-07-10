/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.flooringmastery;

import brucebreslin.swg.flooringmastery.Controller.FlooringMasteryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Bruce_Breslin
 */
public class FlooringMasteryApp {
    public static void main(String[] args) {
     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringMasteryController controller = ctx.getBean("floorMasteryController", FlooringMasteryController.class);
        controller.run();   
        
        
    }
}
