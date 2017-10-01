/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author bruce_breslin
 */
public class Sighting {
    private int sightingId;
    private HeroVillain sightingHeroVillain;
    private Location sightingLocation;
    private LocalDate sightingDate;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.sightingId;
        hash = 41 * hash + Objects.hashCode(this.sightingHeroVillain);
        hash = 41 * hash + Objects.hashCode(this.sightingLocation);
        hash = 41 * hash + Objects.hashCode(this.sightingDate);
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
        final Sighting other = (Sighting) obj;
        if (this.sightingId != other.sightingId) {
            return false;
        }
        if (!Objects.equals(this.sightingHeroVillain, other.sightingHeroVillain)) {
            return false;
        }
        if (!Objects.equals(this.sightingLocation, other.sightingLocation)) {
            return false;
        }
        if (!Objects.equals(this.sightingDate, other.sightingDate)) {
            return false;
        }
        return true;
    }

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public HeroVillain getSightingHeroVillain() {
        return sightingHeroVillain;
    }

    public void setSightingHeroVillain(HeroVillain sightingHeroVillain) {
        this.sightingHeroVillain = sightingHeroVillain;
    }

    public Location getSightingLocation() {
        return sightingLocation;
    }

    public void setSightingLocation(Location sightingLocation) {
        this.sightingLocation = sightingLocation;
    }

    public LocalDate getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(LocalDate sightingDate) {
        this.sightingDate = sightingDate;
    }

   

   
}
