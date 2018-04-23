package com.example.android.tourguideapp;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * CategoryAdapter is a FragmentPagerAdapter that can provide the layout for
 * each list item based on a data source which is a list of Local objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new CategoryAdapter object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the Fragment that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AttractionFragment();
        } else if (position == 1) {
            return new MonumentFragment();
        } else if (position == 2) {
            return new RestaurantFragment();
        } else {
            return new ViewpointFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_attraction);
        } else if (position == 1) {
            return mContext.getString(R.string.category_monument);
        } else if (position == 2) {
            return mContext.getString(R.string.category_restaurant);
        } else {
            return mContext.getString(R.string.category_viewpoint);
        }
    }
}