package bytedance.example.easy_tiktok.vm;

import android.app.Fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainVm extends ViewModel {

    public MutableLiveData<String> title = new MutableLiveData<>();

    List<Fragment> fragmentList = new ArrayList<>();



}
