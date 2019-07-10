package com.wcci.albumcollection.entities;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany(mappedBy = "albums")
	private Collection<Artist> artists;
	

	@OneToMany(mappedBy = "album")
	private Collection<Song> songs;
	
	private String title;
	private String imageUrl;
	private String recordLabel;
	

	public Album(String title, String imageUrl, Collection<Song> songs, String recordLabel) {
		super();
		this.title = title;
		this.imageUrl = imageUrl;
		this.recordLabel = recordLabel;
	}
	
	public Album() {
		
	}

	public Long getId() {
		return id;
	}

	public Collection<Artist> getArtists() {
		return artists;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getRecordLabel() {
		return recordLabel;
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
		Album other = (Album) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}