package admin.com.almoskyadmin.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import admin.com.almoskyadmin.fragments.ActionOrdersFragments;
import admin.com.almoskyadmin.fragments.CompletedOrdersFragments;
import admin.com.almoskyadmin.fragments.DeliveredOrdersFragments;
import admin.com.almoskyadmin.fragments.InProgressOrdersFragments;
import admin.com.almoskyadmin.fragments.PickupOrdersFragments;

public class SimpleFragmentPagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PickupOrdersFragments();
        } else if (position == 1){

            return new ActionOrdersFragments();

        } else if (position == 2){
            return new InProgressOrdersFragments();
        } else if (position == 3){
            return new CompletedOrdersFragments();
        }else {
            return new DeliveredOrdersFragments();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 5;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "Pickup";
            case 1:
                return "Action";
            case 2:
                return "Progress";
            case 3:
                return "Completed";
            case 4:
                return "Delivered";
            default:
                return null;
        }
    }

}