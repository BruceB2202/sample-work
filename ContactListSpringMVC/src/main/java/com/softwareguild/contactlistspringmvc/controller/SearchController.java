/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwareguild.contactlistspringmvc.controller;

import com.softwareguild.contactlistspringmvc.dao.ContactListDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author brucebreslin22
 */
@Controller
public class SearchController {
    private ContactListDao dao;
    @Inject
    public SearchController(ContactListDao dao){
        this.dao = dao;
    }
    
    @RequestMapping(value="/displaySearchPage", method = RequestMethod.GET)
    public String displaySearchPage(){
        return "search";
    }
}
