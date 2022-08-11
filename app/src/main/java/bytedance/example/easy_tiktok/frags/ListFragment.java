package bytedance.example.easy_tiktok.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import bytedance.example.easy_tiktok.R;
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

        secFragList.add(new movieFrag());
        secFragList.add(new tvFrag());
        secFragList.add(new showFrag());

        listlayoutBinding.listVp.setAdapter(new MyFragAdapter(getChildFragmentManager(),secFragList,titles));
        listlayoutBinding.listTab.setupWithViewPager(listlayoutBinding.listVp);
    }
}
