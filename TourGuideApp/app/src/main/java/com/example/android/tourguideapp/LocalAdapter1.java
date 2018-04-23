package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link LocalAdapter1} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Local} objects.
 */
public class LocalAdapter1 extends ArrayAdapter<Local>  {

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link LocalAdapter1} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param locals is the list of {@link Local}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public LocalAdapter1(Context context, ArrayList<Local> locals, int colorResourceId) {
        super(context, 0, locals);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_mon, parent, false);
        }

        // Get the {@link Local} object located at this position in the list
        Local currentLocal = getItem(position);

        // Find the TextView in the list_item_res_res.xml layout with the ID title_text_view1.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view1);
        // Get the title description from the currentLocal object and set this text on
        // the title TextView.
        titleTextView.setText(currentLocal.getDescriptionId());

        // Find the TextView in the list_item_res_res.xml layout with the ID phonenumber_text_view1.
        TextView phonenumberTextView = (TextView) listItemView.findViewById(R.id.phonenumber_text_view1);
        // Get the phone number from the currentLocal object and set this text on
        // the phonenumber TextView.
        phonenumberTextView.setText(String.valueOf(currentLocal.getPhoneNumberId()));

        // Find the TextView in the list_item_res_res.xml layout with the ID hours_text_view1.
        TextView hoursTextView = (TextView) listItemView.findViewById(R.id.hours_text_view1);
        // Get the hours from the currentLocal object and set this text on
        // the hours TextView.
        hoursTextView.setText(currentLocal.getBusinessHoursId());

        // Find the ImageView in the list_item_res_res.xml layout with the ID image1.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image1);
        // Check if an image is provided for this word or not
        if (currentLocal.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentLocal.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container1);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}