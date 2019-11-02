package com.nationwide.sixweekproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.sixweekproject.data.DanceData;
import com.nationwide.sixweekproject.repository.DanceRepository;

//my methods for me to perform functions e.g. adding, updating, removing

@Service
public class DanceService {
	
	@Autowired
	private DanceRepository dance;

	public ArrayList<DanceData> findAll(){
		return dance.findAll();
	}
	public ArrayList<DanceData> findByArtist(String artist){
		return dance.findByArtist(artist);
	}
	
	public ArrayList<DanceData> findbySong(String songtitle){
		return dance.findBySongtitle(songtitle);
	}
	
	public String addDance(DanceData ref) {
		dance.save(ref);
		return "Record added!!!! Thanks for contributing!!!";
	}
	public String deleteDance(Integer songsum) {
		DanceData local =dance.findBySongnum(songsum);
		if(local==null) {
			return "Record has not been found - want to check that again????";
		}
		dance.deleteById(songsum);
		return "Record deleted!! Thanks for helping out";
	}
	
	public String Updaterecord(DanceData rdata) {
		dance.saveAndFlush(rdata);
		return "Record Editted";
	}
}