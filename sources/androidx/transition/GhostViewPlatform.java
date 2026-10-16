package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GhostViewPlatform implements GhostView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f53429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f53430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f53431d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f53432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Method f53433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f53434h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f53435a;

    private GhostViewPlatform(View view) {
        this.f53435a = view;
    }

    static GhostView b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = f53431d;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        return null;
    }

    private static void c() {
        if (f53432f) {
            return;
        }
        try {
            d();
            Method declaredMethod = f53429b.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f53431d = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e3) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e3);
        }
        f53432f = true;
    }

    private static void d() {
        if (f53430c) {
            return;
        }
        try {
            f53429b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e3) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e3);
        }
        f53430c = true;
    }

    private static void e() {
        if (f53434h) {
            return;
        }
        try {
            d();
            Method declaredMethod = f53429b.getDeclaredMethod("removeGhost", View.class);
            f53433g = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e3) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e3);
        }
        f53434h = true;
    }

    static void f(View view) {
        e();
        Method method = f53433g;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i3) {
        this.f53435a.setVisibility(i3);
    }

    @Override // androidx.transition.GhostView
    public void a(ViewGroup viewGroup, View view) {
    }
}
