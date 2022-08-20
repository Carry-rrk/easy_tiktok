package com.qxy.cof.douyinapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bytedance.sdk.open.aweme.CommonConstants;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.bytedance.sdk.open.douyin.DouYinOpenApiFactory;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import com.qxy.cof.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DouYinEntryActivity extends Activity implements IApiEventHandler  {
    DouYinOpenApi douYinOpenApi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        douYinOpenApi = DouYinOpenApiFactory.create(this);
        douYinOpenApi.handleIntent(getIntent(), this);
    }

    @Override
    public void onReq(BaseReq req) {

    }

    @Override
    public void onResp(BaseResp resp) {
//        Log.d("rrkdebug","1111");
        // 授权成功可以获得authCode
        if (resp.getType() == CommonConstants.ModeType.SEND_AUTH_RESPONSE) {
            Authorization.Response response = (Authorization.Response) resp;
            if (resp.isSuccess()) {
                String code = ((Authorization.Response) resp).authCode;
                OkHttpClient httpClient = new OkHttpClient.Builder().build();
                RequestBody rb = new FormBody.Builder()
                        .add("client_secret","bd48ef702cfa7aef1f11d3ae7974e96c")
                        .add("code",code)
                        .add("grant_type","authorization_code")
                        .add("client_key","awtpi7iykd02xini")
                        .build();
                Request  re = new Request.Builder()
                        .url("https://open.douyin.com//oauth/access_token/")
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .post(rb)
                        .build();
                Call call = httpClient.newCall(re);
                call.enqueue(new Callback() {
                                 @Override
                                 public void onFailure(Call call, IOException e) {
                                     e.printStackTrace();
                                     Log.d("rrkdebug", "response:falier");
                                 }

                                 @Override
                                 public void onResponse(Call call, okhttp3.Response response) throws IOException {
                                    String s = response.body().string();
                                     String ac_token = null;
                                     String open_id = null;

                                     try {
                                         ac_token = new JSONObject(s).getJSONObject("data").getString("access_token");
                                         open_id = new JSONObject(s).getJSONObject("data").getString("open_id");

                                     } catch (JSONException e) {
                                         e.printStackTrace();
                                     }
                                     Log.d("rrkdebug", "response: " +open_id );
                                     Log.d("rrkdebug", "response: " +ac_token );
                                 }
                             }
                );

//                Log.d("rrkdebug","jixule");
                Toast.makeText(this, "授权成功，获得权限：" + response.grantedPermissions,
                        Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(this, "授权失败" + response.grantedPermissions,
                        Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    public void onErrorIntent(@Nullable Intent intent) {
        // 错误数据
        Toast.makeText(this, "intent出错啦", Toast.LENGTH_LONG).show();
        finish();
    }
}
