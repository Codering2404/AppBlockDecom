package com.facebook.stetho.inspector.elements.android.window;

import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class WindowRootViewCompactV19Impl extends WindowRootViewCompat {
    private List<View> mRootViews;

    WindowRootViewCompactV19Impl() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object objInvoke = cls.getDeclaredMethod("getInstance", null).invoke(cls, null);
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            this.mRootViews = (List) declaredField.get(objInvoke);
            declaredField.setAccessible(false);
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
        return Collections.unmodifiableList(this.mRootViews);
    }
}
