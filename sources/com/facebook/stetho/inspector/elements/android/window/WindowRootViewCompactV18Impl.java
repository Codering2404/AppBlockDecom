package com.facebook.stetho.inspector.elements.android.window;

import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class WindowRootViewCompactV18Impl extends WindowRootViewCompat {
    private Field mViewsField;
    private Object mWindowManagerGlobal;

    WindowRootViewCompactV18Impl() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            this.mWindowManagerGlobal = cls.getDeclaredMethod("getInstance", null).invoke(cls, null);
            Field declaredField = cls.getDeclaredField("mViews");
            this.mViewsField = declaredField;
            declaredField.setAccessible(true);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException(e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        } catch (NoSuchFieldException e5) {
            throw new RuntimeException(e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // com.facebook.stetho.inspector.elements.android.window.WindowRootViewCompat
    public List<View> getRootViews() {
        try {
            return Collections.unmodifiableList(Arrays.asList((View[]) this.mViewsField.get(this.mWindowManagerGlobal)));
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        }
    }
}
