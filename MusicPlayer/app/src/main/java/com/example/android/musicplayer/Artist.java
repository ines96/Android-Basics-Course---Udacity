package com.example.android.musicplayer;

/**
 * Created by InesL on 3/10/2018.
 */

public class Artist {

    /** Artist Name */
    private String mArtistName;

    /** Artist Country */
    private String mArtistCountry;

    /** Artist Since */
    private String mArtistSince;

    /**
     * Create a new Artist object.
     *
     * @param artistName is the name of the artist.
     * @param artistCountry is the country from where the artist is.
     * @param artistSince is the year of beginning of career.
     *
     */
    public Artist(String artistName, String artistCountry, String artistSince) {
        mArtistName = artistName;
        mArtistCountry = artistCountry;
        mArtistSince = artistSince;
    }

    /**
     * Get the name of the artist.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the artists country.
     */
    public String getArtistCountry() {
        return mArtistCountry;
    }

    /**
     * Get the year of the artist carreer beginning.
     */
    public String getArtistSince() {
        return mArtistSince;
    }
}
