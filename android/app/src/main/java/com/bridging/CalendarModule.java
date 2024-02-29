package com.bridging;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
public class CalendarModule extends  ReactContextBaseJavaModule {
   public CalendarModule(@Nullable  ReactApplicationContext context){
        super(context);
        MyFragment.reactApplicationContext = context;
    }


    @NonNull
    @Override
    public String getName() {
        return "CalendarModule";
    }

    @ReactMethod
    public  void createCalendarEvent(String name, String location){
        Log.d("CalendarModule","This is called in Android as Native" +name +"and location" +location);
    }

    @ReactMethod
    public  void callMethod(String param){
        System.out.println("Calling this method from React Native to Android"+param);
//        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
//        Intent batteryStatus = registerReceiver(null, ifilter);
//
//        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
//
//        float batteryPct = level / (float)scale;
//
//        return (int)(batteryPct*100);

    }

    @ReactMethod
    public void methodWthPromise(String param, Promise promise){
       promise.resolve("Sending Data from Naive Android to React-Native "+param);
    }

    @ReactMethod
    public void addListener(String eventName){

    }

    @ReactMethod
    public void removeListener(Integer count){

    }
}
