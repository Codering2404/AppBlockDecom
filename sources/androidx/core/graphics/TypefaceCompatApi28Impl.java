package androidx.core.graphics;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    protected Typeface m(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f33992g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f33998m.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    protected Method y(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, String.class, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
