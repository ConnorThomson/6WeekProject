package com.nationwide.sixweekproject.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//spring.jpa.hibernate.ddl-auto=update - this line will auto update any entities created in my database with the regno. Will also create any entities. 

//data - for any information that will be required to be taken or added to the table. 

@Entity 
@Table(name="rock")
public class RockData {
	@Id
	@GeneratedValue
	private Integer songnum;
	private String songtitle;
	private String artist;
	private String link;
	public Integer getSongnum() {
		return songnum;
	}
	public void setSongnum(Integer songnum) {
		this.songnum = songnum;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSongtitle() {
		return songtitle;
	}
	public void setSongtitle(String songtitle) {
		this.songtitle = songtitle;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
