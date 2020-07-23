package com.androidplayground.paycalc;

public class WorkerInfo {
    public String date;
    public int unit;

    public WorkerInfo(String date, int unit){
        this.date = date;
        this.unit = unit;
    }

    public int getUnit(){
        return unit;
    }

    public void setUnit(int unit){
        unit = unit;
    }

    public String getDate(){
        return date;

    }

    public void setDate(String date){
        date = date;
    }
}
