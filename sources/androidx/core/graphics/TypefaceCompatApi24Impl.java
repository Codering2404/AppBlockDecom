package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f33988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor f33989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f33990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Method f33991e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi24Impl", e3.getClass().getName(), e3);
            cls = null;
            method = null;
            method2 = null;
        }
        f33989c = constructor;
        f33988b = cls;
        f33990d = method2;
        f33991e = method;
    }

    private static boolean l(Object obj, ByteBuffer byteBuffer, int i3, int i4, boolean z2) {
        try {
            return ((Boolean) f33990d.invoke(obj, byteBuffer, Integer.valueOf(i3), null, Integer.valueOf(i4), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface m(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f33988b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f33991e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Object n() {
        try {
            return f33989c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i3) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            ByteBuffer byteBufferB = TypefaceCompatUtil.b(context, resources, fontFileResourceEntry.b());
            if (byteBufferB == null || !l(objN, byteBufferB, fontFileResourceEntry.c(), fontFileResourceEntry.e(), fontFileResourceEntry.f())) {
                return null;
            }
        }
        return m(objN);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            Uri uriD = fontInfo.d();
            ByteBuffer byteBufferF = (ByteBuffer) simpleArrayMap.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = TypefaceCompatUtil.f(context, cancellationSignal, uriD);
                simpleArrayMap.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !l(objN, byteBufferF, fontInfo.c(), fontInfo.e(), fontInfo.f())) {
                return null;
            }
        }
        Typeface typefaceM = m(objN);
        if (typefaceM == null) {
            return null;
        }
        return Typeface.create(typefaceM, i3);
    }
}
