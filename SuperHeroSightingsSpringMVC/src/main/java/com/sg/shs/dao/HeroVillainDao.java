/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.HeroVillain;
import java.util.List;

/**
 *
 * @author bruce_breslin
 */
public interface HeroVillainDao {
    public void addHeroVillain(HeroVillain heroVillain);
    public HeroVillain getHeroVillain(int hvId);
    public List<HeroVillain> getAllHeroVillains();
    public void updateHeroVillain(HeroVillain heroVillain);
    public void removeHeroVillain(int hvId);
    public List<HeroVillain> getAllMembersOfOrg(int orgId);
}
