package com.example.demo.spatial;
import com.example.demo.report.ReportRepository;
import com.example.demo.report.Report;
import com.example.demo.report.ReportRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SpatialService {
    @Autowired
    private ReportRepository reportRepository;
   private static final double GRID_SIZE = 0.01; /*encapsulating the GRID_SIZE using private so that no other class can use or modify it. it is an internal detail that is none of their business anyway
  this is a class-level configuration; an instance variable that can be used throughout the class across all instances */
    public String computeCellId(double latitude, double longitude){

        int latCell= (int)Math.floor(latitude/GRID_SIZE);
        int lngCell= (int)Math.floor(longitude/GRID_SIZE);
        return latCell+":"+lngCell; //ignoret the comment it is old this is just a stub, a temporary placeholder implementation for the return statement so that java doesn't complain

    }
    public void processReport(double latitude, double longitude, int severity) {
        if (latitude < 28.40 || latitude > 28.55) throw new IllegalArgumentException("Invalid coordinates");;
        if (longitude < 76.95 || longitude > 77.10) throw new IllegalArgumentException("Invalid coordinates");;
        if (severity < 0 || severity > 9) throw new IllegalArgumentException("Invalid coordinates");;
        String level;
        if (severity <= 3) level = "LOW";
        else if (severity <= 6) level = "MEDIUM";
        else level = "HIGH";
        String cellId = computeCellId(latitude,longitude);
        Report report = new Report();
        report.setLatitude(latitude);
        report.setLongitude(longitude);
        report.setSeverity(severity);
        report.setLevel(level);
        report.setCellId(cellId);

        reportRepository.save(report);
        System.out.println("Saved to DB "+ cellId + " | Level: "+ level);
    }
}
