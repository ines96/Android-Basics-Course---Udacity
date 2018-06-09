package com.example.android.bookstoreapp;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookstoreapp.data.BookContract.BookEntry;

public class BookCursorAdapter extends CursorAdapter {

    private Context mContext;

    public BookCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }


    @Override
    public void bindView(final View view, final Context context, final Cursor cursor) {

        Log.d("Position " + cursor.getPosition() + ":", " bindView() has been called.");

        // Find individual views that we want to modify in the list item layout
        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        TextView priceTextView = (TextView) view.findViewById(R.id.textview_price);
        TextView quantityTextView = (TextView) view.findViewById(R.id.textview_quantity);
        Button productSaleButton = view.findViewById(R.id.sell_button);

        // Find the columns of book attributes that we're interested in
        final int columnIdIndex = cursor.getColumnIndex(BookEntry._ID);
        int titleColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_TITLE);
        int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY);
        int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE);

        // Read the book attributes from the Cursor for the current book
        final String productID = cursor.getString(columnIdIndex);
        String bookTitle = cursor.getString(titleColumnIndex);
        final String bookQuantity = cursor.getString(quantityColumnIndex);
        String bookPrice = cursor.getString(priceColumnIndex);

        productSaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatalogActivity Activity = (CatalogActivity) context;
                Activity.productSaleCount(Integer.valueOf(productID), Integer.valueOf(bookQuantity));
            }
        });

        titleTextView.setText(productID + " ) " + bookTitle);
        quantityTextView.setText(context.getString(R.string.category_price) + " : " + bookPrice + "  " + context.getString(R.string.unit_euro_price));
        priceTextView.setText(context.getString(R.string.category_quantity) + " : " + bookQuantity);

        Button productEditButton = view.findViewById(R.id.edit_button);
        productEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(view.getContext(), EditorActivity.class);
                Uri currentBookUri = ContentUris.withAppendedId(BookEntry.CONTENT_URI, Long.parseLong(productID));
                i.setData(currentBookUri);
                context.startActivity(i);
            }
        });
    }
}