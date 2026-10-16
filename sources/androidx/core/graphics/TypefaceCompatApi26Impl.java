package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final Class f33992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final Constructor f33993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final Method f33994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final Method f33995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final Method f33996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final Method f33997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final Method f33998m;

    public TypefaceCompatApi26Impl() {
        Class clsZ;
        Constructor constructorA;
        Method methodW;
        Method methodX;
        Method methodB;
        Method methodV;
        Method methodY;
        try {
            clsZ = z();
            constructorA = A(clsZ);
            methodW = w(clsZ);
            methodX = x(clsZ);
            methodB = B(clsZ);
            methodV = v(clsZ);
            methodY = y(clsZ);
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e3.getClass().getName(), e3);
            clsZ = null;
            constructorA = null;
            methodW = null;
            methodX = null;
            methodB = null;
            methodV = null;
            methodY = null;
        }
        this.f33992g = clsZ;
        this.f33993h = constructorA;
        this.f33994i = methodW;
        this.f33995j = methodX;
        this.f33996k = methodB;
        this.f33997l = methodV;
        this.f33998m = methodY;
    }

    private Object p() {
        try {
            return this.f33993h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void q(Object obj) {
        try {
            this.f33997l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean r(Context context, Object obj, String str, int i3, int i4, int i5, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f33994i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj, ByteBuffer byteBuffer, int i3, int i4, int i5) {
        try {
            return ((Boolean) this.f33995j.invoke(obj, byteBuffer, Integer.valueOf(i3), null, Integer.valueOf(i4), Integer.valueOf(i5))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t(Object obj) {
        try {
            return ((Boolean) this.f33996k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean u() {
        if (this.f33994i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f33994i != null;
    }

    protected Constructor A(Class cls) {
        return cls.getConstructor(null);
    }

    protected Method B(Class cls) {
        return cls.getMethod("freeze", null);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i3) {
        if (!u()) {
            return super.b(context, fontFamilyFilesResourceEntry, resources, i3);
        }
        Object objP = p();
        if (objP == null) {
            return null;
        }
        FontResourcesParserCompat.FontFileResourceEntry[] fontFileResourceEntryArrA = fontFamilyFilesResourceEntry.a();
        int length = fontFileResourceEntryArrA.length;
        int i4 = 0;
        while (i4 < length) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = fontFileResourceEntryArrA[i4];
            Context context2 = context;
            if (!r(context2, objP, fontFileResourceEntry.a(), fontFileResourceEntry.c(), fontFileResourceEntry.e(), fontFileResourceEntry.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.d()))) {
                q(objP);
                return null;
            }
            i4++;
            context = context2;
        }
        if (t(objP)) {
            return m(objP);
        }
        return null;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        Typeface typefaceM;
        Object obj;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (u()) {
            Map mapH = TypefaceCompatUtil.h(context, fontInfoArr, cancellationSignal);
            Object objP = p();
            if (objP == null) {
                return null;
            }
            int length = fontInfoArr.length;
            int i4 = 0;
            boolean z2 = false;
            while (i4 < length) {
                FontsContractCompat.FontInfo fontInfo = fontInfoArr[i4];
                ByteBuffer byteBuffer = (ByteBuffer) mapH.get(fontInfo.d());
                if (byteBuffer == null) {
                    obj = objP;
                } else {
                    boolean zS = s(objP, byteBuffer, fontInfo.c(), fontInfo.e(), fontInfo.f() ? 1 : 0);
                    obj = objP;
                    if (!zS) {
                        q(obj);
                        return null;
                    }
                    z2 = true;
                }
                i4++;
                objP = obj;
                z2 = z2;
            }
            Object obj2 = objP;
            if (!z2) {
                q(obj2);
                return null;
            }
            if (t(obj2) && (typefaceM = m(obj2)) != null) {
                return Typeface.create(typefaceM, i3);
            }
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
                Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(fontInfoJ.e()).setItalic(fontInfoJ.f()).build();
                parcelFileDescriptorOpenFileDescriptor.close();
                return typefaceBuild;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public /* bridge */ /* synthetic */ Typeface d(Context context, CancellationSignal cancellationSignal, List list, int i3) {
        return super.d(context, cancellationSignal, list, i3);
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface f(Context context, Resources resources, int i3, String str, int i4) {
        if (!u()) {
            return super.f(context, resources, i3, str, i4);
        }
        Object objP = p();
        if (objP == null) {
            return null;
        }
        if (!r(context, objP, str, 0, -1, -1, null)) {
            q(objP);
            return null;
        }
        if (t(objP)) {
            return m(objP);
        }
        return null;
    }

    protected Typeface m(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f33992g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f33998m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method v(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    protected Method w(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3, FontVariationAxis[].class);
    }

    protected Method x(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method y(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class z() {
        return Class.forName("android.graphics.FontFamily");
    }
}
