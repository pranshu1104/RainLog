package com.example.demo.report;

import org.springframework.web.bind.annotation.RequestBody;

public class ReportRequest {
    private double latitude;
    private double longitude;
    private int severity;
    private String level;
    private String cellId;
    public double getLatitude(){
        return latitude;
    }
    public double getLongitude(){
        return longitude;
    }
    public int getSeverity(){
        return severity;
    }
    public void setLatitude(double latitude){
        this.latitude=latitude;
    }
    public void setLongitude(double longitude){
        this.longitude=longitude;
    }
    public void setSeverity(int severity){
        this.severity=severity;
    }
    public String getLevel(){return level;}
    public String getCellId(){return cellId;}
    public  void setCellId(String cellId){this.cellId=cellId;}
    public void setLevel(String level){this.level=level;}

}
