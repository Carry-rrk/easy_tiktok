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

import bytedance.example.easy_tiktok.BR;
import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.bean.MovieItem;
import bytedance.example.easy_tiktok.databinding.MovielayoutBinding;
import bytedance.example.easy_tiktok.utils.MovieAdapter;

public class movieFrag extends Fragment {

    MovielayoutBinding movielayoutBinding;
    List<MovieItem> movieEvents = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        movielayoutBinding = DataBindingUtil.inflate(inflater, R.layout.movielayout,container,false);
        return movielayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        movieEvents.add(new MovieItem(null,"人生大事情1!!","豆瓣评分 9.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情2!!","豆瓣评分 9.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情3!!","豆瓣评分 9.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情4!!","豆瓣评分 9.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情5!!","豆瓣评分 9.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情6!!","豆瓣评分 9.3","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情7!!","豆瓣评分 9.6","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情8!!","豆瓣评分 9.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情9!!","豆瓣评分 9.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情10!!","豆瓣评分 3.9","剧情 / 悬疑","2008年11月","1002w"));
        movieEvents.add(new MovieItem(null,"人生大事情11!!","豆瓣评分 2.9","剧情 / 悬疑","2008年11月","1002w"));

        movielayoutBinding.movieRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        movielayoutBinding.movieRecView.setAdapter(new MovieAdapter(movieEvents));


    }

}
