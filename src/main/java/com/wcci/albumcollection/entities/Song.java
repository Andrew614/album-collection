package com.wcci.albumcollection.entities;

import java.sql.Time;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	

	@ManyToOne
	private Album album;
	

	@ManyToMany(mappedBy = "songs")
	private Collection<Artist> artists;
	
	private String title;
	private String link;
	private Time time;
	
	
	public Song(String title, String link, Time time) {
		super();
		this.title = title;
		this.link = link;
		this.time = time;
	}
	


	@SuppressWarnings("unused")
	private Song() {
		
	}

	
	public String getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	public Album getAlbum() {
		return album;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public String getLink() {
		return link;
	}

	public Time getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}