/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.Location;
import java.util.List;

/**
 *
 * @author bruce_breslin
 */
public interface LocationDao {
    public void addLocation(Location location);
    public Location getLocation(int locationId);
    public List<Location> getAllLocations();
    public void updateLocation(Location location);
    public void removeLocation(int locationId);
    
}
