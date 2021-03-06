package admin.com.almoskyadmin.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderLayout;

import admin.com.almoskyadmin.R;
import admin.com.almoskyadmin.activity.AddNewDriverActivity;
import admin.com.almoskyadmin.activity.LoginActivity;
import admin.com.almoskyadmin.adapter.TabsPagerAdapter;
import admin.com.almoskyadmin.utils.AppPrefes;
import admin.com.almoskyadmin.utils.constants.PrefConstants;


public class Settingsfragments extends Fragment {


    private TabLayout tabLayout;
    private SliderLayout sliderLayout;
    private AppPrefes appPrefes;

    public Settingsfragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
       /* tabLayout = view.findViewById(R.id.tabs);
        ViewPager pager = view.findViewById(R.id.pager);
        TabsPagerAdapter adapter = new TabsPagerAdapter(getActivity().getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager); */
       appPrefes=new AppPrefes(getActivity());

       PickupOrdersFragments fg=new PickupOrdersFragments();
       fg.i=0;

        RelativeLayout driver=view.findViewById(R.id.lyt_driver);

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent go=new Intent(getActivity(), AddNewDriverActivity.class);
                startActivity(go);
            }
        });

        RelativeLayout logout=view.findViewById(R.id.lyt_logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                appPrefes.saveData(PrefConstants.email,"");
                appPrefes.saveData(PrefConstants.name, "");
                appPrefes.saveBoolData(PrefConstants.isLogin, false);


                Intent go=new Intent(getActivity(), LoginActivity.class);
                go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(go);


            }
        });





        return view;
    }
}