/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author bruce_breslin
 */
public class HeroVillain {
    private int heroVillainId;
    private String heroVillainName;
    private String heroVillainDescription;
    private String heroVillainPower;
    private List<Organization> heroVillainOrganizations;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.heroVillainId;
        hash = 79 * hash + Objects.hashCode(this.heroVillainName);
        hash = 79 * hash + Objects.hashCode(this.heroVillainDescription);
        hash = 79 * hash + Objects.hashCode(this.heroVillainPower);
        hash = 79 * hash + Objects.hashCode(this.heroVillainOrganizations);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HeroVillain other = (HeroVillain) obj;
        if (this.heroVillainId != other.heroVillainId) {
            return false;
        }
        if (!Objects.equals(this.heroVillainName, other.heroVillainName)) {
            return false;
        }
        if (!Objects.equals(this.heroVillainDescription, other.heroVillainDescription)) {
            return false;
        }
        if (!Objects.equals(this.heroVillainPower, other.heroVillainPower)) {
            return false;
        }
        if (!Objects.equals(this.heroVillainOrganizations, other.heroVillainOrganizations)) {
            return false;
        }
        return true;
    }

    public int getHeroVillainId() {
        return heroVillainId;
    }

    public void setHeroVillainId(int heroVillainId) {
        this.heroVillainId = heroVillainId;
    }

    public String getHeroVillainName() {
        return heroVillainName;
    }

    public void setHeroVillainName(String heroVillainName) {
        this.heroVillainName = heroVillainName;
    }

    public String getHeroVillainDescription() {
        return heroVillainDescription;
    }

    public void setHeroVillainDescription(String heroVillainDescription) {
        this.heroVillainDescription = heroVillainDescription;
    }

    public String getHeroVillainPower() {
        return heroVillainPower;
    }

    public void setHeroVillainPower(String heroVillainPower) {
        this.heroVillainPower = heroVillainPower;
    }

    public List<Organization> getHeroVillainOrganizations() {
        return heroVillainOrganizations;
    }

    public void setHeroVillainOrganizations(List<Organization> heroVillainOrganizations) {
        this.heroVillainOrganizations = heroVillainOrganizations;
    }
}
