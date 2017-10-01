/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.HeroVillain;
import com.sg.shs.model.Organization;
import com.sg.shs.model.Sighting;
import com.sg.shs.service.HeroVillainService;
import com.sg.shs.service.OrganizationService;
import com.sg.shs.service.SightingService;
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
public class HeroVillainDaoTest {
    HeroVillainService hvService;
    OrganizationService orgService;
    SightingService sightService;
    
    public HeroVillainDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        
        sightService = ctx.getBean("sightingService", SightingService.class);
        List<Sighting> sightList = sightService.getAllSightings();
        for(Sighting sight : sightList){
            sightService.removeSighting(sight.getSightingId());
        }
        hvService = ctx.getBean("heroVillainService", HeroVillainService.class);
        List<HeroVillain> heroList = hvService.getAllHeroVillains();
        for(HeroVillain hv : heroList){
            hvService.removeHeroVillain(hv.getHeroVillainId());
        }
        orgService = ctx.getBean("organizationService", OrganizationService.class);
        List<Organization> orgList = orgService.getAllOrganizations();
        for(Organization org : orgList){
            orgService.removeOrganization(org.getOrganizationId());
        }
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addHeroVillain method, of class HeroVillainDao.
     */
    @Test
    public void testAddGetHeroVillain() {
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
        HeroVillain fromDao = hvService.getHeroVillain(hv.getHeroVillainId());
        assertEquals(fromDao, hv);
    }
    
    /**
     * Test of getAllHeroVillains method, of class HeroVillainDao.
     */
    @Test
    public void testGetAllHeroVillains() {
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
        assertEquals(hvService.getAllHeroVillains().size(), 1);
        
        HeroVillain hv2 = new HeroVillain();
        hv2.setHeroVillainName("test hero 2");
        hv2.setHeroVillainDescription("description 2");
        hv2.setHeroVillainOrganizations(orgList);
        hv2.setHeroVillainPower("Super Strength");
        hvService.addHeroVillain(hv2);
        assertEquals(hvService.getAllHeroVillains().size(), 2);
        
    }

    /**
     * Test of updateHeroVillain method, of class HeroVillainDao.
     */
    @Test
    public void testUpdateHeroVillain() {
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
        hv.setHeroVillainName("changed name");
        hvService.updateHeroVillain(hv);
        HeroVillain fromDao = hvService.getHeroVillain(hv.getHeroVillainId());
        assertEquals(hv, fromDao);
        
    }

    /**
     * Test of removeHeroVillain method, of class HeroVillainDao.
     */
    @Test
    public void testRemoveHeroVillain() {
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
        HeroVillain fromDao = hvService.getHeroVillain(hv.getHeroVillainId());
        assertEquals(hv, fromDao);
        hvService.removeHeroVillain(hv.getHeroVillainId());
        assertNull(hvService.getHeroVillain(hv.getHeroVillainId()));
    }
}
