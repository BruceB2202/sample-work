/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.Organization;
import com.sg.shs.service.OrganizationService;
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
public class OrganizationDaoTest {
    OrganizationService orgService;
    
    public OrganizationDaoTest() {
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
     * Test of addOrganization method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testAddGetOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        Organization fromDao = orgService.getOrganization(org.getOrganizationId());
        assertEquals(org, fromDao);
    }

    /**
     * Test of getAllOrganizations method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testGetAllOrganizations() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        
        Organization org2 = new Organization();
        org2.setOrganizationName("testOrg2");
        org2.setOrganizationDescription("Hero group2");
        org2.setOrganizationAddress("123 org road2");
        org2.setOrganizationCity("Gotham2");
        org2.setOrganizationState("New York2");
        org2.setOrganizationPhone("330-456-7232");
        org2.setOrganizationEmail("testOrg2@testmail.com");
        orgService.addOrganization(org2);
        
        assertEquals(orgService.getAllOrganizations().size(), 2);
    }

    /**
     * Test of updateOrganization method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testUpdateOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        org.setOrganizationName("Test Organization");
        orgService.updateOrganization(org);
        Organization fromDao = orgService.getOrganization(org.getOrganizationId());
        assertEquals(org, fromDao);
    }

    /**
     * Test of removeOrganization method, of class OrganizationDaoDbImpl.
     */
    @Test
    public void testRemoveOrganization() {
        Organization org = new Organization();
        org.setOrganizationName("testOrg");
        org.setOrganizationDescription("Hero group");
        org.setOrganizationAddress("123 org road");
        org.setOrganizationCity("Gotham");
        org.setOrganizationState("New York");
        org.setOrganizationPhone("330-456-7132");
        org.setOrganizationEmail("testOrg@testmail.com");
        orgService.addOrganization(org);
        orgService.removeOrganization(org.getOrganizationId());
        assertNull(orgService.getOrganization(org.getOrganizationId()));
    }
    
}
