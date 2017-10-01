/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.HeroVillain;
import com.sg.shs.model.Location;
import com.sg.shs.model.Organization;
import com.sg.shs.model.Sighting;
import com.sg.shs.service.HeroVillainService;
import com.sg.shs.service.LocationService;
import com.sg.shs.service.OrganizationService;
import com.sg.shs.service.SightingService;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class SightingDaoTest {
    SightingService sightService;
    HeroVillainService hvService;
    LocationService locService;
    OrganizationService orgService;
    
    public SightingDaoTest() {
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
        hvService = ctx.getBean("heroVillainService", HeroVillainService.class);
        locService = ctx.getBean("locationService", LocationService.class);
        orgService = ctx.getBean("organizationService", OrganizationService.class);
        
        List<Organization> orgList = orgService.getAllOrganizations();
        for(Organization org : orgList){
            orgService.removeOrganization(org.getOrganizationId());
        }
        List<Sighting> sightingList = sightService.getAllSightings();
        for(Sighting s : sightingList){
            sightService.removeSighting(s.getSightingId());
        }
        List<HeroVillain> hvList = hvService.getAllHeroVillains();
        for(HeroVillain hv : hvList){
            hvService.removeHeroVillain(hv.getHeroVillainId());
        }
        List<Location> locList = locService.getAllLocations();
        for(Location loc : locList){
            locService.removeLocation(loc.getLocationId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addSighting method, of class SightingDao.
     */
    @Test
    public void testAddGetSighting() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        List<Organization> orgList = new ArrayList();
        orgList.add(org);
        
        HeroVillain hv = new HeroVillain();
        hv.setHeroVillainName("testHero");
        hv.setHeroVillainDescription("Test description");
        hv.setHeroVillainOrganizations(orgList);
        hv.setHeroVillainPower("Flight");
        
        hvService.addHeroVillain(hv);
        
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        
        Sighting s = new Sighting();
        s.setSightingHeroVillain(hv);
        s.setSightingLocation(loc);
        s.setSightingDate(LocalDate.of(2017, 9, 25));
        sightService.addSighting(s);
        Sighting fromDao = sightService.getSighting(s.getSightingId());
        assertEquals(s, fromDao);
    }

    /**
     * Test of getAllSightings method, of class SightingDao.
     */
    @Test
    public void testGetAllSightings() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        List<Organization> orgList = new ArrayList();
        orgList.add(org);
        
        HeroVillain hv = new HeroVillain();
        hv.setHeroVillainName("testHero");
        hv.setHeroVillainDescription("Test description");
        hv.setHeroVillainOrganizations(orgList);
        hv.setHeroVillainPower("Flight");
        
        hvService.addHeroVillain(hv);
        
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        
        Sighting s = new Sighting();
        s.setSightingHeroVillain(hv);
        s.setSightingLocation(loc);
        s.setSightingDate(LocalDate.of(2017, 9, 25));
        sightService.addSighting(s);
        
        Organization org2 = new Organization();
        org2.setOrganizationName("test2Org");
        org2.setOrganizationDescription("Hero2 group");
        org2.setOrganizationAddress("123 2org road");
        org2.setOrganizationCity("Goth2am");
        org2.setOrganizationState("New2 York");
        org2.setOrganizationPhone("302-456-7132");
        org2.setOrganizationEmail("test2Org@testmail.com");
        orgService.addOrganization(org2);
        List<Organization> orgList2 = new ArrayList();
        orgList.add(org2);
        
        HeroVillain hv2 = new HeroVillain();
        hv2.setHeroVillainName("testHero2");
        hv2.setHeroVillainDescription("Test descrip2tion");
        hv2.setHeroVillainOrganizations(orgList2);
        hv2.setHeroVillainPower("Fligh2t");
        
        hvService.addHeroVillain(hv2);
        
        Location loc2 = new Location();
        loc2.setLocationName("Home2");
        loc2.setLocationDescription("My House2");
        loc2.setLocationAddress("1232 my street");
        loc2.setLocationCity("Canto2n");
        loc2.setLocationState("Ohio2");
        loc2.setLocationLatitude(23.992);
        loc2.setLocationLongitude(108.113);
        locService.addLocation(loc2);
        
        Sighting s2 = new Sighting();
        s2.setSightingHeroVillain(hv2);
        s2.setSightingLocation(loc2);
        s2.setSightingDate(LocalDate.of(2016, 9, 25));
        sightService.addSighting(s2);
        assertEquals(sightService.getAllSightings().size(), 2);
    }

    /**
     * Test of updateSighting method, of class SightingDao.
     */
    @Test
    public void testUpdateSighting() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        List<Organization> orgList = new ArrayList();
        orgList.add(org);
        
        HeroVillain hv = new HeroVillain();
        hv.setHeroVillainName("testHero");
        hv.setHeroVillainDescription("Test description");
        hv.setHeroVillainOrganizations(orgList);
        hv.setHeroVillainPower("Flight");
        
        hvService.addHeroVillain(hv);
        
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        
        Sighting s = new Sighting();
        s.setSightingHeroVillain(hv);
        s.setSightingLocation(loc);
        s.setSightingDate(LocalDate.of(2017, 9, 25));
        sightService.addSighting(s);
        s.setSightingDate(LocalDate.of(2010, 5, 14));
        sightService.updateSighting(s);
        Sighting fromDao = sightService.getSighting(s.getSightingId());
        assertEquals(s, fromDao);
    }

    /**
     * Test of removeSighting method, of class SightingDao.
     */
    @Test
    public void testRemoveSighting() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        List<Organization> orgList = new ArrayList();
        orgList.add(org);
        
        HeroVillain hv = new HeroVillain();
        hv.setHeroVillainName("testHero");
        hv.setHeroVillainDescription("Test description");
        hv.setHeroVillainOrganizations(orgList);
        hv.setHeroVillainPower("Flight");
        
        hvService.addHeroVillain(hv);
        
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        
        Sighting s = new Sighting();
        s.setSightingHeroVillain(hv);
        s.setSightingLocation(loc);
        s.setSightingDate(LocalDate.of(2017, 9, 25));
        sightService.addSighting(s);
        sightService.removeSighting(s.getSightingId());
        assertNull(sightService.getSighting(s.getSightingId()));
    }

    /**
     * Test of getSightingsFromDate method, of class SightingDao.
     */
    @Test
    public void testGetSightingsFromDate() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        List<Organization> orgList = new ArrayList();
        orgList.add(org);
        
        HeroVillain hv = new HeroVillain();
        hv.setHeroVillainName("testHero");
        hv.setHeroVillainDescription("Test description");
        hv.setHeroVillainOrganizations(orgList);
        hv.setHeroVillainPower("Flight");
        
        hvService.addHeroVillain(hv);
        
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        
        Sighting s = new Sighting();
        s.setSightingHeroVillain(hv);
        s.setSightingLocation(loc);
        s.setSightingDate(LocalDate.of(2017, 9, 25));
        sightService.addSighting(s);
        
        Sighting s2 = new Sighting();
        s2.setSightingHeroVillain(hv);
        s2.setSightingLocation(loc);
        s2.setSightingDate(LocalDate.of(2017, 7, 20));
        sightService.addSighting(s2);
        List<Sighting> sightingList = sightService.getSightingsFromDate(LocalDate.of(2017, 7, 20));
        assertEquals(1, sightingList.size());
    }

    /**
     * Test of getSightingsOfHero method, of class SightingDao.
     */
    @Test
    public void testGetSightingsOfHero() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        List<Organization> orgList = new ArrayList();
        orgList.add(org);
        
        HeroVillain hv = new HeroVillain();
        hv.setHeroVillainName("testHero");
        hv.setHeroVillainDescription("Test description");
        hv.setHeroVillainOrganizations(orgList);
        hv.setHeroVillainPower("Flight");
        
        hvService.addHeroVillain(hv);
        
        Location loc = new Location();
        loc.setLocationName("Home");
        loc.setLocationDescription("My House");
        loc.setLocationAddress("123 my street");
        loc.setLocationCity("Canton");
        loc.setLocationState("Ohio");
        loc.setLocationLatitude(23.992);
        loc.setLocationLongitude(108.113);
        locService.addLocation(loc);
        
        Sighting s = new Sighting();
        s.setSightingHeroVillain(hv);
        s.setSightingLocation(loc);
        s.setSightingDate(LocalDate.of(2017, 9, 25));
        sightService.addSighting(s);
        
        Sighting s2 = new Sighting();
        s2.setSightingHeroVillain(hv);
        s2.setSightingLocation(loc);
        s2.setSightingDate(LocalDate.of(2010, 5, 14));
        sightService.addSighting(s2);
        
        assertEquals(sightService.getSightingsOfHero(hv.getHeroVillainId()).size(), 2);
    }

    /**
     * Test of getSightingsAtLocation method, of class SightingDao.
     */
    @Test
    public void testGetSightingsAtLocation() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        List<Organization> orgList = new ArrayList();
        orgList.add(org);
        
        HeroVillain hv = new HeroVillain();
        hv.setHeroVillainName("testHero");
        hv.setHeroVillainDescription("Test description");
        hv.setHeroVillainOrganizations(orgList);
        hv.setHeroVillainPower("Flight");
        
        hvService.addHeroVillain(hv);
        
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
        loc2.setLocationLatitude(24.992);
        loc2.setLocationLongitude(118.113);
        locService.addLocation(loc2);
        
        Sighting s = new Sighting();
        s.setSightingHeroVillain(hv);
        s.setSightingLocation(loc);
        s.setSightingDate(LocalDate.of(2017, 9, 25));
        sightService.addSighting(s);
        
        Sighting s2 = new Sighting();
        s2.setSightingHeroVillain(hv);
        s2.setSightingLocation(loc2);
        s2.setSightingDate(LocalDate.of(2010, 5, 14));
        sightService.addSighting(s2);
        
        assertEquals(sightService.getSightingsAtLocation(loc.getLocationId()).size(), 1);
    }

}
