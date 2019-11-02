package com.nationwide.sixweekproject.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nationwide.sixweekproject.data.ClassicalData;

//for "auto-generated" methods done by Springboot

@Repository
public interface ClassicalRepository extends JpaRepository<ClassicalData, Integer> {
	public ArrayList<ClassicalData> findAll();
	public ArrayList<ClassicalData> findByArtist(String artist);
	public ArrayList<ClassicalData> findBySongtitle(String songtitle);
	public ClassicalData findBySongnum (Integer songnum);	
}