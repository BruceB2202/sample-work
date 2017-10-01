/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.Organization;
import java.util.List;

/**
 *
 * @author bruce_breslin
 */
public interface OrganizationDao {
    public void addOrganization(Organization organization);
    public Organization getOrganization(int organizationId);
    public List<Organization> getAllOrganizations();
    public void updateOrganization(Organization organization);
    public void removeOrganization(int organizationId);
    public List<Organization> getAllOrganizationsForHero(int heroVillainId);
}
