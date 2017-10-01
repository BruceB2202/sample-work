/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bruce_breslin
 */
public class DvdLibraryDaoDbImpl implements DvdLibraryDao {

    private static final String SQL_INSERT_DVD
            = "insert into dvd"
            + "(dvd_name, release_date, mpaa_rating, director_name, user_notes)"
            + "values (?, ?, ?, ?, ?)";

    private static final String SQL_DELETE_DVD
            = "delete from dvd where dvd_id = ?";

    private static final String SQL_SELECT_DVD
            = "select * from dvd where dvd_id = ?";

    private static final String SQL_UPDATE_DVD
            = "update dvd set "
            + "dvd_name = ?, release_date = ?, mpaa_rating = ?, director_name = ?, "
            + "user_notes = ? where dvd_id = ?";

    private static final String SQL_SELECT_ALL_DVDS
            = "select * from dvd";

    private static final String SQL_SELECT_DVDS_BY_TITLE
            = "select * from dvd where dvd_name = ?";
    
    private static final String SQL_SELECT_DVDS_BY_RELEASE_YEAR
            = "select * from dvd where release_date = ?";
    
    private static final String SQL_SELECT_DVDS_BY_RATING
            = "select * from dvd where mpaa_rating = ?";
    
    private static final String SQL_SELECT_DVDS_BY_DIRECTOR
            = "select * from dvd where director_name = ?";
    
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addDvd(Dvd myDvd) {
        jdbcTemplate.update(SQL_INSERT_DVD,
                myDvd.getTitle(),
                myDvd.getReleaseYear(),
                myDvd.getMpaaRating(),
                myDvd.getDirectorName(),
                myDvd.getUserNotes());
        
        int newID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);
        myDvd.setDvdId(newID);
        return myDvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        jdbcTemplate.update(SQL_DELETE_DVD, dvdId);
    }
    
    @Override
    public Dvd getDvdById(int dvdId){
        try{
        return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), dvdId);
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Dvd> getDvdByTitle(String title) {
        try{
            return jdbcTemplate.query(SQL_SELECT_DVDS_BY_TITLE, new DvdMapper(), title);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Dvd> getAllDvds() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
    }

    @Override
    public List<Dvd> getAllDvdsFromYear(int year) {
        try{
            return jdbcTemplate.query(SQL_SELECT_DVDS_BY_RELEASE_YEAR, new DvdMapper(), year);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Dvd> getAllMoviesWithMpaaRating(String rating) {
        try{
            return jdbcTemplate.query(SQL_SELECT_DVDS_BY_RATING, new DvdMapper(), rating);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Dvd> getAllMoviesByDirectorGroupByRating(String director) {
        try{
            return jdbcTemplate.query(SQL_SELECT_DVDS_BY_DIRECTOR, new DvdMapper(), director);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void updateDvd(Dvd myDvd) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
                myDvd.getTitle(),
                myDvd.getReleaseYear(),
                myDvd.getMpaaRating(),
                myDvd.getDirectorName(),
                myDvd.getUserNotes(),
                myDvd.getDvdId());
    }

    private static final class DvdMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dvd dvd = new Dvd();
            dvd.setDvdId(rs.getInt("dvd_id"));
            dvd.setTitle(rs.getString("dvd_name"));
            dvd.setReleaseYear(rs.getInt("release_date"));
            dvd.setMpaaRating(rs.getString("mpaa_rating"));
            dvd.setDirectorName(rs.getString("director_name"));
            dvd.setUserNotes(rs.getString("user_notes"));
            return dvd;
        }
    }

}
