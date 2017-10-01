/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.Location;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bruce_breslin
 */
public class LocationDaoDbImpl implements LocationDao{
    private JdbcTemplate jdbcTemplate;
    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public static final String SQL_INSERT_LOCATION
            = "insert into location"
            + "(location_name, location_description, location_address, location_city, "
            + "location_state, location_latitude, location_longitude)"
            + "values(?, ?, ?, ?, ?, ?, ?)";
    
    public static final String SQL_DELETE_LOCATION
            = "delete from location where location_id = ?";
    
    public static final String SQL_UPDATE_LOCATION
            = "update location set "
            + "location_name = ?, location_description = ?, location_address = ?, "
            + "location_city = ?, location_state = ?, location_latitude = ?, "
            + "location_longitude = ? where location_id = ?";
    
    public static final String SQL_GET_LOCATION
            = "select * from location where location_id = ?";
    
    public static final String SQL_GET_ALL_LOCATIONS
            = "select * from location";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationCity(),
                location.getLocationState(),
                location.getLocationLatitude(),
                location.getLocationLongitude());
        location.setLocationId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public Location getLocation(int locationId) {
        try{
            return jdbcTemplate.queryForObject(SQL_GET_LOCATION, new LocationMapper(), locationId);
        }catch (DataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query(SQL_GET_ALL_LOCATIONS, new LocationMapper());
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getLocationName(),
                location.getLocationDescription(),
                location.getLocationAddress(),
                location.getLocationCity(),
                location.getLocationState(),
                location.getLocationLatitude(),
                location.getLocationLongitude(),
                location.getLocationId());
    }

    @Override
    public void removeLocation(int locationId) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationId);
    }
    
    private static final class LocationMapper implements RowMapper<Location>{
        @Override
        public Location mapRow(ResultSet rs, int RowNum) throws SQLException{
            Location l = new Location();
            l.setLocationId(rs.getInt("location_id"));
            l.setLocationName(rs.getString("location_name"));
            l.setLocationDescription(rs.getString("location_description"));
            l.setLocationAddress(rs.getString("location_address"));
            l.setLocationCity(rs.getString("location_city"));
            l.setLocationState(rs.getString("location_state"));
            l.setLocationLatitude(rs.getDouble("location_latitude"));
            l.setLocationLongitude(rs.getDouble("location_longitude"));
            return l;
        }
    }
}
