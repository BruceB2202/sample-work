/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.List;

/**
 *
 * @author Bruce_Breslin
 */
public interface DvdLibraryDao {

    Dvd addDvd(Dvd myDvd);
    
    void updateDvd(Dvd myDvd);

    void removeDvd(int dvdId);
    
    Dvd getDvdById(int dvdId);
    
    List<Dvd> getDvdByTitle(String title);

    List<Dvd> getAllDvds();
    
    List<Dvd> getAllDvdsFromYear(int year);

    List<Dvd> getAllMoviesWithMpaaRating(String rating);

    List<Dvd> getAllMoviesByDirectorGroupByRating(String director);
}
