package com.Song;

public class Song {
  String title;
  Double Duration;

  public Song(String name, Double Duration) {
    this.title = title;
    this.Duration = Duration;
  }

  public Song() {}

  public String getTitle() { return title; }

  public Double getDuration() { return Duration; }

  @Override
  public String toString() {
    return "Song{" + "title=" + title + '\'' + ", Duration=" + Duration + '}';
  }
}
