package com.example.android.tourguideapp;

/**
 * Local represents an attraction, restaurant, monument or viewpoint that the user wants visit.
 * It contains resource IDs for the description, business hours, phone number, food type and
 * optional image file for that word.
 */
public class Local {

    /** String resource ID for the description of the location */
    private int mDescriptionId;

    /** String resource ID for the business hours of the attraction/restaurant/museum */
    private int mBusinessHoursId;

    /** String resource ID for the phone number of the restaurant/attraction/museum */
    private int mPhoneNumberId;

    /** String resource ID for the business hours of the restaurant */
    private int mFoodTypeId;

    /** Image resource ID */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this local */
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new Local object.
     *
     * @param descriptionId is the string resource ID for the local description
     * @param businessHoursId is the bussiness hours
     * @param phoneNumberId is the phone number to get info from the local
     * @param imageResourceId is the drawable resource ID for the image associated with the local
     */

    public Local(int descriptionId, int businessHoursId, int phoneNumberId, int imageResourceId) {
        mDescriptionId = descriptionId;
        mBusinessHoursId = businessHoursId;
        mPhoneNumberId = phoneNumberId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Local object.
     *
     * @param descriptionId is the string resource ID for the local description
     * @param foodTypeId is the restaurant food type
     * @param businessHoursId is the bussiness hours
     * @param phoneNumberId is the phone number to get info from the local
     * @param imageResourceId is the drawable resource ID for the image associated with the local
     */
    public Local(int descriptionId, int foodTypeId, int businessHoursId, int phoneNumberId, int imageResourceId) {
        mDescriptionId = descriptionId;
        mFoodTypeId = foodTypeId;
        mBusinessHoursId = businessHoursId;
        mPhoneNumberId = phoneNumberId;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Local object.
     *
     * @param descriptionId
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Local(int descriptionId, int imageResourceId) {
        mDescriptionId = descriptionId;
        mImageResourceId = imageResourceId;
    }


    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getDescriptionId() {
        return mDescriptionId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getPhoneNumberId() {
        return mPhoneNumberId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getFoodTypeId() {
        return mFoodTypeId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getBusinessHoursId() {
        return mBusinessHoursId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
