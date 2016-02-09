package com.example.jay.myapplication;

/**
 * Created by JAY on 10/6/2015.
 */
public class Cusines_methods {

    String name = null;
    boolean selected = false;

    public Cusines_methods(String name, boolean selected)
    {
        super();
        // this.code = code;
        this.name = name;
        this.selected = selected;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public boolean isSelected()
    {
        return selected;
    }
    public void setSelected(boolean selected)
    {
        this.selected = selected;
    }
}


