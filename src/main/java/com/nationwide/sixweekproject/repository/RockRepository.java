package com.nationwide.sixweekproject.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nationwide.sixweekproject.data.RockData;

//for "auto-generated" methods done by Springboot

@Repository
public interface RockRepository extends JpaRepository<RockData, Integer> {
	public ArrayList<RockData> findAll();
	public ArrayList<RockData> findByArtist(String artist);
	public ArrayList<RockData> findBySongtitle(String songtitle);
	public RockData findBySongnum (Integer songnum);	
}
