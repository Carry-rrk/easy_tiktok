package bytedance.example.easy_tiktok.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.databinding.MovielayoutBinding;

public class movieFrag extends Fragment {

    MovielayoutBinding movielayoutBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        movielayoutBinding = DataBindingUtil.inflate(inflater, R.layout.movielayout,container,false);
        return movielayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
