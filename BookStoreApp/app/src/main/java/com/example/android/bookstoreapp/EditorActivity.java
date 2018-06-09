package com.example.android.bookstoreapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.bookstoreapp.data.BookContract;
import com.example.android.bookstoreapp.data.BookContract.BookEntry;
import com.example.android.bookstoreapp.data.BookDbHelper;

public class EditorActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int EXISTING_BOOK_LOADER = 0;

    /** Content URI for the existing book(null if it's a new book) */
    private Uri mCurrentBookUri;

    /** EditText field to enter the books' name */
    private EditText mTitleEditText;

    /** EditText field to enter the books' price */
    private EditText mPriceEditText;

    /** EditText field to enter the books' quantities */
    private EditText mQuantityEditText;

    /** Spinner to choose which supplier supplied the book */
    private Spinner mSupplierNameSpinner;

    /** EditText field to enter the books' price */
    private EditText mPhoneEditText;

    private int mBookSupplierName = BookEntry.SUPPLIER_UNKNOWN;


    /** Boolean flag that keeps track of whether the book has been edited (true) or not (false) */
    private boolean mBookHasChanged = false;

    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            mBookHasChanged = true;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Intent intent = getIntent();
        mCurrentBookUri = intent.getData();

        if (mCurrentBookUri == null) {
            setTitle(getString(R.string.editor_activity_title_new_book));
            invalidateOptionsMenu();

        } else {
            setTitle(getString(R.string.editor_activity_title_edit_book));
            getLoaderManager().initLoader(EXISTING_BOOK_LOADER, null, this);
        }

        // Find all relevant views that we will need to read user input from
        mTitleEditText = (EditText) findViewById(R.id.edit_book_title);
        mPriceEditText = (EditText) findViewById(R.id.edit_price);
        mQuantityEditText = (EditText) findViewById(R.id.edit_book_quantity);
        mSupplierNameSpinner = findViewById(R.id.spinner_book_supplier_name);
        mPhoneEditText = findViewById(R.id.edit_phone);

        mTitleEditText.setOnTouchListener(mTouchListener);
        mPriceEditText.setOnTouchListener(mTouchListener);
        mQuantityEditText.setOnTouchListener(mTouchListener);
        mSupplierNameSpinner.setOnTouchListener(mTouchListener);
        mPhoneEditText.setOnTouchListener(mTouchListener);

        setupSpinner();
    }

    private void setupSpinner() {
        ArrayAdapter bookSupplierNameSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.supplier_options_array, android.R.layout.simple_spinner_item);

        bookSupplierNameSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mSupplierNameSpinner.setAdapter(bookSupplierNameSpinnerAdapter);

        mSupplierNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.supplier_bertrand))) {
                        mBookSupplierName = BookEntry.SUPPLIER_BERTRAND;
                    } else if (selection.equals(getString(R.string.supplier_library))) {
                        mBookSupplierName = BookEntry.SUPPLIER_LIBRARY;
                    } else {
                        mBookSupplierName = BookEntry.SUPPLIER_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mBookSupplierName = BookEntry.SUPPLIER_UNKNOWN;
            }
        });
    }

    /**
     * Get user input from editor and save book into database.
     */
    private void saveBook() {
        String titleString = mTitleEditText.getText().toString().trim();
        String quantityString = mQuantityEditText.getText().toString().trim();
        String priceString = mPriceEditText.getText().toString().trim();
        String phoneString = mPhoneEditText.getText().toString().trim();

        if (mCurrentBookUri == null) {
            if (TextUtils.isEmpty(titleString)) {
                Toast.makeText(this, getString(R.string.book_title_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(priceString)) {
                Toast.makeText(this, getString(R.string.book_price_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(quantityString)) {
                Toast.makeText(this, getString(R.string.book_quantity_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (mBookSupplierName == BookEntry.SUPPLIER_UNKNOWN) {
                Toast.makeText(this, getString(R.string.book_supplier_name_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(phoneString)) {
                Toast.makeText(this, getString(R.string.book_supplier_phone_required), Toast.LENGTH_SHORT).show();
                return;
            }


            ContentValues values = new ContentValues();
            values.put(BookEntry.COLUMN_BOOK_TITLE, titleString);
            values.put(BookEntry.COLUMN_BOOK_QUANTITY, quantityString);
            values.put(BookEntry.COLUMN_BOOK_PRICE, priceString);
            values.put(BookEntry.COLUMN_SUPPLIER_NAME, mBookSupplierName);
            values.put(BookEntry.COLUMN_SUPPLIER_PHONE, phoneString);

            Uri newUri = getContentResolver().insert(BookEntry.CONTENT_URI, values);

            if (newUri == null) {
                Toast.makeText(this, getString(R.string.editor_insert_book_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_insert_book_successful),
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {

            if (TextUtils.isEmpty(titleString)) {
                Toast.makeText(this, getString(R.string.book_title_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(priceString)) {
                Toast.makeText(this, getString(R.string.book_price_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(quantityString)) {
                Toast.makeText(this, getString(R.string.book_quantity_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (mBookSupplierName == BookEntry.SUPPLIER_UNKNOWN) {
                Toast.makeText(this, getString(R.string.book_supplier_name_required), Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(phoneString)) {
                Toast.makeText(this, getString(R.string.book_supplier_phone_required), Toast.LENGTH_SHORT).show();
                return;
            }

            ContentValues values = new ContentValues();
            values.put(BookEntry.COLUMN_BOOK_TITLE, titleString);
            values.put(BookEntry.COLUMN_BOOK_QUANTITY, quantityString);
            values.put(BookEntry.COLUMN_BOOK_PRICE, priceString);
            values.put(BookEntry.COLUMN_SUPPLIER_NAME, mBookSupplierName);
            values.put(BookEntry.COLUMN_SUPPLIER_PHONE, phoneString);


            int rowsAffected = getContentResolver().update(mCurrentBookUri, values, null, null);

            if (rowsAffected == 0) {
                Toast.makeText(this, getString(R.string.editor_update_book_failed),
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.editor_update_book_successful),
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                saveBook();
                return true;
            case android.R.id.home:
                if (!mBookHasChanged) {
                    NavUtils.navigateUpFromSameTask(EditorActivity.this);
                    return true;
                }
                DialogInterface.OnClickListener discardButtonClickListener =
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // User clicked "Discard" button, navigate to parent activity.
                                NavUtils.navigateUpFromSameTask(EditorActivity.this);
                            }
                        };

                // Show a dialog that notifies the user they have unsaved changes
                showUnsavedChangesDialog(discardButtonClickListener);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (!mBookHasChanged) {
            super.onBackPressed();
            return;
        }
        DialogInterface.OnClickListener discardButtonClickListener =
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // User clicked "Discard" button, close the current activity.
                        finish();
                    }
                };

        // Show dialog that there are unsaved changes
        showUnsavedChangesDialog(discardButtonClickListener);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_BOOK_TITLE,
                BookEntry.COLUMN_BOOK_QUANTITY,
                BookEntry.COLUMN_BOOK_PRICE,
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
            int titleColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_TITLE);
            int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_QUANTITY);
            int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_BOOK_PRICE);
            int supplierNameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_SUPPLIER_NAME);
            int supplierPhoneColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_SUPPLIER_PHONE);

            // Extract out the value from the Cursor for the given column index
            String currentTitle = cursor.getString(titleColumnIndex);
            float currentPrice = cursor.getFloat(priceColumnIndex);
            int currentQuantity = cursor.getInt(quantityColumnIndex);
            int currentSupplierName = cursor.getInt(supplierNameColumnIndex);
            int currentSupplierPhone = cursor.getInt(supplierPhoneColumnIndex);

            // Update the views on the screen with the values from the database
            mTitleEditText.setText(currentTitle);
            mPriceEditText.setText(Float.toString(currentPrice));
            mQuantityEditText.setText(Integer.toString(currentQuantity));
            mPhoneEditText.setText(Integer.toString(currentSupplierPhone));

            switch (currentSupplierName) {
                case BookEntry.SUPPLIER_BERTRAND:
                    mSupplierNameSpinner.setSelection(1);
                    break;
                case BookEntry.SUPPLIER_LIBRARY:
                    mSupplierNameSpinner.setSelection(2);
                    break;
                default:
                    mSupplierNameSpinner.setSelection(0);
                    break;
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mTitleEditText.setText("");
        mQuantityEditText.setText("");
        mPriceEditText.setText("");
        mPhoneEditText.setText("");
        mSupplierNameSpinner.setSelection(0);
    }

    /**
     * Show a dialog that warns the user there are unsaved changes that will be lost
     * if they continue leaving the editor.
     *
     * @param discardButtonClickListener is the click listener for what to do when
     *                                   the user confirms they want to discard their changes
     */
    private void showUnsavedChangesDialog(DialogInterface.OnClickListener discardButtonClickListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.unsaved_changes_dialog_msg);
        builder.setPositiveButton(R.string.discard, discardButtonClickListener);
        builder.setNegativeButton(R.string.keep_editing, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
