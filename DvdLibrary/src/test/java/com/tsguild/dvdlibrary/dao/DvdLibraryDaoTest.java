/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.dvdlibrary.dao;

import com.tsguild.dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruce_Breslin
 */
public class DvdLibraryDaoTest {

    DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

    public DvdLibraryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Dvd> dvdList = dao.getAllDvds();
        for (Dvd dvd : dvdList) {
            dao.removeDvd(dvd.getTitle());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddLookupDvd() throws Exception {
        Dvd dvd = new Dvd("Bad Boys1");
        dvd.setDirectorName("Bruce");
        dvd.setMpaaRating("E");
        LocalDate releaseDate = LocalDate.parse("2010-05-14");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("My Studio");
        List<String> userNotes = new ArrayList();
        userNotes.add("Best Movie Ever");
        dvd.setUserRatingNotes(userNotes);
        dao.addDvd(dvd.getTitle(), dvd);

        Dvd fromDao = dao.lookupDvd(dvd.getTitle());
        assertEquals(dvd, fromDao);
    }

    /**
     * Test of removeDvd method, of class DvdLibraryDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveDvd() throws Exception {
        Dvd dvd = new Dvd("Bad Boys2");
        dvd.setDirectorName("Bruce1");
        dvd.setMpaaRating("E1");
        LocalDate releaseDate = LocalDate.parse("2010-05-14");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("My Studio1");
        List<String> userNotes = new ArrayList();
        userNotes.add("Best Movie Ever1");
        dvd.setUserRatingNotes(userNotes);
        dao.addDvd(dvd.getTitle(), dvd);

        Dvd dvd2 = new Dvd("Happy Gilmore2");
        dvd2.setDirectorName("Tom");
        dvd2.setMpaaRating("R");
        LocalDate releaseDate2 = LocalDate.parse("2015-05-14");
        dvd2.setReleaseDate(releaseDate);
        dvd2.setStudio("Here");
        List<String> userNotes2 = new ArrayList();
        userNotes2.add("Yo");
        dvd2.setUserRatingNotes(userNotes2);
        dao.addDvd(dvd2.getTitle(), dvd2);

        dao.removeDvd(dvd.getTitle());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.lookupDvd(dvd.getTitle()));

        dao.removeDvd(dvd2.getTitle());
        assertEquals(0, dao.getAllDvds().size());
        assertNull(dao.lookupDvd(dvd2.getTitle()));
    }

    /**
     * Test of getAllDvds method, of class DvdLibraryDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetAllDvds() throws Exception {
        Dvd dvd = new Dvd("Bad Boys3");
        dvd.setDirectorName("Bruce");
        dvd.setMpaaRating("E");
        LocalDate releaseDate = LocalDate.parse("2010-05-14");
        dvd.setReleaseDate(releaseDate);
        dvd.setStudio("My Studio");
        List<String> userNotes = new ArrayList();
        userNotes.add("Best Movie Ever");
        dvd.setUserRatingNotes(userNotes);
        dao.addDvd(dvd.getTitle(), dvd);
        assertEquals(1, dao.getAllDvds().size());

        Dvd dvd2 = new Dvd("Happy Gilmore3");
        dvd2.setDirectorName("Bruce");
        dvd2.setMpaaRating("E");
        LocalDate releaseDate2 = LocalDate.parse("2015-05-14");
        dvd2.setReleaseDate(releaseDate2);
        dvd2.setStudio("My Studio");
        List<String> userNotes2 = new ArrayList();
        userNotes2.add("Yo");
        dvd2.setUserRatingNotes(userNotes2);
        dao.addDvd(dvd2.getTitle(), dvd2);
        assertEquals(2, dao.getAllDvds().size());

    }

}
