package bytedance.example.easy_tiktok.utils;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyOkHttp {
    OkHttpClient client;
    String url;         //目标网络地址
    Request request;    //请求
    Response response;  //响应
    Call call;

    public MyOkHttp(String url) {
        this.url = url;             //设置目标网络地址

//        创建OKHttpClient类的实例
        client = new OkHttpClient();

//        创建request对象（并设置目标地址、请求方式等）
        request = new Request.Builder()
                .url(url)           //设置目标网络地址
                .get()              //默认为get请求
                .build();

//        调用newCall（）方法创建call对象
        call = client.newCall(request);
    }

    public MyOkHttp(String url, RequestBody requestBody) {
        this.url = url;

//        创建OKHttpClient类的实例
        client = new OkHttpClient();

//        创建request对象（并设置目标地址、请求方式等）
        request = new Request.Builder()
                .url(url)           //设置目标网络地址
                .post(requestBody)  //为post请求设置请求体
                .build();

//        调用newCall（）方法创建call对象
        call = client.newCall(request);
    }

    public void postRequest(){
        /**
         * 同步请求
         * 执行请求的操作是阻塞式，直到HTTP响应返回。
         * 如果当前OkHttpClient已经执行了一个同步任务，如果这个任务没有释放锁，那么新发起的请求将被阻塞，直到当前任务释放锁。
         * 同步请求对应OkHttp中的execute()方法。
         *
         * 因为同步请求的方式会阻塞调用线程，所以提交同步请求的操作应放在子线程中执行，
         *      否则有可能会引起ANR异常，并且在Android 3.0以后已经不允许在主线程中进行网络操作了。
         */
        
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    response = call.execute();
//                    String responseData = response.body().string();
//                    Log.d(TAG, "run: "+responseData);
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        });

        /**
         * 异步请求
         * 执行的是非阻塞式请求，它的执行结果一般都是通过接口回调的方式告知调用者。
         * 同一时刻可以发起多个请求，因为异步请求每一个都是在一个独立的线程，由线程队列管理。
         * 异步请求对应OkHttp中的enqueue()方法。
         *
         * 通过Call对象的enqueue(Callback)方法来提交异步请求，
         *      异步发起的请求会被加入到队列中通过线程池来执行。
         *              最后通过接口回调的onResponse()方法来接收服务器返回的数据。
         */
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                Log.d(TAG, "run: "+responseData);
            }
        });
    }

}
