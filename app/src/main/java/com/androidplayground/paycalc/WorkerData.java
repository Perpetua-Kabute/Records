package com.androidplayground.paycalc;

public class WorkerData {
    public String name;
    public String category;
    public int amount;
    public int unit;

    public WorkerData(String name, String Category, int unit){
        this.name = name;
        this.category = category;
        this.unit = unit;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        name = name;
    }
    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        category = category;
    }

    public int getUnit(){
        return unit;
    }

    public void setUnit(int unit){
        unit = unit;
    }
}
