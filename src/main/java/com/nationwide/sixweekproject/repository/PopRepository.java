package com.nationwide.sixweekproject.repository;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nationwide.sixweekproject.data.PopData;

//for "auto-generated" methods done by Springboot

@Repository
public interface PopRepository extends JpaRepository<PopData, Integer> {
	public ArrayList<PopData> findAll();
	public ArrayList<PopData> findByArtist(String artist);
	public ArrayList<PopData> findBySongtitle(String songtitle);
	public PopData findBySongnum (Integer songnum);	
}
