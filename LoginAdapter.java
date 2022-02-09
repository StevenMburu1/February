package com.example.february;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;
    int TotalTabs;

    public LoginAdapter(FragmentManager fm, Context context, int TotalTabs) {
        super(fm);
        this.context=context;
        this.TotalTabs=TotalTabs;
    }

    @Override
    public int getCount() {
        return TotalTabs;
    }

    public Fragment getItem(int position){
        switch (position){
            case 0:
            LoginTabFragment loginTabFragment= new LoginTabFragment();
            return loginTabFragment;

            case 1:
                SignupTabFragment signupTabFragment=new SignupTabFragment();
                return signupTabFragment;
            default:
                return null;

        }

    }
}
