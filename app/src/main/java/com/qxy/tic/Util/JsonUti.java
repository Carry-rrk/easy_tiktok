package com.qxy.tic.Util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonUti {

    public static String getJson(Context context,String file){
        StringBuffer stringBuffer=new StringBuffer();

        try {
            AssetManager assetManager=context.getAssets();
            BufferedReader bf=new BufferedReader(new InputStreamReader(
                    assetManager.open(file)
            ));
            String line;
            while ((line=bf.readLine())!=null){
                stringBuffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}
