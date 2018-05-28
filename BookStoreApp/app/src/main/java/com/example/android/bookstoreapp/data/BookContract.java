package com.example.android.bookstoreapp.data;

import android.provider.BaseColumns;

public final class BookContract {

    /**
     * To prevent someone from accidentally instantiating the contract class,
     * give it an empty constructor.
     */

    private BookContract() {
    }

    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single book.
     */
    public static final class BookEntry implements BaseColumns {

        /* Name of the DB table for books */
        public final static String TABLE_NAME = "books";

        /* Unique ID number for the book (Type is INTEGER) */
        public final static String _ID = BaseColumns._ID;

        /* Book title (Type is TEXT) */
        public final static String COLUMN_BOOK_TITLE = "title";

        /* Book supplier name(Type is TEXT) */
        public final static String COLUMN_SUPPLIER_NAME = "supplier_name";

        /* Book supplier contact(Type is TEXT) */
        public final static String COLUMN_SUPPLIER_CONTACT = "supplier_contact";

        /* Book quantity (Type is INTEGER) */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /* Book price(Type is DOUBLE) */
        public final static String COLUMN_BOOK_PRICE = "price";
    }
}
