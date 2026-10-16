package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class TypefaceCompatBaseImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f33999a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.e();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface StyleExtractor<T> {
        boolean a(Object obj);

        int b(Object obj);
    }

    TypefaceCompatBaseImpl() {
    }

    private void a(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long jK = k(typeface);
        if (jK != 0) {
            this.f33999a.put(Long.valueOf(jK), fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry g(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i3) {
        return (FontResourcesParserCompat.FontFileResourceEntry) h(fontFamilyFilesResourceEntry.a(), i3, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.2
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int b(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.e();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public boolean a(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.f();
            }
        });
    }

    private static Object h(Object[] objArr, int i3, StyleExtractor styleExtractor) {
        return i(objArr, (i3 & 1) == 0 ? RCHTTPStatusCodes.BAD_REQUEST : ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD, (i3 & 2) != 0, styleExtractor);
    }

    private static Object i(Object[] objArr, int i3, boolean z2, StyleExtractor styleExtractor) {
        Object obj = null;
        int i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(styleExtractor.b(obj2) - i3) * 2) + (styleExtractor.a(obj2) == z2 ? 0 : 1);
            if (obj == null || i4 > iAbs) {
                obj = obj2;
                i4 = iAbs;
            }
        }
        return obj;
    }

    private static long k(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0L;
        } catch (NoSuchFieldException e4) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e4);
            return 0L;
        }
    }

    public Typeface b(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i3) {
        FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntryG = g(fontFamilyFilesResourceEntry, i3);
        if (fontFileResourceEntryG == null) {
            return null;
        }
        Typeface typefaceE = TypefaceCompat.e(context, resources, fontFileResourceEntryG.b(), fontFileResourceEntryG.a(), 0, i3);
        a(typefaceE, fontFamilyFilesResourceEntry);
        return typefaceE;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i3) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(j(fontInfoArr, i3).d());
            try {
                Typeface typefaceE = e(context, inputStreamOpenInputStream);
                TypefaceCompatUtil.a(inputStreamOpenInputStream);
                return typefaceE;
            } catch (IOException unused) {
                TypefaceCompatUtil.a(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                TypefaceCompatUtil.a(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Typeface d(Context context, CancellationSignal cancellationSignal, List list, int i3) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    protected Typeface e(Context context, InputStream inputStream) {
        File fileE = TypefaceCompatUtil.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface f(Context context, Resources resources, int i3, String str, int i4) {
        File fileE = TypefaceCompatUtil.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.c(fileE, resources, i3)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    protected FontsContractCompat.FontInfo j(FontsContractCompat.FontInfo[] fontInfoArr, int i3) {
        return (FontsContractCompat.FontInfo) h(fontInfoArr, i3, new StyleExtractor<FontsContractCompat.FontInfo>() { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.1
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int b(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.e();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public boolean a(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.f();
            }
        });
    }
}
