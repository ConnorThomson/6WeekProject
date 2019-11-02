package com.nationwide.sixweekproject.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nationwide.sixweekproject.data.ClassicalData;
import com.nationwide.sixweekproject.repository.ClassicalRepository;

//my methods for me to perform functions e.g. adding, updating, removing

@Service
public class ClassicalService {
	
	@Autowired
	private ClassicalRepository classical;

	public ArrayList<ClassicalData> findAll(){
		return classical.findAll();
	}
	public ArrayList<ClassicalData> findByArtist(String artist){
		return classical.findByArtist(artist);
	}
	
	public ArrayList<ClassicalData> findbySong(String songtitle){
		return classical.findBySongtitle(songtitle);
	}
	
	public String addClassical(ClassicalData ref) {
		classical.save(ref);
		return "Record added!!!! Thanks for contributing!!!";
	}
	public String deleteClassical(Integer songsum) {
		ClassicalData local =classical.findBySongnum(songsum);
		if(local==null) {
			return "Record has not been found - want to check that again????";
		}
		classical.deleteById(songsum);
		return "Record deleted!! Thanks for helping out";
	}
	
	public String Updaterecord(ClassicalData rdata) {
		classical.saveAndFlush(rdata);
		return "Record Editted";
	}
}