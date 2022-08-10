package bytedance.example.easy_tiktok.frags;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.databinding.IndividuallayoutBinding;

public class IndividualFragment extends Fragment {

    IndividuallayoutBinding individuallayoutBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        individuallayoutBinding = DataBindingUtil.inflate(inflater, R.layout.individuallayout,container,false);
        return individuallayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
