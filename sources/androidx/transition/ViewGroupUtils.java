package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewGroupUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f53560a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f53561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f53562c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static int a(ViewGroup viewGroup, int i3) {
            return viewGroup.getChildDrawingOrder(i3);
        }

        static void b(ViewGroup viewGroup, boolean z2) {
            viewGroup.suppressLayout(z2);
        }
    }

    static int a(ViewGroup viewGroup, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(viewGroup, i3);
        }
        if (!f53562c) {
            try {
                Class cls = Integer.TYPE;
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", cls, cls);
                f53561b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f53562c = true;
        }
        Method method = f53561b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i3))).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i3;
    }

    private static void b(ViewGroup viewGroup, boolean z2) {
        if (f53560a) {
            try {
                Api29Impl.b(viewGroup, z2);
            } catch (NoSuchMethodError unused) {
                f53560a = false;
            }
        }
    }

    static void c(ViewGroup viewGroup, boolean z2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.b(viewGroup, z2);
        } else {
            b(viewGroup, z2);
        }
    }
}
