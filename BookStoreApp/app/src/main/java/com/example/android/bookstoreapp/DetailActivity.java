package com.example.android.bookstoreapp;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.bookstoreapp.data.BookContract.BookEntry;

public class DetailActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXISTING_BOOK_LOADER = 0;
    private Uri mCurrentBookUri;

    private TextView mBookTitleTextView;
    private TextView mBookPriceTextView;
    private TextView mBookQuantityTextView;
    private TextView mBookSupplierSpinner;
    private TextView mBookSupplierPhoneTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mBookTitleTextView = findViewById(R.id.book_title_view);
        mBookPriceTextView = findViewById(R.id.book_price_view);
        mBookQuantityTextView = findViewById(R.id.book_quantity_view);
        mBookSupplierSpinner = findViewById(R.id.book_supplier_name_view);
        mBookSupplierPhoneTextView = findViewById(R.id.book_supplier_phone_view);

        Intent intent = getIntent();
        mCurrentBookUri = intent.getData();
        if (mCurrentBookUri == null) {
            invalidateOptionsMenu();
        } else {
            getLoaderManager().initLoader(EXISTING_BOOK_LOADER, null, this);
        }

        Log.d("message", "onCreate ViewActivity");

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_BOOK_TITLE,
                BookEntry.COLUMN_BOOK_PRICE,
                BookEntry.COLUMN_BOOK_QUANTITY,
                BookEntry.COLUMN_SUPPLIER_NAME,
                BookEntry.COLUMN_SUPPLIER_PHONE };

        return new CursorLoader(this,
                mCurrentBookUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() < 1) {
            return;
        }
        if (cursor.moveToFirst()) {

            final int idColumnIndex = cursor.getColumnIndex(BookEntry._ID);
            int titleColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_TITLE);
            int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY);
            int supplierNameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_SUPPLIER_NAME);
            int supplierPhoneColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_SUPPLIER_PHONE);

            String currentName = cursor.getString(titleColumnIndex);
            final int currentPrice = cursor.getInt(priceColumnIndex);
            final int currentQuantity = cursor.getInt(quantityColumnIndex);
            int currentSupplierName = cursor.getInt(supplierNameColumnIndex);
            final int currentSupplierPhone = cursor.getInt(supplierPhoneColumnIndex);

            mBookTitleTextView.setText(currentName);
            mBookPriceTextView.setText(Integer.toString(currentPrice));
            mBookQuantityTextView.setText(Integer.toString(currentQuantity));
            mBookSupplierPhoneTextView.setText(Integer.toString(currentSupplierPhone));


            switch (currentSupplierName) {
                case BookEntry.SUPPLIER_BERTRAND:
                    mBookSupplierSpinner.setText(getText(R.string.supplier_bertrand));
                    break;
                case BookEntry.SUPPLIER_LIBRARY:
                    mBookSupplierSpinner.setText(getText(R.string.supplier_library));
                    break;
                default:
                    mBookSupplierSpinner.setText(getText(R.string.supplier_unknown));
                    break;
            }

            Button productDecreaseButton = findViewById(R.id.decrease_button);
            productDecreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decreaseCount(idColumnIndex, currentQuantity);
                }
            });

            Button productIncreaseButton = findViewById(R.id.increase_button);
            productIncreaseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increaseCount(idColumnIndex, currentQuantity);
                }
            });

            Button productDeleteButton = findViewById(R.id.delete_button);
            productDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDeleteConfirmationDialog();
                }
            });

            Button phoneButton = findViewById(R.id.phone_button);
            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phone = String.valueOf(currentSupplierPhone);
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                    startActivity(intent);
                }
            });

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public void decreaseCount(int productID, int productQuantity) {
        productQuantity = productQuantity - 1;
        if (productQuantity >= 0) {
            updateProduct(productQuantity);
            Toast.makeText(this, getString(R.string.quantity_btns_changed_msg), Toast.LENGTH_SHORT).show();

            Log.d("Log msg", " - productID " + productID + " - quantity " + productQuantity + " , decreaseCount has been called.");
        } else {
            Toast.makeText(this, getString(R.string.quantity_btns_outofstock_msg), Toast.LENGTH_SHORT).show();
        }
    }

    public void increaseCount(int productID, int productQuantity) {
        productQuantity = productQuantity + 1;
        if (productQuantity >= 0) {
            updateProduct(productQuantity);
            Toast.makeText(this, getString(R.string.quantity_btns_changed_msg), Toast.LENGTH_SHORT).show();

            Log.d("Log msg", " - productID " + productID + " - quantity " + productQuantity + " , decreaseCount has been called.");
        }
    }


    private void updateProduct(int productQuantity) {
        Log.d("message", "updateProduct at ViewActivity");

        if (mCurrentBookUri == null) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put(BookEntry.COLUMN_BOOK_QUANTITY, productQuantity);

        if (mCurrentBookUri == null) {
            Uri newUri = getContentResolver().insert(BookEntry.CONTENT_URI, values);
            if (newUri == null) {
                Toast.makeText(this, getString(R.string.editor_insert_book_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_insert_book_successful),
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            int rowsAffected = getContentResolver().update(mCurrentBookUri, values, null, null);
            if (rowsAffected == 0) {
                Toast.makeText(this, getString(R.string.editor_update_book_successful),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_update_book_failed),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void deleteProduct() {
        if (mCurrentBookUri != null) {
            int rowsDeleted = getContentResolver().delete(mCurrentBookUri, null, null);
            if (rowsDeleted == 0) {
                Toast.makeText(this, getString(R.string.editor_delete_book_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_delete_book_successful),
                        Toast.LENGTH_SHORT).show();
            }
        }
        finish();
    }

    private void showDeleteConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_dialog_msg);
        builder.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                deleteProduct();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
