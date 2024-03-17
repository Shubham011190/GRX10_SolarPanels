package com.Shubham.SolarPanelsGRX10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shubham.SolarPanelsGRX10.entity.SolarPanelData;
import com.Shubham.SolarPanelsGRX10.model.OutputData;
import com.Shubham.SolarPanelsGRX10.repository.SolarPanelRepository;
import com.Shubham.SolarPanelsGRX10.util.PanelConstants;

@Service
public class PanelServiceImpl implements PanelService {
	
	@Autowired
	SolarPanelRepository panelRepository;
	@Override
	public SolarPanelData saveSolarPanelData(SolarPanelData data) {
		// TODO Auto-generated method stub
		return panelRepository.save(data);
	}

	@Override
	public List<SolarPanelData> fetchAllSolarPanelDatas() {
		// TODO Auto-generated method stub
		return panelRepository.findAll();
	}

	@Override
	public SolarPanelData getSolarPanelDataById(Long id) {
		// TODO Auto-generated method stub
		Optional<SolarPanelData> data = panelRepository.findById(id);
		return data.orElse(null);
	}
	
	public OutputData outputCalc(SolarPanelData data) {
		int noOfPanels = (int)Math.ceil(data.getBill()/PanelConstants.PANEL_CONSTANT);
		int areaNeeded = noOfPanels*PanelConstants.PANEL_AREA;
		long capitalNeeded = (long)noOfPanels*PanelConstants.PANEL_COST;
		double breakEvenYears = (capitalNeeded/(data.getBill()*PanelConstants.YEAR_TO_MONTHS));
		double totalVal = PanelConstants.TOTAL_VAL_CONSTANT*data.getBill();
		double next25Earnings = totalVal-capitalNeeded;
		return new OutputData(noOfPanels, areaNeeded, capitalNeeded, breakEvenYears, next25Earnings);
	}
}
