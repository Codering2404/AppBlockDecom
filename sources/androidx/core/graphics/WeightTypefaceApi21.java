package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WeightTypefaceApi21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Field f34005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f34006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Method f34007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Constructor f34008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final LongSparseArray f34009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f34010f;

    static {
        Field declaredField;
        Constructor declaredConstructor;
        Method declaredMethod;
        Method declaredMethod2;
        try {
            declaredField = Typeface.class.getDeclaredField("native_instance");
            Class cls = Long.TYPE;
            Class cls2 = Integer.TYPE;
            declaredMethod = Typeface.class.getDeclaredMethod("nativeCreateFromTypeface", cls, cls2);
            declaredMethod.setAccessible(true);
            declaredMethod2 = Typeface.class.getDeclaredMethod("nativeCreateWeightAlias", cls, cls2);
            declaredMethod2.setAccessible(true);
            declaredConstructor = Typeface.class.getDeclaredConstructor(cls);
            declaredConstructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e3) {
            Log.e("WeightTypeface", e3.getClass().getName(), e3);
            declaredField = null;
            declaredConstructor = null;
            declaredMethod = null;
            declaredMethod2 = null;
        }
        f34005a = declaredField;
        f34006b = declaredMethod;
        f34007c = declaredMethod2;
        f34008d = declaredConstructor;
        f34009e = new LongSparseArray(3);
        f34010f = new Object();
    }
}
