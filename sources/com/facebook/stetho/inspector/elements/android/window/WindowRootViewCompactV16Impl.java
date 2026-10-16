package com.facebook.stetho.inspector.elements.android.window;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class WindowRootViewCompactV16Impl extends WindowRootViewCompat {
    private Context mContext;

    WindowRootViewCompactV16Impl(Context context) {
        this.mContext = context;
    }

    private static Object getOuter(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mWindowManager");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            declaredField.setAccessible(false);
            return obj2;
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchFieldException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static List<View> getWindowViews(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mViews");
            declaredField.setAccessible(true);
            return Collections.unmodifiableList(Arrays.asList((View[]) declaredField.get(obj)));
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (NoSuchFieldException e4) {
            throw new RuntimeException(e4);
        }
    }

    @Override // com.facebook.stetho.inspector.elements.android.window.WindowRootViewCompat
    public List<View> getRootViews() {
        return getWindowViews(getOuter((WindowManager) this.mContext.getSystemService("window")));
    }
}
