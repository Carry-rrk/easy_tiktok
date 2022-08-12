package bytedance.example.easy_tiktok;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bytedance.example.easy_tiktok.databinding.ActivityMainBinding;
import bytedance.example.easy_tiktok.databinding.MovielistitemBinding;
import bytedance.example.easy_tiktok.frags.IndividualFragment;
import bytedance.example.easy_tiktok.frags.ListFragment;
import bytedance.example.easy_tiktok.frags.VideoFragment;
import bytedance.example.easy_tiktok.utils.MyFragAdapter;
import bytedance.example.easy_tiktok.vm.MainVm;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;    //绑定主布局文件
    String[] titles = {"视频","榜单","我的"};
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
