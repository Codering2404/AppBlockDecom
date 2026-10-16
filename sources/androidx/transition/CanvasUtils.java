package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class CanvasUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f53348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f53349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f53350c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static void a(Canvas canvas) {
            canvas.disableZ();
        }

        static void b(Canvas canvas) {
            canvas.enableZ();
        }
    }

    static void a(Canvas canvas, boolean z2) {
        Method method;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            if (z2) {
                Api29Impl.b(canvas);
                return;
            } else {
                Api29Impl.a(canvas);
                return;
            }
        }
        if (i3 == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f53350c) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                f53348a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                f53349b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f53350c = true;
        }
        if (z2) {
            try {
                Method method2 = f53348a;
                if (method2 != null) {
                    method2.invoke(canvas, null);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        if (z2 || (method = f53349b) == null) {
            return;
        }
        method.invoke(canvas, null);
    }
}
