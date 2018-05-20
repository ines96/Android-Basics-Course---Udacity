package com.example.android.newsapps1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of articles by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /* URL for article data from the Guardian API */
    //private static final String GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?q=portugal&api-key=513f2f9d-fc27-4c3d-8890-963b94a88c79&show-tags=contributor";

    /* Page URL */
    String mURL ;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url
     */

    public NewsLoader(Context context, String url) {
        super(context);
        this.mURL = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mURL == null) {
            return null;
        }

        List<News> newsList = QueryUtils.fetchArticleData(mURL);
        return newsList;
    }
}