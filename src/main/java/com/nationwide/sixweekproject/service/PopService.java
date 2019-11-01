package com.nationwide.sixweekproject.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.sixweekproject.data.PopData;
import com.nationwide.sixweekproject.repository.PopRepository;

//my methods for me to perform functions e.g. adding, updating, removing

@Service
public class PopService {
	
	@Autowired
	private PopRepository pop;

	public ArrayList<PopData> findAll(){
		return pop.findAll();
	}
	public ArrayList<PopData> findByArtist(String artist){
		return pop.findByArtist(artist);
	}
	
	public ArrayList<PopData> findbySong(String songtitle){
		return pop.findBySongtitle(songtitle);
	}
	
	public String addPop(PopData ref) {
		pop.save(ref);
		return "Record added!!!! Thanks for contributing!!!";
	}
	public String deletePop(Integer songsum) {
		PopData local =pop.findBySongnum(songsum);
		if(local==null) {
			return "Record has not been found - want to check that again????";
		}
		pop.deleteById(songsum);
		return "Record deleted!! Thanks for helping out";
	}
	
	public String Updaterecord(PopData rdata) {
		pop.saveAndFlush(rdata);
		return "Record Editted";
	}
}
