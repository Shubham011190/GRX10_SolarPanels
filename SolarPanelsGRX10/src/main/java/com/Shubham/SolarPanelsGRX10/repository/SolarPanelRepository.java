package com.Shubham.SolarPanelsGRX10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shubham.SolarPanelsGRX10.entity.SolarPanelData;

@Repository
public interface SolarPanelRepository extends JpaRepository<SolarPanelData, Long>{

}
