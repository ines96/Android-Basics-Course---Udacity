package com.example.android.pets.data;

import android.provider.BaseColumns;

public final class PetContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {}

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single pet.
     */
    public static final class PetEntry implements BaseColumns {

        /** Name of the DB table for pets */
        public final static String TABLE_NAME = "pets";

        /** Unique ID number for the pet (Type is INTEGER) */
        public final static String _ID = BaseColumns._ID;

        /** Pet name (Type is TEXT) */
        public final static String COLUMN_PET_NAME = "name";

        /** Pet breed (Type is TEXT) */
        public final static String COLUMN_PET_BREED = "breed";

        /**
         * Pet gender (Type is INTEGER)
         *
         * The only possible values are {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         */
        public final static String COLUMN_PET_GENDER = "gender";

        /** Pet weight (Type is INTEGER) */
        public final static String COLUMN_PET_WEIGHT = "weight";

        /** Possible values for the gender of the pet */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;
    }
}
