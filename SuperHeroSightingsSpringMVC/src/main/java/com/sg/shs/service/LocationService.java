/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.service;

import com.sg.shs.dao.LocationDao;
import com.sg.shs.model.Location;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bruce_breslin
 */
public class LocationService{
    LocationDao locDao;
    @Inject
    LocationService(LocationDao locDao){
        this.locDao = locDao;
    }

    public void addLocation(Location location) {
        locDao.addLocation(location);
    }

    public Location getLocation(int locationId) {
        return locDao.getLocation(locationId);
    }

    public List<Location> getAllLocations() {
        return locDao.getAllLocations();
    }

    public void updateLocation(Location location) {
        locDao.updateLocation(location);
    }

    public void removeLocation(int locationId) {
        locDao.removeLocation(locationId);
    }
    
}
