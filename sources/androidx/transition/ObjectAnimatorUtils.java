package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ObjectAnimatorUtils {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static <T, V> ObjectAnimator a(T t2, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t2, property, (TypeConverter) null, path);
        }
    }

    static ObjectAnimator a(Object obj, Property property, Path path) {
        return Api21Impl.a(obj, property, path);
    }
}
