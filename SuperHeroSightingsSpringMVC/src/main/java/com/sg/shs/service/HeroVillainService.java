/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.service;

import com.sg.shs.dao.HeroVillainDao;
import com.sg.shs.model.HeroVillain;
import com.sg.shs.model.Organization;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bruce_breslin
 */
public class HeroVillainService{
    
    private HeroVillainDao hvDao;
    private OrganizationService orgService;
    @Inject
    public void setHeroVillainDao(HeroVillainDao hvDao){
        this.hvDao = hvDao;
    }
    @Inject
    public void setOrganizationService(OrganizationService orgService){
        this.orgService = orgService;
    }

    public void addHeroVillain(HeroVillain heroVillain) {
        hvDao.addHeroVillain(heroVillain);
    }

    public HeroVillain getHeroVillain(int hvId) {
        HeroVillain hv = hvDao.getHeroVillain(hvId);
        if(hv != null){
            hv.setHeroVillainOrganizations(addOrgsToHv(hv));}
        return hv;
    }

    public List<HeroVillain> getAllHeroVillains() {
        return hvDao.getAllHeroVillains();
    }

    public void updateHeroVillain(HeroVillain heroVillain) {
        hvDao.updateHeroVillain(heroVillain);
    }

    public void removeHeroVillain(int hvId) {
        hvDao.removeHeroVillain(hvId);
    }

    public List<HeroVillain> getAllMembersOfOrg(int orgId) {
        return hvDao.getAllMembersOfOrg(orgId);
    }
    
    private List<Organization> addOrgsToHv(HeroVillain hV) {
        return orgService.getAllOrganizationsForHero(hV.getHeroVillainId());
    }
    
}
