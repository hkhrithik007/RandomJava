package com.Song;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
  private String name;
  private String artist;
  private ArrayList<Song> songs;

  public Album(String name, String artist) {
    this.name = name;
    this.artist = artist;
    this.songs = new ArrayList<Song>();
  }

  public Album() {}
  public Song findSong(String title) {
    for (Song song : songs) {
      if (title != null && title.equals(song.getTitle())) {
        return song;
      }
    }
    return null;
  }

  public boolean addSong(String title, double duration) {
    if (findSong(title) == null) {
      this.songs.add(new Song(title, duration));
      // System.out.println(title + "Successfully added to list");
      return true;
    } else {
      System.out.println("Song with this " + title + "name already exist");
      return false;
    }
  }

  public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList) {
    int index = trackNumber - 1;
    if (index >= 0 && index <= this.songs.size()) {
      PlayList.add(this.songs.get(index));
      return true;
    }
    // System.out.println("This is not a valid track number" + trackNumber);
    return false;
  }

  public boolean addToPlayList(String title, LinkedList<Song> PlayList) {
    Song song = findSong(title);
    if (song != null && song.getTitle() != null &&
        song.getTitle().equals(title)) {
      PlayList.add(song);
      return true;
    }
    // System.out.println(title + " not found");
    return false;
  }
}
