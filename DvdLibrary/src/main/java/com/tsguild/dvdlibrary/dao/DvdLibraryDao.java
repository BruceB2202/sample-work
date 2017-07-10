/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdlibrary.dao;

import com.tsguild.dvdlibrary.dto.Dvd;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruce_Breslin
 */
public interface DvdLibraryDao {

    /**
     * Adds the given dvd to the library and associates it with the title given.
     * Returns the Dvd object if the title is associated with one already,
     * returns null otherwise.
     *
     * @param title title of the Dvd object being added
     * @param myDvd dvd object to be associated with the title given
     * @return the given titles Dvd object if it is already associated with one,
     * null otherwise
     * @throws com.tsguild.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd addDvd(String title, Dvd myDvd) throws DvdLibraryDaoException;

    /**
     * Removes the Dvd object associated with the given title. Returns the dvd
     * object if one is available, null otherwise
     *
     * @param title title associated with the dvd object to be deleted
     * @return the dvd object associated with the title if available, null
     * otherwise
     * @throws com.tsguild.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd removeDvd(String title) throws DvdLibraryDaoException;

    /**
     * Retrieves the dvd object associated with the given title. Returns the dvd
     * object associated with the given title if one exists, null otherwise.
     *
     * @param title the title associated with the dvd object to be retrieved
     * @return the dvd object associated with the given title, null otherwise
     * @throws com.tsguild.dvdlibrary.dao.DvdLibraryDaoException
     */
    Dvd lookupDvd(String title) throws DvdLibraryDaoException;

    /**
     * Gets a list of all dvds in the library.
     *
     * @return all dvd objects in the library
     * @throws com.tsguild.dvdlibrary.dao.DvdLibraryDaoException
     */
    List<Dvd> getAllDvds() throws DvdLibraryDaoException;
    
    
    
    List<Dvd> getAllDvdsMadeInLastXYears(int years);
    
    
    List<Dvd> getAllMoviesWithMpaaRating(String rating);
    
    
    Map<String, List<Dvd>> getAllMoviesByDirectorGroupByRating(String director);
    
    
    List<Dvd> getAllMoviesByStudio(String studio);
    
    
    double getAverageAgeOfMovies();
    
    
    List<Dvd> getNewestMovie();
    
    
    List<Dvd> getOldestMovie();
    
    
    double getAverageNumberOfNotes();
    
    
    
}
