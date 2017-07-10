/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.statecapitals2;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Bruce_Breslin
 */
public class Iterate {

    public void setIterator(Map map, int minPop) {
        Set<String> stateSets = map.keySet();
        Iterator<String> keySetIterator = stateSets.iterator();

        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            Capital capitalValue = (Capital) map.get(key);
            String capitalName = capitalValue.getName();
            int capitalPop = capitalValue.getPopulation();
            double capitalSqMi = capitalValue.getSquareMileage();

            if (minPop == 0) {
                System.out.println(key + "- " + capitalName + " | Population: " + capitalPop + " | Square Miles: " + capitalSqMi + " sq. miles.\n");
            }else if(minPop <= capitalPop){
                System.out.println(key + "- " + capitalName + " | Population: " + capitalPop + " | Square Miles: " + capitalSqMi + " sq. miles.\n");
            }
        }
    }
}
