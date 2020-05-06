/**
 * This is the class which represents video
 * @author Beste Güney Ece Teker
 * @version 1.0
 */
package com.example.momentum_demo;

public class Project { //project will be our model
    //properties
    private String name;
    private boolean isSelected;
    private Video video;

    //constructor
    public Project(String name)
    {
        this.name = name;
        isSelected = false; // at the beginning project is not selected
    }

    //methods
    public void setName(String name) {
        this.name = name;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getName() {
        return name;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
