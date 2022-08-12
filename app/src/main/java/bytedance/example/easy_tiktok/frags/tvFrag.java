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
import bytedance.example.easy_tiktok.bean.ShowItem;
import bytedance.example.easy_tiktok.databinding.TvlayoutBinding;
import bytedance.example.easy_tiktok.utils.ShowAdapter;

public class tvFrag extends Fragment {

    TvlayoutBinding tvlayoutBinding;
    List<ShowItem> tvEvents = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        tvlayoutBinding = DataBindingUtil.inflate(inflater, R.layout.tvlayout,container,false);
        return tvlayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!","赵丽颖 / 刘威 唐曾","共40集","2018年11月","982w"));
        tvEvents.add(new ShowItem(null,"人生大事情1!!"," / 刘威 唐曾","共40集","2018年11月","982w"));

        tvlayoutBinding.tvRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tvlayoutBinding.tvRecView.setAdapter(new ShowAdapter(tvEvents));

    }
}
