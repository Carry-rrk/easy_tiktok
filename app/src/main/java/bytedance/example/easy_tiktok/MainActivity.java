package bytedance.example.easy_tiktok;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import bytedance.example.easy_tiktok.bean.MovieItem;
import bytedance.example.easy_tiktok.databinding.ActivityMainBinding;
import bytedance.example.easy_tiktok.frags.IndividualFragment;
import bytedance.example.easy_tiktok.frags.ListFragment;
import bytedance.example.easy_tiktok.frags.VideoFragment;
import bytedance.example.easy_tiktok.utils.MovieAdapter;
import bytedance.example.easy_tiktok.utils.MyFragAdapter;
import bytedance.example.easy_tiktok.vm.MainVm;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;    //绑定主布局文件
    String[] titles = {"Tab1","Tab2","Tab3"};
    List<Fragment> fragmentList = new ArrayList<>();
    View view;
    MainVm mainvm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //绑定布局文件
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        mainvm = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MainVm.class);
        mainBinding.setVm(mainvm);
        mainBinding.setLifecycleOwner(this);

        fragmentList.add(new VideoFragment());
        fragmentList.add(new ListFragment());
        fragmentList.add(new IndividualFragment());

        mainBinding.vp.setAdapter(new MyFragAdapter(getSupportFragmentManager(),fragmentList,titles));
        mainBinding.tablayout.setupWithViewPager(mainBinding.vp);
    }
}
