package bytedance.example.easy_tiktok.utils;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyFragAdapter extends FragmentPagerAdapter {

    String titleArr[];
    List<Fragment> mFragmentList;

    public MyFragAdapter(FragmentManager fm, List<Fragment> list, String[] titleArr) {
        super(fm);
        this.mFragmentList = list;
        this.titleArr = titleArr;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList != null ? mFragmentList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArr[position];
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
