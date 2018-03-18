package com.example.android.musicplayer;

/**
 * Created by InesL on 2/26/2018.
 */

public class Song {

    /** Song Name */
    private String mSongTitle;

    /** Song Artist */
    private String mSongArtist;

    /** Song Album */
    private String mSongAlbum;

    /**
     * Create a new Song object.
     *
     * @param songTitle is the title of the song.
     * @param songArtist is the song artist.
     * @param songAlbum is the album from where the song is.
     *
     */
    public Song(String songTitle, String songArtist, String songAlbum) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongAlbum = songAlbum;
    }

    /**
     * Get the title of the song.
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the song artist name.
     */
    public String getSongArtist() {
        return mSongArtist;
    }

    /**
     * Get the album where the song belongs.
     */
    public String getSongAlbum() {
        return mSongAlbum;
    }
}


