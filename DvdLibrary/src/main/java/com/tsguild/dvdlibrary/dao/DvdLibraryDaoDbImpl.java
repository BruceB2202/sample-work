/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdlibrary.dao;

import com.tsguild.dvdlibrary.dto.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author bruce_breslin
 */
public class DvdLibraryDaoDbImpl implements DvdLibraryDao{
    
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Dvd addDvd(String title, Dvd myDvd) throws DvdLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd lookupDvd(String title) throws DvdLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getAllDvdsMadeInLastXYears(int years) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getAllMoviesWithMpaaRating(String rating) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, List<Dvd>> getAllMoviesByDirectorGroupByRating(String director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getAllMoviesByStudio(String studio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAverageAgeOfMovies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getNewestMovie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dvd> getOldestMovie() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAverageNumberOfNotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class DvdMapper implements RowMapper<Dvd> {
        
        @Override
        public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException{
            Dvd dvd = new Dvd(rs.getString("dvd_name"));
            dvd.setReleaseDate(rs.getDate("release_date").toLocalDate());
            dvd.setMpaaRating(rs.getString("mpaa_rating"));
            dvd.setDirectorName(rs.getString("director_name"));
            dvd.setStudio(rs.getString("studio_name"));
            return dvd;
        }
    }
    
}
