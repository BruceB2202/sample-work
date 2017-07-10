/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdlibrary.view;

import com.tsguild.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Bruce_Breslin
 */
public class DvdLibraryView {

    UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public void displayExitMessage() {
        io.readString("Your library will be saved. Thank you for using our DVD Library System. Press enter to close.");
    }

    public int printMenuAndGetUserChoice() {
        io.print("Please select from the following options:");
        io.print("  1. View all Dvds in the Library");
        io.print("  2. Search options");
        io.print("  3. Add a new DVD to the library");
        io.print("  4. Remove a DVD from the library");
        io.print("  5. Exit the program");

        int userChoice = io.readInt("What would you like to do?", 1, 5);
        return userChoice;
    }

    public void displayViewLibraryBanner() {
        io.print("===View All DVDs===");
    }

    public void displayViewLibrary(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print(currentDvd.getTitle());
        }
    }

    public void displaySuccessBanner() {
        io.readString("Action performed successfully! Please press <ENTER> to continue.");
    }

    public String getDvdTitle() {
        String wantedTitle = io.readString("What is the title of the DVD you wish to access?  :");
        return wantedTitle;
    }

    public void displayFindDvdBanner() {
        io.print("===Find A DVD===");
    }

    public void displayWantedDvd(Dvd wantedDvd) {
        List<String> userNotes = wantedDvd.getUserRatingNotes();

        io.print("\n");
        io.print("Title: " + wantedDvd.getTitle());
        io.print("Release Date: " + wantedDvd.getReleaseDate());
        io.print("MPAA Rating: " + wantedDvd.getMpaaRating());
        io.print("Director: " + wantedDvd.getDirectorName());
        io.print("Studio: " + wantedDvd.getStudio());
        io.print("User Notes: \n" + userNotes.get(0));
        for (int x = 1; x < userNotes.size(); x++) {
            io.print((String) userNotes.get(x));
        }
    }

    public void displayAddDvdBanner() {
        io.print("===Add A DVD===");
    }

    public Dvd getDvdDetails() {
        boolean wouldLikeToAddNote = true;
        io.print("Please provide the following information for the DVD you wish to add.");
        String title = io.readString("Title:  ");
        String releaseDateString = io.readString("Release Date (MM-DD-YYYY): ");
        LocalDate releaseDate = LocalDate.parse(releaseDateString, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String mpaaRating = io.readString("MPAA Rating: ");
        String directorName = io.readString("Director: ");
        String studio = io.readString("Studio: ");
        Dvd newDvd = new Dvd(title);
        newDvd.setReleaseDate(releaseDate);
        newDvd.setMpaaRating(mpaaRating);
        newDvd.setDirectorName(directorName);
        newDvd.setStudio(studio);
        List<String> myList = new ArrayList<>();

        while (wouldLikeToAddNote) {
            int userChoiceForNote = io.readInt("Would you like to add a review or note for this DVD?\n  1. Yes\n  2. No");
            switch (userChoiceForNote) {
                case 1:
                    String userNote = io.readString("Please input your note and then hit enter: ");
                    myList.add(userNote);
                    break;
                case 2:
                    if (myList.isEmpty()) {
                        myList.add("No notes entered for this movie.");
                    }
                    wouldLikeToAddNote = false;
                    break;
                default:
                    displayUnknownCommandMessage();
                    break;
            }
        }
        newDvd.setUserRatingNotes(myList);
        return newDvd;
    }

    public void displayRemoveDvdBanner() {
        io.print("===Remove A DVD===");
    }

    public void displayUnknownCommandMessage() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String message) {
        io.print("===Error===");
        io.print(message);
    }

    public void displaySearchMenuBanner() {
        io.print("===Search Options===");
    }

    public int displaySearchMenuOptionsGetChoice() {
        io.print("Please select from the following options:");
        io.print("  1. Search by Title");
        io.print("  2. Search for Newest Movie(s)");
        io.print("  3. Search for Oldest Movie(s)");
        io.print("  4. Search for movies newer than __ years old");
        io.print("  5. Search by Director (Sorted by Rating)");
        io.print("  6. Search by Rating");
        io.print("  7. Search by Studio");
        io.print("  8. Back to main menu");

        int userChoice = io.readInt("What would you like to do?", 1, 8);
        return userChoice;
    }

    public void displayNewestMovieBanner() {
        io.print("===Newest Movie(s)===");
    }

    public void displayNewestMovieList(List<Dvd> newestMovies) {
        for (Dvd dvd : newestMovies) {
            io.print(dvd.getTitle());
        }
    }

    public void displayOldestMovieBanner() {
        io.print("===Oldest Movie(s)===");
    }

    public void displayOldestMovieList(List<Dvd> oldestMovies) {
        for (Dvd dvd : oldestMovies) {
            io.print(dvd.getTitle());
        }
    }

    public void displayFindDvdOfXYearsAgeBanner() {
        io.print("===Find Movies Made in the Past X Years===");
    }

    public int getHowManyYearsToGoBack() {
        int userYears = io.readInt("How many years would you like to go back in your movie search?");
        return userYears;
    }

    public void displayMoviesMadeList(List<Dvd> moviesMadeList) {
        for (Dvd dvd : moviesMadeList) {
            io.print(dvd.getTitle());
        }
    }

    public void displaySearchDirectorBanner() {
        io.print("===Search by Director===");
    }

    public String getDirectorName() {
        String wantedDirector = io.readString("Input the name of the director you would like to search for.");
        return wantedDirector;
    }

    public void displaySearchRatingBanner() {
        io.print("===Search by Rating===");
    }

    public String getRatingToSearchBy() {
        String userRating = io.readString("Input the rating you would like to search by.");
        return userRating;
    }

    public void displaySearchStudioBanner() {
        io.print("===Search by Studio===");
    }

    public String getStudioToSearchBy() {
        String userStudio = io.readString("Input the studio you would like to search for.");
        return userStudio;
    }

    public void displayAvgNumberNotesBanner() {
        io.print("===Average Number of Notes===");
    }

    public void displayAvgNumberOfNotes(double avgNotes) {
        io.print("The average number of user notes per Dvd in the current library is: " + avgNotes);
    }

    public void displayAvgAgeBanner() {
        io.print("===Average Age of Dvds===");
    }

    public void displayAvgAgeOfMovies(double avgAge) {
        io.print("The average age of the movies in the current library is: " + avgAge);
    }

    public void displayMoviesMadeByStudioList(String studio, List<Dvd> movieList) {
        io.print("===" + studio.toUpperCase() + "===");
        for (Dvd dvd : movieList) {
            io.print(dvd.getTitle());
        }
    }

    public void displayMoviesMadeWithRatingList(String rating, List<Dvd> movieList) {
        io.print("===" + rating.toUpperCase() + "===");
        for (Dvd dvd : movieList) {
            io.print(dvd.getTitle());
        }
    }

    public void displayMoviesMadeByDirector(String director, Map<String, List<Dvd>> moviesList) {
        io.print("===" + director + "===");
        Set<String> ratings = moviesList.keySet();

        ratings.stream()
                .forEach(rating -> {
                    io.print("======================");
                    io.print("Rating: " + rating);
                    moviesList.get(rating).stream().forEach(dvd -> io.print(dvd.getTitle()));
                });
    }

}
