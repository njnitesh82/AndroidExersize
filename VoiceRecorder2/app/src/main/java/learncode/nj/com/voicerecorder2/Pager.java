package learncode.nj.com.voicerecorder2;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Pager extends FragmentPagerAdapter {
    List<String> title;
    List<Fragment> frag;

    public Pager(FragmentManager fm) {

        super(fm);
        title=new ArrayList<>();
        frag=new ArrayList<>();
    }

    @Override
    public Fragment getItem(int i) {
        return frag.get(i);
    }

    @Override
    public int getCount() {
        return frag.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    public void addFragment(Fragment fm, String Title){
        frag.add(fm);
        title.add(Title);
    }

}
