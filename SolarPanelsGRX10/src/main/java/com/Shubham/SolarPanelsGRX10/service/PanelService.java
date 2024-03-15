package com.Shubham.SolarPanelsGRX10.service;

import java.util.List;

import com.Shubham.SolarPanelsGRX10.entity.SolarPanelData;
import com.Shubham.SolarPanelsGRX10.model.OutputData;

public interface PanelService {

	SolarPanelData saveSolarPanelData(SolarPanelData data);
    List<SolarPanelData> fetchAllSolarPanelDatas();
    SolarPanelData getSolarPanelDataById(Long id);
    OutputData outputCalc(SolarPanelData data);
}
