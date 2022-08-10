package bytedance.example.easy_tiktok.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainVm extends ViewModel {

    public MutableLiveData<String> movieTime = new MutableLiveData<>();

}
