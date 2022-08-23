package bytedance.example.easy_tiktok.frags;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.databinding.VideolayoutBinding;

public class VideoFragment extends Fragment {

    VideolayoutBinding videolayoutBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        videolayoutBinding = DataBindingUtil.inflate(inflater, R.layout.videolayout,container,false);
        return videolayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
