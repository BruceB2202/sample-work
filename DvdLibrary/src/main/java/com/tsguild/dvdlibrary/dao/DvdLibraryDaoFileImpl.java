/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdlibrary.dao;

import com.tsguild.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Bruce_Breslin
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    public static final String LIBRARY_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";
    public static final String LIST_DELIMITER = "^^";

    public void loadDvdLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("Unable to load DVD Library File", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Dvd currentDvd = new Dvd(currentTokens[0]);
            currentDvd.setReleaseDate(LocalDate.parse(currentTokens[1], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setDirectorName(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            if (currentTokens.length < 6) {
                List userNotesList = new ArrayList<>();
                userNotesList.add("");
                currentDvd.setUserRatingNotes(userNotesList);
            } else {
                String userNotesString = currentTokens[5];
                String[] userNoteTokens = userNotesString.split(LIST_DELIMITER);

                currentDvd.setUserRatingNotes(Arrays.asList(userNoteTokens));
            }

            library.put(currentDvd.getTitle(), currentDvd);

        }
        scanner.close();
    }

    public void saveDvdLibrary() throws DvdLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Cannot save file", e);
        }

        List<Dvd> dvdLibrary = this.getAllDvds();

        for (Dvd currentDvd : dvdLibrary) {
            String userNotesStringToSave = "";
            List<String> userNotes = currentDvd.getUserRatingNotes();
            for (int x = 0; x < userNotes.size(); x++) {
                if (x == userNotes.size()-1) {
                    userNotesStringToSave += userNotes.get(x);
                } else {
                    userNotesStringToSave += userNotes.get(x) + LIST_DELIMITER;
                }
            }

            out.println(currentDvd.getTitle() + DELIMITER + currentDvd.getReleaseDate() + DELIMITER + currentDvd.getMpaaRating() + DELIMITER + currentDvd.getDirectorName() + DELIMITER + currentDvd.getStudio() + DELIMITER + userNotesStringToSave);

            out.flush();
        }
        out.close();
    }

    Map<String, Dvd> library = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd myDvd) throws DvdLibraryDaoException {
        Dvd newDvd = library.put(title, myDvd);
        saveDvdLibrary();
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) throws DvdLibraryDaoException {
        Dvd dvdToRemove = library.remove(title);
        saveDvdLibrary();
        return dvdToRemove;
    }

    @Override
    public Dvd lookupDvd(String title) throws DvdLibraryDaoException {
        loadDvdLibrary();
        Dvd wantedDvd = library.get(title);
        return wantedDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadDvdLibrary();
        return new ArrayList<>(library.values());
    }

    @Override
    public List<Dvd> getAllDvdsMadeInLastXYears(int years) {
        return library.values()
                .stream()
                .filter(dvd -> dvd.getAgeOfMovie() <= years)
                .collect(Collectors.toList());

    }

    @Override
    public List<Dvd> getAllMoviesWithMpaaRating(String rating) {
        return library.values()
                .stream()
                .filter(dvd -> dvd.getMpaaRating().equalsIgnoreCase(rating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Dvd>> getAllMoviesByDirectorGroupByRating(String director) {
        return library.values()
                .stream()
                .filter(dvd -> dvd.getDirectorName().equalsIgnoreCase(director))
                .collect(Collectors.groupingBy(Dvd::getMpaaRating));
    }

    @Override
    public List<Dvd> getAllMoviesByStudio(String studio) {
        return library.values()
                .stream()
                .filter(dvd -> dvd.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageAgeOfMovies() {
        return library.values()
                .stream()
                .mapToLong(dvd -> dvd.getAgeOfMovie())
                .average()
                .getAsDouble();
    }

    @Override
    public List<Dvd> getNewestMovie() {
        long newestAge = library.values()
                .stream()
                .mapToLong(dvd -> dvd.getAgeOfMovie())
                .min()
                .getAsLong();

        return library.values()
                .stream()
                .filter(dvd -> dvd.getAgeOfMovie() == newestAge)
                .collect(Collectors.toList());

    }

    @Override
    public List<Dvd> getOldestMovie() {
        long oldestAge = library.values()
                .stream()
                .mapToLong(dvd -> dvd.getAgeOfMovie())
                .max()
                .getAsLong();

        return library.values()
                .stream()
                .filter(dvd -> dvd.getAgeOfMovie() == oldestAge)
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageNumberOfNotes() {
        return library.values()
                .stream()
                .mapToLong(dvd -> dvd.getUserRatingNotes().size())
                .average()
                .getAsDouble();
    }

}
