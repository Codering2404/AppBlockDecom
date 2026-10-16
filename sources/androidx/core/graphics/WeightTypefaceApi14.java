package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WeightTypefaceApi14 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Field f34002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LongSparseArray f34003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f34004c;

    static {
        Field declaredField;
        try {
            declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
        } catch (Exception e3) {
            Log.e("WeightTypeface", e3.getClass().getName(), e3);
            declaredField = null;
        }
        f34002a = declaredField;
        f34003b = new LongSparseArray(3);
        f34004c = new Object();
    }
}
