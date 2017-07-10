/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.statecapitals2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Bruce_Breslin
 */
public class StatesAndCapitalHashMap {

    static Scanner userInput = new Scanner(System.in);

    public void StateMapper() {
        int userPopulation = 0;

        Capital Alabama = new Capital();
        Alabama.setName("Montgomery");
        Alabama.setPopulation(205764);
        Alabama.setSquareMileage(156.19);

        Capital Alaska = new Capital();
        Alaska.setName("Juneau");
        Alaska.setPopulation(31275);
        Alaska.setSquareMileage(2715.7);

        Capital Arizona = new Capital();
        Arizona.setName("Phoenix");
        Arizona.setPopulation(1445632);
        Arizona.setSquareMileage(517.948);

        Capital Arkansas = new Capital();
        Arkansas.setName("Little Rock");
        Arkansas.setPopulation(193524);
        Arkansas.setSquareMileage(116.8);

        Capital California = new Capital();
        California.setName("Sacramento");
        California.setPopulation(466488);
        California.setSquareMileage(100.105);

        Capital Colorado = new Capital();
        Colorado.setName("Denver");
        Colorado.setPopulation(600158);
        Colorado.setSquareMileage(155);

        Capital Connecticut = new Capital();
        Connecticut.setName("Hartford");
        Connecticut.setPopulation(124893);
        Connecticut.setSquareMileage(18);

        Capital Delaware = new Capital();
        Delaware.setName("Dover");
        Delaware.setPopulation(37366);
        Delaware.setSquareMileage(22.7);

        Capital Florida = new Capital();
        Florida.setName("Tallahassee");
        Florida.setPopulation(181376);
        Florida.setSquareMileage(103.5);

        Capital Georgia = new Capital();
        Georgia.setName("Atlanta");
        Georgia.setPopulation(463878);
        Georgia.setSquareMileage(134);

        Capital Hawaii = new Capital();
        Hawaii.setName("Honolulu");
        Hawaii.setPopulation(337256);
        Hawaii.setSquareMileage(68.4);

        Capital Idaho = new Capital();
        Idaho.setName("Boise");
        Idaho.setPopulation(205671);
        Idaho.setSquareMileage(80.05);

        Capital Illinois = new Capital();
        Illinois.setName("Springfield");
        Illinois.setPopulation(117006);
        Illinois.setSquareMileage(65.76);

        Capital Indiana = new Capital();
        Indiana.setName("Indianapolis");
        Indiana.setPopulation(820445);
        Indiana.setSquareMileage(372);

        Capital Iowa = new Capital();
        Iowa.setName("Des Moines");
        Iowa.setPopulation(203433);
        Iowa.setSquareMileage(90.65);

        Capital Kansas = new Capital();
        Kansas.setName("Topeka");
        Kansas.setPopulation(127473);
        Kansas.setSquareMileage(61.47);

        Capital Kentucky = new Capital();
        Kentucky.setName("Frankfort");
        Kentucky.setPopulation(25527);
        Kentucky.setSquareMileage(14.6);

        Capital Louisiana = new Capital();
        Louisiana.setName("Baton Rouge");
        Louisiana.setPopulation(229493);
        Louisiana.setSquareMileage(79.11);

        Capital Maine = new Capital();
        Maine.setName("Augusta");
        Maine.setPopulation(18946);
        Maine.setSquareMileage(58.03);

        Capital Maryland = new Capital();
        Maryland.setName("Annapolis");
        Maryland.setPopulation(38394);
        Maryland.setSquareMileage(20.98);

        Capital Massachusetts = new Capital();
        Massachusetts.setName("Boston");
        Massachusetts.setPopulation(667137);
        Massachusetts.setSquareMileage(89.63);

        Capital Michigan = new Capital();
        Michigan.setName("Lansing");
        Michigan.setPopulation(114297);
        Michigan.setSquareMileage(36.68);

        Capital Minnesota = new Capital();
        Minnesota.setName("Saint Paul");
        Minnesota.setPopulation(285068);
        Minnesota.setSquareMileage(56.18);

        Capital Mississippi = new Capital();
        Mississippi.setName("Jackson");
        Mississippi.setPopulation(173514);
        Mississippi.setSquareMileage(106.8);

        Capital Missouri = new Capital();
        Missouri.setName("Jefferson City");
        Missouri.setPopulation(43079);
        Missouri.setSquareMileage(37.58);

        Capital Montana = new Capital();
        Montana.setName("Helena");
        Montana.setPopulation(28190);
        Montana.setSquareMileage(16.39);

        Capital Nebraska = new Capital();
        Nebraska.setName("Lincoln");
        Nebraska.setPopulation(258379);
        Nebraska.setSquareMileage(92.81);

        Capital Nevada = new Capital();
        Nevada.setName("Carson City");
        Nevada.setPopulation(54522);
        Nevada.setSquareMileage(157);

        Capital NewHampshire = new Capital();
        NewHampshire.setName("Concord");
        NewHampshire.setPopulation(42695);
        NewHampshire.setSquareMileage(67.5);

        Capital NewJersey = new Capital();
        NewJersey.setName("Trenton");
        NewJersey.setPopulation(84913);
        NewJersey.setSquareMileage(8.155);

        Capital NewMexico = new Capital();
        NewMexico.setName("Santa Fe");
        NewMexico.setPopulation(67947);
        NewMexico.setSquareMileage(37.4);

        Capital NewYork = new Capital();
        NewYork.setName("Albany");
        NewYork.setPopulation(98469);
        NewYork.setSquareMileage(21.8);

        Capital NorthCarolina = new Capital();
        NorthCarolina.setName("Raleigh");
        NorthCarolina.setPopulation(538066);
        NorthCarolina.setSquareMileage(144.8);

        Capital NorthDakota = new Capital();
        NorthDakota.setName("Bismark");
        NorthDakota.setPopulation(61272);
        NorthDakota.setSquareMileage(31.23);

        Capital Ohio = new Capital();
        Ohio.setName("Columbus");
        Ohio.setPopulation(787033);
        Ohio.setSquareMileage(223.11);

        Capital Oklahoma = new Capital();
        Oklahoma.setName("Oklahoma City");
        Oklahoma.setPopulation(579999);
        Oklahoma.setSquareMileage(620.34);

        Capital Oregon = new Capital();
        Oregon.setName("Salem");
        Oregon.setPopulation(154637);
        Oregon.setSquareMileage(48.45);

        Capital Pennsylvania = new Capital();
        Pennsylvania.setName("Harrisburg");
        Pennsylvania.setPopulation(49528);
        Pennsylvania.setSquareMileage(11.4);

        Capital RhodeIsland = new Capital();
        RhodeIsland.setName("Providence");
        RhodeIsland.setPopulation(178042);
        RhodeIsland.setSquareMileage(20.6);

        Capital SouthCarolina = new Capital();
        SouthCarolina.setName("Columbia");
        SouthCarolina.setPopulation(129272);
        SouthCarolina.setSquareMileage(134.9);

        Capital SouthDakota = new Capital();
        SouthDakota.setName("Pierre");
        SouthDakota.setPopulation(13646);
        SouthDakota.setSquareMileage(13.07);

        Capital Tennessee = new Capital();
        Tennessee.setName("Nashville");
        Tennessee.setPopulation(678889);
        Tennessee.setSquareMileage(525.94);

        Capital Texas = new Capital();
        Texas.setName("Austin");
        Texas.setPopulation(931830);
        Texas.setSquareMileage(271.8);

        Capital Utah = new Capital();
        Utah.setName("Salt Lake City");
        Utah.setPopulation(186440);
        Utah.setSquareMileage(285.9);

        Capital Vermont = new Capital();
        Vermont.setName("Montpelier");
        Vermont.setPopulation(7855);
        Vermont.setSquareMileage(10.3);

        Capital Virginia = new Capital();
        Virginia.setName("Richmond");
        Virginia.setPopulation(220289);
        Virginia.setSquareMileage(62.5);

        Capital Washington = new Capital();
        Washington.setName("Olympia");
        Washington.setPopulation(46478);
        Washington.setSquareMileage(19.68);

        Capital WestVirginia = new Capital();
        WestVirginia.setName("Charleston");
        WestVirginia.setPopulation(51400);
        WestVirginia.setSquareMileage(32.66);

        Capital Wisconsin = new Capital();
        Wisconsin.setName("Madison");
        Wisconsin.setPopulation(233209);
        Wisconsin.setSquareMileage(94.03);

        Capital Wyoming = new Capital();
        Wyoming.setName("Cheyenne");
        Wyoming.setPopulation(59466);
        Wyoming.setSquareMileage(24.63);

        Map<String, Capital> stateMap = new HashMap<>();

        stateMap.put("Alabama", Alabama);
        stateMap.put("Alaska", Alaska);
        stateMap.put("Arizona", Arizona);
        stateMap.put("Arkansas", Arkansas);
        stateMap.put("California", California);
        stateMap.put("Colorado", Colorado);
        stateMap.put("Connecticut", Connecticut);
        stateMap.put("Delaware", Delaware);
        stateMap.put("Florida", Florida);
        stateMap.put("Georgia", Georgia);
        stateMap.put("Hawaii", Hawaii);
        stateMap.put("Idaho", Idaho);
        stateMap.put("Illinois", Illinois);
        stateMap.put("Indiana", Indiana);
        stateMap.put("Iowa", Iowa);
        stateMap.put("Kansas", Kansas);
        stateMap.put("Kentucky", Kentucky);
        stateMap.put("Louisiana", Louisiana);
        stateMap.put("Maine", Maine);
        stateMap.put("Maryland", Maryland);
        stateMap.put("Massachusetts", Massachusetts);
        stateMap.put("Michigan", Michigan);
        stateMap.put("Minnesota", Minnesota);
        stateMap.put("Mississippi", Mississippi);
        stateMap.put("Missouri", Missouri);
        stateMap.put("Montana", Montana);
        stateMap.put("Nebraska", Nebraska);
        stateMap.put("Nevada", Nevada);
        stateMap.put("New Hampshire", NewHampshire);
        stateMap.put("New Jersey", NewJersey);
        stateMap.put("New Mexico", NewMexico);
        stateMap.put("New York", NewYork);
        stateMap.put("North Carolina", NorthCarolina);
        stateMap.put("North Dakota", NorthDakota);
        stateMap.put("Ohio", Ohio);
        stateMap.put("Oklahoma", Oklahoma);
        stateMap.put("Oregon", Oregon);
        stateMap.put("Pennsylvania", Pennsylvania);
        stateMap.put("Rhode Island", RhodeIsland);
        stateMap.put("South Carolina", SouthCarolina);
        stateMap.put("South Dakota", SouthDakota);
        stateMap.put("Tennessee", Tennessee);
        stateMap.put("Texas", Texas);
        stateMap.put("Utah", Utah);
        stateMap.put("Vermont", Vermont);
        stateMap.put("Virginia", Virginia);
        stateMap.put("Washington", Washington);
        stateMap.put("West Virginia", WestVirginia);
        stateMap.put("Wisconsin", Wisconsin);
        stateMap.put("Wyoming", Wyoming);

        /*Set<String> stateSets = stateMap.keySet();
        Iterator<String> keySetIterator = stateSets.iterator();

        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            Capital capitalValue = stateMap.get(key);
            String capitalName = capitalValue.getName();
            int capitalPop = capitalValue.getPopulation();
            double capitalSqMi = capitalValue.getSquareMileage();

            System.out.println(key + "- " + capitalName + " | Population: " + capitalPop + " | Square Miles: " + capitalSqMi + " sq. miles.");

        }*/
        Iterate myIterator = new Iterate();
        myIterator.setIterator(stateMap, userPopulation);
        userPopulation = getUserPopulation();
        myIterator.setIterator(stateMap, userPopulation);
    }

    private int getUserPopulation() {
        System.out.println("\nPlease enter the minimum capital city population to be displayed: ");
        int userPop = userInput.nextInt();
        return userPop;
    }
}
