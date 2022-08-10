package bytedance.example.easy_tiktok.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.databinding.ListlayoutBinding;

public class ListFragment extends Fragment {

    ListlayoutBinding listlayoutBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        listlayoutBinding = DataBindingUtil.inflate(inflater, R.layout.listlayout,container,false);
        return listlayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
