package com.example.demo.report;
import com.example.demo.spatial.SpatialService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin
@RestController  /*short form for @Controller + @ResponseBody
this means that this class handles http requests, but the return values are
automatically converted to JSON
*/
public class ReportController {
    private final ReportRepository reportRepository;
    private SpatialService spatialService;
    public ReportController(SpatialService spatialService, ReportRepository reportRepository) {
        this.spatialService = spatialService;
        this.reportRepository = reportRepository;
    }
    @PostMapping("/reports")
    public void createReport(@RequestBody ReportRequest request){
     // double lat=  request.getLatitude();
     // double lng = request.getLongitude();
   //   String cellId = spatialService.computeCellId(lat,lng);
      spatialService.processReport(request.getLatitude(),request.getLongitude(),request.getSeverity());
      //return cellId;
    //  System.out.println(cellId);
    }
   /* public void addReport(@RequestBody ReportRequest request){
        spatialService.processReport(request.getLatitude(),request.getLongitude(),request.getSeverity());
    }*/
   // ReportRepository reportRepository;
    @GetMapping("/reports")
    public List<Report>getreports(){
        return reportRepository.findAll();
    }
}
