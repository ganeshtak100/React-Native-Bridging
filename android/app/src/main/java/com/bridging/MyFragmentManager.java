//package com.bridging;
//
//import android.widget.FrameLayout;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.facebook.react.ReactApplication;
//import com.facebook.react.bridge.ReactApplicationContext;
//import com.facebook.react.bridge.ReadableArray;
//import com.facebook.react.common.MapBuilder;
//import com.facebook.react.common.mapbuffer.MapBuffer;
//import com.facebook.react.uimanager.ThemedReactContext;
//import com.facebook.react.uimanager.ViewGroupManager;
//
//import java.util.Map;
//
//public class MyFragmentManager extends ViewGroupManager<FrameLayout> {
//    public static  final String REACT_CLASS = "MyTestView";
//    public static  int COMMAND_CREATE = 1;
//    private  int propWidth =1500;
//    private  int propHeight =1500;
//    ReactApplicationContext reactContext;
//    MyFragment myFragment;
//
//    public MyFragmentManager(ReactApplicationContext reactContext) {
//        this.reactContext = reactContext;
//    }
//
//    @NonNull
//    @Override
//    public String getName() {
//        return REACT_CLASS;
//    }
//
//    @NonNull
//    @Override
//    protected FrameLayout createViewInstance(@NonNull ThemedReactContext themedReactContext) {
//        return new FrameLayout(reactContext);
//    }
//
//    @Nullable
//    @Override
//    public Map<String,Integer> getCommandsMap(){
//        return MapBuilder.of("create",COMMAND_CREATE)
//    }
//
//    public void receiveCommand(@NonNull FrameLayout root,
//                               String id,
//                               @Nullable ReadableArray args)
//    {
//        super.receiveCommand(root,id,args);
//        int reactNativeViewId = args.getInt(0);
//        int commandIdInt = Integer.parseInt(id);
//
//        switch (commandIdInt){
//            case COMMAND_CREATE:
//                createFragment(root,reactNativeViewId);
//                break;
//            default:{
//
//            }
//        }
//    }
//}
