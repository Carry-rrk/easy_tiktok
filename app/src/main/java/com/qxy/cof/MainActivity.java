package com.qxy.cof;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bytedance.sdk.*;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private String mScope = "user_info,trial.whitelist,discovery.ent,video.list,video.data,following.list,fans.list,fans.check";
    DouYinOpenApi douYinOpenApi;;
    private String clientkey ="awtpi7iykd02xini";
    String[] mPermissionList = new String[] {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    static final int PHOTO_REQUEST_GALLERY = 10;
    private ArrayList<String> mUri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d("rrkdebug",""+(douYinOpenApi==null));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but = findViewById(R.id.button);
        DouYinOpenApiFactory.init(new DouYinOpenConfig(clientkey));
        douYinOpenApi = DouYinOpenApiFactory.create(this);
//        Log.d("rrkdebug",""+(douYinOpenApi==null));
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendAuth();
//                video_tool vt = new video_tool();
//                try {
//                    Vector<video_Item> vi = vt.getVideo(vt.get_list());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                userinfo_tools ut = new userinfo_tools();
               Vector<fans_or_follows> follow = ut.getFollows();
               for(int i=0;i<follow.size();i++)
               {
                   Log.d("rrkdebug",follow .get(i).toString());
               }
            }
        });
    }
    private boolean sendAuth() {
        Authorization.Request request = new Authorization.Request();
        request.scope = mScope;                          // 用户授权时必选权限
//        request.optionalScope0 = "user_info";
//        request.optionalScope0 = "mobile";     // 用户授权时可选权限（默认选择）
//        request.optionalScope0 = mOptionalScope1;    // 用户授权时可选权限（默认不选）
        request.state = "ww";                                   // 用于保持请求和回调的状态，授权请求后原样带回给第三方。
        Log.d("rrkdebug",""+(douYinOpenApi==null));
        return douYinOpenApi.authorize(request);               // 优先使用抖音app进行授权，如果抖音app因版本或者其他原因无法授权，则使用wap页授权

    }

}