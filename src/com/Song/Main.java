package com.Song;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("SMITHEREENS", "JOJI");
        album.addSong("glimpse os us ", 4.5);
        album.addSong("before the day is over  ", 3.5);
        album.addSong("feeling like the end  ", 5.5);
        albums.add(album);

        album = new Album("Starboy", "weeknd");
        album.addSong("Starboy", 4.5);
        album.addSong("Blinding Lights", 3.5);
        album.addSong("Stuck with U", 5.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("glimpse os us ", playList_1);
        albums.get(0).addToPlayList("die for you ", playList_1);
        albums.get(1).addToPlayList("Starboy", playList_1);
        albums.get(1).addToPlayList("Cruel Summer", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList) {
        try (Scanner sc = new Scanner(System.in)) {
            boolean quit = false;
            boolean forward = true;
            ListIterator<Song> listIterator = playList.listIterator();

            if (playList.size() == 0) {

                System.out.println("No songs in playlist");
            } else {
                System.out.println("Now playing " + listIterator.next().toString());
                System.out.println("Before calling printMenu()");
                printMenu();
                System.out.println("After calling printMenu()");
            }

            // ... (existing code)

            while (!quit) {
                int action = sc.nextInt();
                sc.nextLine();
                switch (action) {
                    case 0:
                        System.out.println("Playlist complete");
                        quit = true;
                        break;

                    case 1:
                        if (forward) {
                            if (listIterator.hasNext()) {
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else {
                            System.out.println("there is no next song");
                        }
                        break;

                    case 2:

                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                            forward = false;
                        }
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " +
                                    listIterator.previous().toString());
                        } else {
                            System.out.println("we are the first song");
                            forward = false;
                        }
                        break;

                    case 3:

                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                System.out.println("Now playing " +
                                        listIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("we are at the start of the list");
                            }
                        } else {
                            if (listIterator.hasNext()) {
                                System.out.println("now playing " +
                                        listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("we have reached to the end of list");
                            }
                        }
                        // ... (existing code)
                        break;

                    case 4:
                        printList(playList);
                        break;

                    case 5:
                        printMenu();
                        break;

                    case 6:
                        // Update the print statement for clarity
                        System.out.println("Deleted current song from playlist");
                        if (playList.size() > 0) {
                            listIterator.remove();
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing " +
                                        listIterator.next().toString());
                            } else {
                                if (listIterator.hasPrevious()) {
                                    System.out.println("Now playing " +
                                            listIterator.previous().toString());
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options:\n"
                + "0 - to quit\n"
                + "1 - to play next song\n"
                + "2 - to play previous song\n"
                + "3 - to replay the current song\n"
                + "4 - list songs in the playlist\n"
                + "5 - to print all the available options\n"
                + "6 - delete current song from playlist\n");
    }

  private static void printList(LinkedList<Song> playList) {
    Iterator<Song> iterator = playList.iterator();
    System.out.println("=========================================");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("=========================================");
  }
