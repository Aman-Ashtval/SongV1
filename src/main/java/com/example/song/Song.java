package com.example.song;

public class Song {
    private int songId;
    private String songName;
    private String singer;

    Song(int songId, String songName, String singer){
        this.songId = songId;
        this.songName = songName;
        this.singer = singer;
    }

    public void setSongId(int songId){
        this.songId = songId;
    }
    public int getSongId(){
        return this.songId;
    }

    public void setSongName(String songName){
        this.songName = songName;
    }
    public String getSongName(){
        return  songName;
    }

    public void setSinger(String singer){
        this.singer = singer;
    }
    public String getSinger(){
        return this.singer;
    }
}
