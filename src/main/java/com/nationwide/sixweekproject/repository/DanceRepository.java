package com.nationwide.sixweekproject.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nationwide.sixweekproject.data.DanceData;

//for "auto-generated" methods done by Springboot

@Repository
public interface DanceRepository extends JpaRepository<DanceData, Integer> {
	public ArrayList<DanceData> findAll();
	public ArrayList<DanceData> findByArtist(String artist);
	public ArrayList<DanceData> findBySongtitle(String songtitle);
	public DanceData findBySongnum (Integer songnum);	
}