package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class f33983b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Constructor f33984c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f33985d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f33986e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f33987f = false;

    TypefaceCompatApi21Impl() {
    }

    private static boolean l(Object obj, String str, int i3, boolean z2) throws NoSuchMethodException {
        o();
        try {
            return ((Boolean) f33985d.invoke(obj, str, Integer.valueOf(i3), Boolean.valueOf(z2))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static Typeface m(Object obj) throws NoSuchMethodException {
        o();
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f33983b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f33986e.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private File n(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void o() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f33987f) {
            return;
        }
        f33987f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi21Impl", e3.getClass().getName(), e3);
            method = null;
            cls = null;
            method2 = null;
        }
        f33984c = constructor;
        f33983b = cls;
        f33985d = method2;
        f33986e = method;
    }

    private static Object p() throws NoSuchMethodException {
        o();
        try {
            return f33984c.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i3) throws NoSuchMethodException {
        Object objP = p();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.a()) {
            File fileE = TypefaceCompatUtil.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.c(fileE, resources, fontFileResourceEntry.b())) {
                    return null;
                }
                if (!l(objP, fileE.getPath(), fontFileResourceEntry.e(), fontFileResourceEntry.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return m(objP);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        Typeface typefaceE;
        if (fontInfoArr.length < 1) {
            return null;
        }
        FontsContractCompat.FontInfo fontInfoJ = j(fontInfoArr, i3);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(fontInfoJ.d(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                File fileN = n(parcelFileDescriptorOpenFileDescriptor);
                if (fileN == null || !fileN.canRead()) {
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        typefaceE = super.e(context, fileInputStream);
                        fileInputStream.close();
                    } finally {
                    }
                } else {
                    typefaceE = Typeface.createFromFile(fileN);
                }
                parcelFileDescriptorOpenFileDescriptor.close();
                return typefaceE;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
