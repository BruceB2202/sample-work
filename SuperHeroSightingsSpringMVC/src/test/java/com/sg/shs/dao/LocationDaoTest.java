/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.Location;
import com.sg.shs.model.Sighting;
import com.sg.shs.service.LocationService;
import com.sg.shs.service.SightingService;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author bruce_breslin
 */
public class LocationDaoTest {
    LocationService locService;
    SightingService sightService;
    
    public LocationDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        sightService = ctx.getBean("sightingService", SightingService.class);
        locService = ctx.getBean("locationService", LocationService.class);
        List<Sighting> sightingList = sightService.getAllSightings();
        for(Sighting s : sightingList){
            sightService.removeSighting(s.getSightingId());
        }
        List<Location> locationList = locService.getAllLocations();
        for(Location loc : locationList){
            locService.removeLocation(loc.getLocationId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addLocation method, of class LocationDaoDbImpl.
     */
    @Test
    public void testAddGetLocation() {
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        Location fromDao = locService.getLocation(loc.getLocationId());
        
        assertEquals(loc, fromDao);
    }

    /**
     * Test of getAllLocations method, of class LocationDaoDbImpl.
     */
    @Test
    public void testGetAllLocations() {
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        
        Location loc2 = new Location();
        loc2.setLocationName("Home2");
        loc2.setLocationDescription("My House2");
        loc2.setLocationAddress("123 my street2");
        loc2.setLocationCity("Canton2");
        loc2.setLocationState("Ohio2");
        loc2.setLocationLatitude(20.992);
        loc2.setLocationLongitude(118.113);
        locService.addLocation(loc2);
        
        List<Location> locList = locService.getAllLocations();
        assertEquals(locList.size(), 2);
    }

    /**
     * Test of updateLocation method, of class LocationDaoDbImpl.
     */
    @Test
    public void testUpdateLocation() {
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        loc.setLocationName("My Home");
        locService.updateLocation(loc);
        Location fromDao = locService.getLocation(loc.getLocationId());
        assertEquals(loc, fromDao);
    }

    /**
     * Test of removeLocation method, of class LocationDaoDbImpl.
     */
    @Test
    public void testRemoveLocation() {
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        assertEquals(locService.getAllLocations().size(), 1);
        locService.removeLocation(loc.getLocationId());
        assertNull(locService.getLocation(loc.getLocationId()));
    }
    
}
