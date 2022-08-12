package bytedance.example.easy_tiktok.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.bean.MovieItem;
import bytedance.example.easy_tiktok.bean.ShowItem;
import bytedance.example.easy_tiktok.databinding.MovielayoutBinding;
import bytedance.example.easy_tiktok.databinding.ShowlayoutBinding;
import bytedance.example.easy_tiktok.utils.MovieAdapter;
import bytedance.example.easy_tiktok.utils.ShowAdapter;

public class showFrag extends Fragment {

    ShowlayoutBinding showlayoutBinding;
    List<ShowItem> showEvents = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        showlayoutBinding = DataBindingUtil.inflate(inflater, R.layout.showlayout,container,false);
        return showlayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        showEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));

        showlayoutBinding.showRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        showlayoutBinding.showRecView.setAdapter(new ShowAdapter(showEvents));

    }

}
