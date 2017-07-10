/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brucebreslin.swg.section4unittestlab;

/**
 *
 * @author Bruce_Breslin
 */
public class AlarmClock {
    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    //
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
    public String alarmClock(int day, boolean vacation) {
        String alarm = null;
        String off = "Off";
        String seven = "7:00";
        String ten = "10:00";
        
        if(vacation){
            switch(day){
                case 0:
                case 6:
                    alarm = off;
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    alarm = ten;
                    break;
            }
        }else if(!vacation){
            switch(day){
                case 0:
                case 6:
                    alarm = ten;
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    alarm = seven; 
                    break;
            }
        }
        return alarm;
    }
}
