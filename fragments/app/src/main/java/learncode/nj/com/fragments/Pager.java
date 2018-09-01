package learncode.nj.com.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Pager extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    public Pager(FragmentManager fm) {
        super(fm);
        fragmentList=new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    public void addFragmment(Fragment f){
        fragmentList.add(f);
    }
}
