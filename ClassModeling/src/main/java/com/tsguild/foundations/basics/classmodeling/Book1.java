/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.foundations.basics.classmodeling;

/**
 *
 * @author Bruce_Breslin
 */
public class Book1 {
    private String title;
    private Characters[] characterList;
    private Chapters[] storyLine;
    private Events[] plotLine;
    
    
 public void addCharacter(Characters character){
     
 }
 public void addChapter(Chapters chapter){
     
 }
 public void addEvent(Events event){
     
 }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Characters[] getCharacterList() {
        return characterList;
    }

    public void setCharacterList(Characters[] characterList) {
        this.characterList = characterList;
    }

    public Chapters[] getStoryLine() {
        return storyLine;
    }

    public void setStoryLine(Chapters[] storyLine) {
        this.storyLine = storyLine;
    }

    public Events[] getPlotLine() {
        return plotLine;
    }

    public void setPlotLine(Events[] plotLine) {
        this.plotLine = plotLine;
    }
    
    
}
