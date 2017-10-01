/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.service;
import com.sg.shs.dao.OrganizationDao;
import com.sg.shs.model.Organization;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bruce_breslin
 */
public class OrganizationService{
    OrganizationDao orgDao;
    @Inject
    OrganizationService(OrganizationDao orgDao){
        this.orgDao = orgDao;
    }

    public void addOrganization(Organization organization) {
        orgDao.addOrganization(organization);
    }

    public Organization getOrganization(int organizationId) {
        return orgDao.getOrganization(organizationId);
    }

    public List<Organization> getAllOrganizations() {
        return orgDao.getAllOrganizations();
    }

    public void updateOrganization(Organization organization) {
        orgDao.updateOrganization(organization);
    }

    public void removeOrganization(int organizationId) {
        orgDao.removeOrganization(organizationId);
    }

    public List<Organization> getAllOrganizationsForHero(int heroVillainId) {
        return orgDao.getAllOrganizationsForHero(heroVillainId);
    }
    
}
