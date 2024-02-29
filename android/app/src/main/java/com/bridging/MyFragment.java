package com.bridging;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class MyFragment extends Fragment {
    public static ReactApplicationContext reactApplicationContext;
    public Handler handler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.test_fragment,container,false);
        callEventEmitter();
        return  rootView;
    }

    public void callEventEmitter(){
        handler = new Handler();
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                        .emit("onReady", "This is From Android");
                handler.postDelayed(this, 1500);

            }
        };
        handler.postDelayed(r,1500);
    }
}
