/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.controller;

import com.sg.dvdlibraryspringmvc.model.Dvd;
import com.sg.dvdlibraryspringmvc.service.DvdLibraryServiceLayer;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bruce_breslin
 */
@Controller
public class DvdController {
    DvdLibraryServiceLayer service;
    
    @Inject
    public DvdController(DvdLibraryServiceLayer service){
        this.service = service;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayHomePage(Model model){
        List<Dvd> dvdList = service.getAllDvds();
        model.addAttribute("dvdList", dvdList);
        return "index";
    }
    
    @RequestMapping(value = "displayCreateDvdForm", method = RequestMethod.GET)
    public String displayCreateDvdForm(Model model){
        return "createDvdForm";
    }
    
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String displayIndexPage(Model model){
        List<Dvd> dvdList = service.getAllDvds();
        model.addAttribute("dvdList", dvdList);
        return "index";
    }
    
    @RequestMapping(value = "createDvd", method = RequestMethod.POST)
    public String createDvd(HttpServletRequest request, Model model){
        Dvd dvd = new Dvd();
        dvd.setTitle(request.getParameter("dvdTitle"));
        dvd.setReleaseYear(Integer.parseInt(request.getParameter("releaseYear")));
        dvd.setDirectorName(request.getParameter("director"));
        dvd.setMpaaRating(request.getParameter("rating"));
        dvd.setUserNotes(request.getParameter("userNotes"));
        
        service.addDvd(dvd);
        List<Dvd> dvdList = service.getAllDvds();
        model.addAttribute("dvdList", dvdList);
        return "index";
    }
    
    @RequestMapping(value = "deleteDvd", method = RequestMethod.GET)
    public String deleteContacts(HttpServletRequest request){
        String dvdIdString = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdString);
        service.removeDvd(dvdId);
        return "redirect:index";    
    }
    
    @RequestMapping(value = "editDvdDetails", method = RequestMethod.GET)
    public String displayEditDvdForm(HttpServletRequest request, Model model){
        String dvdIdString = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdString);
        Dvd dvd = service.getDvdById(dvdId);
        model.addAttribute("dvd", dvd);
        return "editDvdForm";
    }
    
    @RequestMapping(value = "editDvd", method = RequestMethod.POST)
    public String editDvd(@Valid @ModelAttribute("dvd") Dvd dvd, BindingResult result){
        service.updateDvd(dvd);
        return "redirect:index";
    }
    
    @RequestMapping(value = "displayDvdDetails", method = RequestMethod.GET)
    public String displayDvdDetails(HttpServletRequest request, Model model){
        String dvdIdString = request.getParameter("dvdId");
        int dvdId = Integer.parseInt(dvdIdString);
        Dvd dvd = service.getDvdById(dvdId);
        model.addAttribute("dvd", dvd);
        
        return "dvdDetails";
    }
    
    @RequestMapping(value = "searchDvds", method = RequestMethod.GET)
    public String searchDvds(HttpServletRequest request, Model model){
        String searchCategory = request.getParameter("searchCategory");
        String searchTerm = request.getParameter("searchTerm");
        List<Dvd> dvdList;
        
        if(searchCategory.equalsIgnoreCase("dvd_name")){
            dvdList = service.getDvdByTitle(searchTerm);
        }else if(searchCategory.equalsIgnoreCase("release_date")){
            dvdList = service.getAllDvdsFromYear(Integer.parseInt(searchTerm));
        }else if(searchCategory.equalsIgnoreCase("director_name")){
            dvdList = service.getAllMoviesByDirectorGroupByRating(searchTerm);
        }else {
            dvdList = service.getAllMoviesWithMpaaRating(searchTerm);
        }
        model.addAttribute("dvdList", dvdList);
        return "displaySearchResults";
    }
}