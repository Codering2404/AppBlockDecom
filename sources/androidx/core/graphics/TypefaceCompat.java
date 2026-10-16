package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.tracing.Trace;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class TypefaceCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TypefaceCompatBaseImpl f33980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LruCache f33981b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ResourcesCompat.FontCallback f33982a;

        public ResourcesCallbackAdapter(ResourcesCompat.FontCallback fontCallback) {
            this.f33982a = fontCallback;
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void a(int i3) {
            ResourcesCompat.FontCallback fontCallback = this.f33982a;
            if (fontCallback != null) {
                fontCallback.onFontRetrievalFailed(i3);
            }
        }

        @Override // androidx.core.provider.FontsContractCompat.FontRequestCallback
        public void b(Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.f33982a;
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
        }
    }

    static {
        Trace.a("TypefaceCompat static init");
        if (Build.VERSION.SDK_INT >= 29) {
            f33980a = new TypefaceCompatApi29Impl();
        } else {
            f33980a = new TypefaceCompatApi28Impl();
        }
        f33981b = new LruCache(16);
        Trace.b();
    }

    public static Typeface a(Context context, Typeface typeface, int i3) {
        if (context != null) {
            return Typeface.create(typeface, i3);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        Trace.a("TypefaceCompat.createFromFontInfo");
        try {
            return f33980a.c(context, cancellationSignal, fontInfoArr, i3);
        } finally {
            Trace.b();
        }
    }

    public static Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i3) {
        Trace.a("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return f33980a.d(context, cancellationSignal, list, i3);
        } finally {
            Trace.b();
        }
    }

    public static Typeface d(Context context, FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, Resources resources, int i3, String str, int i4, int i5, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z2) {
        Typeface typefaceB;
        if (familyResourceEntry instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry;
            Typeface typefaceH = h(providerResourceEntry.d());
            if (typefaceH != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(typefaceH, handler);
                }
                return typefaceH;
            }
            typefaceB = FontsContractCompat.d(context, providerResourceEntry.a() != null ? c.a(new Object[]{providerResourceEntry.c(), providerResourceEntry.a()}) : c.a(new Object[]{providerResourceEntry.c()}), i5, !z2 ? fontCallback != null : providerResourceEntry.b() != 0, z2 ? providerResourceEntry.e() : -1, ResourcesCompat.FontCallback.getHandler(handler), new ResourcesCallbackAdapter(fontCallback));
        } else {
            typefaceB = f33980a.b(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry, resources, i5);
            if (fontCallback != null) {
                if (typefaceB != null) {
                    fontCallback.callbackSuccessAsync(typefaceB, handler);
                } else {
                    fontCallback.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f33981b.put(f(resources, i3, str, i4, i5), typefaceB);
        }
        return typefaceB;
    }

    public static Typeface e(Context context, Resources resources, int i3, String str, int i4, int i5) {
        Typeface typefaceF = f33980a.f(context, resources, i3, str, i5);
        if (typefaceF != null) {
            f33981b.put(f(resources, i3, str, i4, i5), typefaceF);
        }
        return typefaceF;
    }

    private static String f(Resources resources, int i3, String str, int i4, int i5) {
        return resources.getResourcePackageName(i3) + '-' + str + '-' + i4 + '-' + i3 + '-' + i5;
    }

    public static Typeface g(Resources resources, int i3, String str, int i4, int i5) {
        return (Typeface) f33981b.get(f(resources, i3, str, i4, i5));
    }

    private static Typeface h(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }
}
