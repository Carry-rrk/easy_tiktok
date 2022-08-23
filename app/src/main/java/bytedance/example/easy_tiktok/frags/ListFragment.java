package bytedance.example.easy_tiktok.frags;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.bean.MovieItem;
import bytedance.example.easy_tiktok.databinding.ListlayoutBinding;
import bytedance.example.easy_tiktok.utils.MyFragAdapter;

public class ListFragment extends Fragment {

    ListlayoutBinding listlayoutBinding;

    String[] titles = {"电影","电视剧","综艺"};
    List<Fragment> secFragList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        listlayoutBinding = DataBindingUtil.inflate(inflater, R.layout.listlayout,container,false);
        return listlayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listlayoutBinding.setLifecycleOwner(this);

        secFragList.add(new movieFrag(getData(1)));
        secFragList.add(new tvFrag(getData(2)));
        secFragList.add(new showFrag(getData(3)));

        listlayoutBinding.listVp.setAdapter(new MyFragAdapter(getChildFragmentManager(),secFragList,titles));
        listlayoutBinding.listTab.setupWithViewPager(listlayoutBinding.listVp);
    }

    private List<MovieItem> getData(int type) {
        List<MovieItem> list = new ArrayList<>();
        movie_internet mi = new movie_internet();
        mi.init("awtpi7iykd02xini","bd48ef702cfa7aef1f11d3ae7974e96c");
        ArrayList<MovieItem>  mit = mi.get_movielist(type);
        for(int i =0;i< mit.size();i++) {
            list.add(mit.get(i));
        }
        return list;
    }
}
