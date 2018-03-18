package com.example.android.musicplayer;

/**
 * Created by InesL on 3/10/2018.
 */

public class Album {

    /** Album Title */
    private String mAlbumTitle;

    /** Album Artist */
    private String mArtistName;

    /** Album Year */
    private String mAlbumYear;

    /**
     * Create a new Album object.
     *
     * @param albumTitle is the title of the song.
     * @param artistName is the name of the artists song.
     * @param albumYear is the year of the album release.
     *
     */
    public Album(String albumTitle, String artistName, String albumYear) {
        mAlbumTitle = albumTitle;
        mArtistName = artistName;
        mAlbumYear = albumYear;
    }

    /**
     * Get the title of the album.
     */
    public String getAlbumTitle() {
        return mAlbumTitle;
    }

    /**
     * Get the artist of the album.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the year of the album release.
     */
    public String getAlbumYear() {
        return mAlbumYear;
    }
}
