package com.example.android.newsapps1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of earthquakes, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_activity_list, parent, false);
        }

        // Find the article at the given position in the list of articles.
        News currentArticle = getItem(position);

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.news_title);
        String title = currentArticle.getTitle();
        // Display the article title of the current article in that TextView
        titleView.setText(title);

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section_name);
        String section = currentArticle.getSection();
        // Display the article section of the current article in that TextView
        sectionView.setText(section);

        // Find the TextView with view ID publish date
        TextView publishView = (TextView) listItemView.findViewById(R.id.date_publish);
        String date = currentArticle.getPublishDate();
        // Display the article publish date of the current article in that TextView
        publishView.setText(date);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}

