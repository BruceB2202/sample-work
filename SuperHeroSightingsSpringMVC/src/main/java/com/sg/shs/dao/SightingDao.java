/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 * @author bruce_breslin
 */
public interface SightingDao {
    public void addSighting(Sighting sighting);
    public Sighting getSighting(int sightingId);
    public List<Sighting> getAllSightings();
    public void updateSighting(Sighting sighting);
    public void removeSighting(int sightingId);
    public List<Sighting> getSightingsFromDate(LocalDate date);
    public List<Sighting> getSightingsOfHero(int hvId);
    public List<Sighting> getSightingsAtLocation(int locationId);
}
