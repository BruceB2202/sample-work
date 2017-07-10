/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdlibrary.controller;

import com.tsguild.dvdlibrary.dao.DvdLibraryDao;
import com.tsguild.dvdlibrary.dao.DvdLibraryDaoException;
import com.tsguild.dvdlibrary.dto.Dvd;
import com.tsguild.dvdlibrary.view.DvdLibraryView;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bruce_Breslin
 */
public class DvdLibraryController {

    DvdLibraryView view;
    DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int userMenuChoice = 0;

        try {

            while (keepGoing) {
                userMenuChoice = printMenuAndGetUserChoice();

                switch (userMenuChoice) {
                    case 1:
                        viewLibrary();
                        break;
                    case 2:
                        int searchMethodChoice = getHowToSearch();
                        switch(searchMethodChoice){
                            case 1:
                                searchByTitle();
                                break;
                            case 2:
                                searchNewest();
                                break;
                            case 3:
                                searchOldest();
                                break;
                            case 4:
                                searchMoviesInLastXYears();
                                break;
                            case 5:
                                searchByDirector();
                                break;
                            case 6:
                                searchByRating();
                                break;
                            case 7:
                                searchByStudio();
                                break;
                            case 8:
                                break;
                            default:
                                unknownCommand();
                        }
                        break;
                    case 3:
                        addDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        showAvgAgeOfMovies();
                        break;
                    case 6:
                        showAvgNumberOfNotes();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }//ends program and display exit

            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void exitMessage() {
        view.displayExitMessage();
    }

    private int printMenuAndGetUserChoice() {
        int userChoice = view.printMenuAndGetUserChoice();
        return userChoice;
    }

    private void viewLibrary() throws DvdLibraryDaoException {
        List<Dvd> library = dao.getAllDvds();
        view.displayViewLibraryBanner();
        view.displayViewLibrary(library);
        view.displaySuccessBanner();
    }

    private void searchByTitle() throws DvdLibraryDaoException {
        String wantedDvdTitle = view.getDvdTitle();
        Dvd wantedDvd = dao.lookupDvd(wantedDvdTitle);
        view.displayWantedDvd(wantedDvd);
        view.displaySuccessBanner();
    }

    private void addDvd() throws DvdLibraryDaoException {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getDvdDetails();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayWantedDvd(newDvd);
        view.displaySuccessBanner();

    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdToDeleteTitle = view.getDvdTitle();
        dao.removeDvd(dvdToDeleteTitle);
        view.displaySuccessBanner();

    }

    private void unknownCommand() {
        view.displayUnknownCommandMessage();
    }

    private int getHowToSearch() {
        view.displaySearchMenuBanner();
        return view.displaySearchMenuOptionsGetChoice();
    }
    
    private void searchNewest() {
        view.displayNewestMovieBanner();
        List<Dvd> newestMovies = dao.getNewestMovie();
        view.displayNewestMovieList(newestMovies);
        view.displaySuccessBanner();
    }

    private void searchOldest() {
        view.displayOldestMovieBanner();
        List<Dvd> oldestMovies = dao.getOldestMovie();
        view.displayOldestMovieList(oldestMovies);
        view.displaySuccessBanner();
    }

    private void searchMoviesInLastXYears() {
        view.displayFindDvdOfXYearsAgeBanner();
        int yearsToGoBack = view.getHowManyYearsToGoBack();
        List<Dvd> moviesMadeList = dao.getAllDvdsMadeInLastXYears(yearsToGoBack);
        view.displayMoviesMadeList(moviesMadeList);
        view.displaySuccessBanner();
        
    }

    private void searchByDirector() {
        view.displaySearchDirectorBanner();
        String director = view.getDirectorName();
        Map<String, List<Dvd>> moviesList = dao.getAllMoviesByDirectorGroupByRating(director);
        view.displayMoviesMadeByDirector(director, moviesList);
        view.displaySuccessBanner();
    }

    private void searchByRating() {
        view.displaySearchRatingBanner();
        String rating = view.getRatingToSearchBy();
        List<Dvd> movieList = dao.getAllMoviesWithMpaaRating(rating);
        view.displayMoviesMadeWithRatingList(rating, movieList);
        view.displaySuccessBanner();
    }

    private void searchByStudio() {
        view.displaySearchStudioBanner();
        String studio = view.getStudioToSearchBy();
        List<Dvd> movieList = dao.getAllMoviesByStudio(studio);
        view.displayMoviesMadeByStudioList(studio, movieList);
        view.displaySuccessBanner();
    }

    private void showAvgNumberOfNotes() {
        view.displayAvgNumberNotesBanner();
        double avgNotes = dao.getAverageNumberOfNotes();
        view.displayAvgNumberOfNotes(avgNotes);
        view.displaySuccessBanner();
    }

    private void showAvgAgeOfMovies() {
        view.displayAvgAgeBanner();
        double avgAge = dao.getAverageAgeOfMovies();
        view.displayAvgAgeOfMovies(avgAge);
        view.displaySuccessBanner();
    }
}
