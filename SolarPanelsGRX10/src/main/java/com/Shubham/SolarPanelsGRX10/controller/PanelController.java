package com.Shubham.SolarPanelsGRX10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Shubham.SolarPanelsGRX10.entity.SolarPanelData;
import com.Shubham.SolarPanelsGRX10.model.OutputData;
import com.Shubham.SolarPanelsGRX10.service.PanelService;
import com.Shubham.SolarPanelsGRX10.service.PanelServiceImpl;

@RestController
@RequestMapping("/grx10/api")
public class PanelController {
	
	@Autowired
	PanelService panelService;
	
	@PostMapping("/postData")
	public OutputData calcData(@RequestBody SolarPanelData data) {
		System.out.println("Data input in DB Completed!");
		panelService.saveSolarPanelData(data);
		return panelService.outputCalc(data);
	}
	
	@GetMapping("/getAll")
	public List<SolarPanelData> getAllData(){
		return panelService.fetchAllSolarPanelDatas();
	}
	
}
