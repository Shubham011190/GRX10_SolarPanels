package com.Shubham.SolarPanelsGRX10.service;

import java.util.ArrayList;
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
		List<SolarPanelData> listData = panelRepository.findAll();
		return listData;
	}

	@Override
	public SolarPanelData getSolarPanelDataById(Long id) {
		// TODO Auto-generated method stub
		Optional<SolarPanelData> data = panelRepository.findById(id);
		if(data.isPresent()) {
			return data.get();
		}
		return null;
	}
	
	public OutputData outputCalc(SolarPanelData data) {
		int noOfPanels = (int)Math.ceil(data.getBill()/420);
		int areaNeeded = noOfPanels*2;
		long capitalNeeded = (long)(noOfPanels/2.0)*60000;
		double breakEvenYears = (capitalNeeded/(data.getBill()*12));
		double totalVal = 25*12*data.getBill();
		double next25Earnings = totalVal-capitalNeeded;
		return new OutputData(noOfPanels, areaNeeded, capitalNeeded, breakEvenYears, next25Earnings);
	}
}
