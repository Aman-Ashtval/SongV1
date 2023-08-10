package com.example.song;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

public class SongService implements SongRepository{
    private HashMap<Integer, Song> hmap = new HashMap<>();
    private int uniqueSongId = 3;

    SongService(){
        Song song1 = new Song(1,"Tum Hi Ho", "ArijitSing");
        Song song2 = new Song(2,"Yaron ka Sataya", "B-prak");

        hmap.put(song1.getSongId(), song1);
        hmap.put(song2.getSongId(), song2);
    }

    @Override
    public ArrayList<Song> getSongs(){
        Collection<Song> songList = hmap.values();
        return new ArrayList<>(songList);
    }

    @Override
    public Song getSongById(int songId){
        Song song = hmap.get(songId);
        if(song == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return song;
    }

    @Override
    public Song addSong(Song song){
        song.setSongId(this.uniqueSongId);
        hmap.put(uniqueSongId, song);
        uniqueSongId ++;
        return song;
    }

    @Override
    public Song updateSong(int songId, Song song){
        Song existSong = hmap.get(songId);
        if(existSong == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(song.getSongName() != null) existSong.setSongName(song.getSongName());
        if(song.getSinger() != null) existSong.setSinger(song.getSinger());
        return existSong;
    }

    @Override
    public void deleteSong(int songId){
        Song song = hmap.get(songId);
        if(song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            hmap.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}

















