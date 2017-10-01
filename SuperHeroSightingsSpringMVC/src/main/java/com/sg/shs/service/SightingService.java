/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shs.service;

import com.sg.shs.dao.SightingDao;
import com.sg.shs.model.HeroVillain;
import com.sg.shs.model.Location;
import com.sg.shs.model.Sighting;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author bruce_breslin
 */
public class SightingService {

    SightingDao sightDao;
    LocationService locService;
    HeroVillainService hvService;

    @Inject
    SightingService(SightingDao sightDao, LocationService locService, HeroVillainService hvService) {
        this.sightDao = sightDao;
        this.locService = locService;
        this.hvService = hvService;
    }

    public void addSighting(Sighting sighting) {
        sightDao.addSighting(sighting);
    }

    public Sighting getSighting(int sightingId) {
        Sighting wantedSighting = sightDao.getSighting(sightingId);
        if (wantedSighting != null) {
            int trueLocationInt = wantedSighting.getSightingLocation().getLocationId();
            Location trueLocation = locService.getLocation(trueLocationInt);
            int trueHvInt = wantedSighting.getSightingHeroVillain().getHeroVillainId();
            HeroVillain trueHv = hvService.getHeroVillain(trueHvInt);
            wantedSighting.setSightingHeroVillain(trueHv);
            wantedSighting.setSightingLocation(trueLocation);
        }
        return wantedSighting;
    }

    public List<Sighting> getAllSightings() {
        List<Sighting> sightingList = sightDao.getAllSightings();
        for (Sighting wantedSighting : sightingList) {
            int trueLocationInt = wantedSighting.getSightingLocation().getLocationId();
            Location trueLocation = locService.getLocation(trueLocationInt);
            int trueHvInt = wantedSighting.getSightingHeroVillain().getHeroVillainId();
            HeroVillain trueHv = hvService.getHeroVillain(trueHvInt);
            wantedSighting.setSightingHeroVillain(trueHv);
            wantedSighting.setSightingLocation(trueLocation);
            sightingList.set(sightingList.indexOf(wantedSighting), wantedSighting);
        }
        return sightingList;
    }

    public void updateSighting(Sighting sighting) {
        sightDao.updateSighting(sighting);
    }

    public void removeSighting(int sightingId) {
        sightDao.removeSighting(sightingId);
    }

    public List<Sighting> getSightingsFromDate(LocalDate date) {
        List<Sighting> sightingList = sightDao.getSightingsFromDate(date);
        for (Sighting wantedSighting : sightingList) {
            int trueLocationInt = wantedSighting.getSightingLocation().getLocationId();
            Location trueLocation = locService.getLocation(trueLocationInt);
            int trueHvInt = wantedSighting.getSightingHeroVillain().getHeroVillainId();
            HeroVillain trueHv = hvService.getHeroVillain(trueHvInt);
            wantedSighting.setSightingHeroVillain(trueHv);
            wantedSighting.setSightingLocation(trueLocation);
            sightingList.set(sightingList.indexOf(wantedSighting), wantedSighting);
        }
        return sightingList;
    }

    public List<Sighting> getSightingsOfHero(int hvId) {
        List<Sighting> sightingList = sightDao.getSightingsOfHero(hvId);
        for (Sighting wantedSighting : sightingList) {
            int trueLocationInt = wantedSighting.getSightingLocation().getLocationId();
            Location trueLocation = locService.getLocation(trueLocationInt);
            int trueHvInt = wantedSighting.getSightingHeroVillain().getHeroVillainId();
            HeroVillain trueHv = hvService.getHeroVillain(trueHvInt);
            wantedSighting.setSightingHeroVillain(trueHv);
            wantedSighting.setSightingLocation(trueLocation);
            sightingList.set(sightingList.indexOf(wantedSighting), wantedSighting);
        }
        return sightingList;
    }

    public List<Sighting> getSightingsAtLocation(int locationId) {
        List<Sighting> sightingList = sightDao.getSightingsAtLocation(locationId);
        for (Sighting wantedSighting : sightingList) {
            int trueLocationInt = wantedSighting.getSightingLocation().getLocationId();
            Location trueLocation = locService.getLocation(trueLocationInt);
            int trueHvInt = wantedSighting.getSightingHeroVillain().getHeroVillainId();
            HeroVillain trueHv = hvService.getHeroVillain(trueHvInt);
            wantedSighting.setSightingHeroVillain(trueHv);
            wantedSighting.setSightingLocation(trueLocation);
            sightingList.set(sightingList.indexOf(wantedSighting), wantedSighting);
        }
        return sightingList;
    }

}
