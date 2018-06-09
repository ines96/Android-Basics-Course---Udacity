package com.example.android.bookstoreapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class BookContract {

    /**
     * To prevent someone from accidentally instantiating the contract class,
     * give it an empty constructor.
     */

    private BookContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.android.bookstoreapp";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_BOOKS = "books";


    /**
     * Inner class that defines constant values for the books database table.
     * Each entry in the table represents a single book.
     */
    public static final class BookEntry implements BaseColumns {


        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_BOOKS);

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_BOOKS;

        /* Name of the DB table for books */
        public final static String TABLE_NAME = "books_stock";

        /* Unique ID number for the book (Type is INTEGER) */
        public final static String _ID = BaseColumns._ID;

        /* Book title (Type is TEXT) */
        public final static String COLUMN_BOOK_TITLE = "title";

        /* Book supplier(Type is TEXT) */
        public final static String COLUMN_SUPPLIER_NAME = "supplier";

        /* Book supplier phone(Type is TEXT) */
        public final static String COLUMN_SUPPLIER_PHONE = "phone";

        /* Book quantity (Type is INTEGER) */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /* Book price(Type is DOUBLE) */
        public final static String COLUMN_BOOK_PRICE = "price";

        // SUPPLIER_NAME LIST VALUES
        public final static int SUPPLIER_UNKNOWN = 0;
        public final static int SUPPLIER_BERTRAND = 1;
        public final static int SUPPLIER_LIBRARY = 2;

        public static boolean isValidSupplierName(int suppliername) {
            if (suppliername == SUPPLIER_UNKNOWN || suppliername == SUPPLIER_BERTRAND || suppliername == SUPPLIER_LIBRARY) {
                return true;
            }
            return false;
        }
    }
}
