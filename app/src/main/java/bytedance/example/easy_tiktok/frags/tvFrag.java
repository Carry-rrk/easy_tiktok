package bytedance.example.easy_tiktok.frags;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
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
import bytedance.example.easy_tiktok.databinding.TvlayoutBinding;
import bytedance.example.easy_tiktok.utils.MovieAdapter;
import bytedance.example.easy_tiktok.utils.ShowAdapter;

public class tvFrag extends Fragment {

    TvlayoutBinding tvlayoutBinding;
    List<MovieItem> movieEvents = new ArrayList<>();
//    List<ShowItem> tvEvents = new ArrayList<>();

    public tvFrag(List<MovieItem> movieEvents) {
        this.movieEvents = movieEvents;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        tvlayoutBinding = DataBindingUtil.inflate(inflater, R.layout.tvlayout,container,false);
        return tvlayoutBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        movie_internet mi = new movie_internet();
//        mi.init("awtpi7iykd02xini","bd48ef702cfa7aef1f11d3ae7974e96c");
//        ArrayList<MovieItem>  mit = mi.get_movielist(2);
//        Log.d(TAG, "FFFFFFFFFFFFF----------------->onActivityCreated: "+mit.size());
//        for(int i =0;i< mit.size();i++) {
//            movieEvents.add(mit.get(i));
//        }

        tvlayoutBinding.tvRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tvlayoutBinding.tvRecView.setAdapter(new MovieAdapter(movieEvents));
//        tvlayoutBinding.tvRecView.setAdapter(new ShowAdapter(tvEvents));

    }
}