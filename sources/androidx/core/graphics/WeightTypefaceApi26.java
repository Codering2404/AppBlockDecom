package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WeightTypefaceApi26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Field f34011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f34012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor f34013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final LongSparseArray f34014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f34015e;

    static {
        Field declaredField;
        Constructor declaredConstructor;
        Method declaredMethod;
        try {
            declaredField = Typeface.class.getDeclaredField("native_instance");
            Class cls = Long.TYPE;
            declaredMethod = Typeface.class.getDeclaredMethod("nativeCreateFromTypefaceWithExactStyle", cls, Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            declaredConstructor = Typeface.class.getDeclaredConstructor(cls);
            declaredConstructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e3) {
            Log.e("WeightTypeface", e3.getClass().getName(), e3);
            declaredField = null;
            declaredConstructor = null;
            declaredMethod = null;
        }
        f34011a = declaredField;
        f34012b = declaredMethod;
        f34013c = declaredConstructor;
        f34014d = new LongSparseArray(3);
        f34015e = new Object();
    }
}
