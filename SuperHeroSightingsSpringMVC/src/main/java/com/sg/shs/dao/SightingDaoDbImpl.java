/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.dao;

import com.sg.shs.model.HeroVillain;
import com.sg.shs.model.Location;
import com.sg.shs.model.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bruce_breslin
 */
public class SightingDaoDbImpl implements SightingDao{
    private JdbcTemplate jdbcTemplate;
    @Inject
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public static final String SQL_INSERT_SIGHTING
            = "insert into sighting"
            + "(hero_villain_id, location_id, sighting_date)"
            + "values(?, ?, ?)";
    
    public static final String SQL_UPDATE_SIGHTING
            = "update sighting set "
            + "hero_villain_id = ?, location_id = ?, sighting_date = ? "
            + "where sighting_id = ?";
    
    public static final String SQL_GET_SIGHTING_BY_ID
            = "select * from sighting where sighting_id = ?";
    
    public static final String SQL_GET_ALL_SIGHTINGS
            = "select * from sighting";
    
    public static final String SQL_DELETE_SIGHTING
            = "delete from sighting where sighting_id = ?";
    
    public static final String SQL_GET_ALL_SIGHTINGS_FROM_DATE
            = "select * from sighting where sighting_date = ?";
    
    public static final String SQL_GET_ALL_SIGHTINGS_OF_HERO
            = "select * from sighting where hero_villain_id = ?";
    
    public static final String SQL_GET_ALL_SIGHTINGS_FROM_LOCATION
            = "select * from sighting where location_id = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_INSERT_SIGHTING,
                sighting.getSightingHeroVillain().getHeroVillainId(),
                sighting.getSightingLocation().getLocationId(),
                sighting.getSightingDate().toString());
        sighting.setSightingId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public Sighting getSighting(int sightingId) {
        try{
            return jdbcTemplate.queryForObject(SQL_GET_SIGHTING_BY_ID, new SightingMapper(), sightingId);}catch(EmptyResultDataAccessException ex){
                return null;
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        return jdbcTemplate.query(SQL_GET_ALL_SIGHTINGS, new SightingMapper());
    }

    @Override
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sighting.getSightingHeroVillain().getHeroVillainId(),
                sighting.getSightingLocation().getLocationId(),
                sighting.getSightingDate().toString(),
                sighting.getSightingId());
    }

    @Override
    public void removeSighting(int sightingId) {
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sightingId);
    }

    @Override
    public List<Sighting> getSightingsFromDate(LocalDate date) {
        return jdbcTemplate.query(SQL_GET_ALL_SIGHTINGS_FROM_DATE, new SightingMapper(), date.toString());
    }

    @Override
    public List<Sighting> getSightingsOfHero(int hvId) {
        return jdbcTemplate.query(SQL_GET_ALL_SIGHTINGS_OF_HERO, new SightingMapper(), hvId);
    }

    @Override
    public List<Sighting> getSightingsAtLocation(int locationId) {
        return jdbcTemplate.query(SQL_GET_ALL_SIGHTINGS_FROM_LOCATION, new SightingMapper(), locationId);
    }
    
    private static final class SightingMapper implements RowMapper<Sighting>{
        @Override
        public Sighting mapRow(ResultSet rs, int RowNum) throws SQLException{
            HeroVillain sightingHeroVillain = new HeroVillain();
            sightingHeroVillain.setHeroVillainId(rs.getInt("hero_villain_id"));
            Location sightingLocation = new Location();
            sightingLocation.setLocationId(rs.getInt("location_id"));
            
            Sighting s = new Sighting();
            s.setSightingId(rs.getInt("sighting_id"));
            s.setSightingHeroVillain(sightingHeroVillain);
            s.setSightingLocation(sightingLocation);
            s.setSightingDate(rs.getDate("sighting_date").toLocalDate());
            return s;
        }
    }
}
