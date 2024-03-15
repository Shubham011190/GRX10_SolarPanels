package com.Shubham.SolarPanelsGRX10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shubham.SolarPanelsGRX10.entity.SolarPanelData;
import com.Shubham.SolarPanelsGRX10.repository.SolarPanelRepository;

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
}
