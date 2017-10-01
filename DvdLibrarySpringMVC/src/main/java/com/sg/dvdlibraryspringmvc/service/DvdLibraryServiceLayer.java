/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.service;

import com.sg.dvdlibraryspringmvc.dao.DvdLibraryDao;
import com.sg.dvdlibraryspringmvc.model.Dvd;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bruce_breslin
 */
public class DvdLibraryServiceLayer{
    
    DvdLibraryDao dao;
    @Inject
    public DvdLibraryServiceLayer(DvdLibraryDao dao){
        this.dao = dao;
    }

    public Dvd addDvd(Dvd myDvd) {
        Dvd newDvd = dao.addDvd(myDvd);
        return newDvd;
    }

    public void removeDvd(int dvdId) {
        dao.removeDvd(dvdId);
    }

    public Dvd getDvdById(int dvdId) {
        Dvd wantedDvd = dao.getDvdById(dvdId);
        return wantedDvd;
    }

    public List<Dvd> getDvdByTitle(String title) {
        List<Dvd> dvdList = dao.getDvdByTitle(title);
        return dvdList;
    }

    public List<Dvd> getAllDvds() {
        List<Dvd> dvdList = dao.getAllDvds();
        return dvdList;
    }

    public List<Dvd> getAllDvdsFromYear(int year) {
        List<Dvd> dvdList = dao.getAllDvdsFromYear(year);
        return dvdList;
    }

    public List<Dvd> getAllMoviesWithMpaaRating(String rating) {
        List<Dvd> dvdList = dao.getAllMoviesWithMpaaRating(rating);
        return dvdList;
    }

    public List<Dvd> getAllMoviesByDirectorGroupByRating(String director) {
        List<Dvd> dvdList = dao.getAllMoviesByDirectorGroupByRating(director);
        return dvdList;
    }
    
    public void updateDvd(Dvd dvd){
        dao.updateDvd(dvd);
    }
    
}
