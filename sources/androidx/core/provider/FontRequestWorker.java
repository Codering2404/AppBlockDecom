package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.c;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import androidx.tracing.Trace;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FontRequestWorker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final LruCache f34200a = new LruCache(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f34201b = RequestExecutor.a("fonts-androidx", 10, ColorExtractionConstants.MAX_PIXEL_SAMPLES);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f34202c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final SimpleArrayMap f34203d = new SimpleArrayMap();

    private static String a(List list, int i3) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < list.size(); i4++) {
            sb.append(((FontRequest) list.get(i4)).d());
            sb.append("-");
            sb.append(i3);
            if (i4 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    private static int b(FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i3 = 1;
        if (fontFamilyResult.e() != 0) {
            return fontFamilyResult.e() != 1 ? -3 : -2;
        }
        FontsContractCompat.FontInfo[] fontInfoArrC = fontFamilyResult.c();
        if (fontInfoArrC != null && fontInfoArrC.length != 0) {
            i3 = 0;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArrC) {
                int iB = fontInfo.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i3;
    }

    static TypefaceResult c(String str, Context context, List list, int i3) {
        Trace.a("getFontSync");
        try {
            LruCache lruCache = f34200a;
            Typeface typeface = (Typeface) lruCache.get(str);
            if (typeface != null) {
                return new TypefaceResult(typeface);
            }
            FontsContractCompat.FontFamilyResult fontFamilyResultE = FontProvider.e(context, list, null);
            int iB = b(fontFamilyResultE);
            if (iB != 0) {
                return new TypefaceResult(iB);
            }
            Typeface typefaceB = (!fontFamilyResultE.f() || Build.VERSION.SDK_INT < 29) ? TypefaceCompat.b(context, null, fontFamilyResultE.c(), i3) : TypefaceCompat.c(context, null, fontFamilyResultE.d(), i3);
            if (typefaceB == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, typefaceB);
            return new TypefaceResult(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        } finally {
            Trace.b();
        }
    }

    static Typeface d(final Context context, final List list, final int i3, Executor executor, final CallbackWrapper callbackWrapper) {
        final String strA = a(list, i3);
        Typeface typeface = (Typeface) f34200a.get(strA);
        if (typeface != null) {
            callbackWrapper.b(new TypefaceResult(typeface));
            return typeface;
        }
        Consumer<TypefaceResult> consumer = new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.2
            @Override // androidx.core.util.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(TypefaceResult typefaceResult) {
                if (typefaceResult == null) {
                    typefaceResult = new TypefaceResult(-3);
                }
                callbackWrapper.b(typefaceResult);
            }
        };
        synchronized (f34202c) {
            try {
                SimpleArrayMap simpleArrayMap = f34203d;
                ArrayList arrayList = (ArrayList) simpleArrayMap.get(strA);
                if (arrayList != null) {
                    arrayList.add(consumer);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(consumer);
                simpleArrayMap.put(strA, arrayList2);
                Callable<TypefaceResult> callable = new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.3
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public TypefaceResult call() {
                        try {
                            return FontRequestWorker.c(strA, context, list, i3);
                        } catch (Throwable unused) {
                            return new TypefaceResult(-3);
                        }
                    }
                };
                if (executor == null) {
                    executor = f34201b;
                }
                RequestExecutor.c(executor, callable, new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.4
                    @Override // androidx.core.util.Consumer
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void accept(TypefaceResult typefaceResult) {
                        synchronized (FontRequestWorker.f34202c) {
                            try {
                                SimpleArrayMap simpleArrayMap2 = FontRequestWorker.f34203d;
                                ArrayList arrayList3 = (ArrayList) simpleArrayMap2.get(strA);
                                if (arrayList3 == null) {
                                    return;
                                }
                                simpleArrayMap2.remove(strA);
                                for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                                    ((Consumer) arrayList3.get(i4)).accept(typefaceResult);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(final Context context, final FontRequest fontRequest, CallbackWrapper callbackWrapper, final int i3, int i4) {
        final String strA = a(c.a(new Object[]{fontRequest}), i3);
        Typeface typeface = (Typeface) f34200a.get(strA);
        if (typeface != null) {
            callbackWrapper.b(new TypefaceResult(typeface));
            return typeface;
        }
        if (i4 == -1) {
            TypefaceResult typefaceResultC = c(strA, context, c.a(new Object[]{fontRequest}), i3);
            callbackWrapper.b(typefaceResultC);
            return typefaceResultC.f34214a;
        }
        try {
            TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.d(f34201b, new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public TypefaceResult call() {
                    return FontRequestWorker.c(strA, context, c.a(new Object[]{fontRequest}), i3);
                }
            }, i4);
            callbackWrapper.b(typefaceResult);
            return typefaceResult.f34214a;
        } catch (InterruptedException unused) {
            callbackWrapper.b(new TypefaceResult(-3));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TypefaceResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Typeface f34214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f34215b;

        TypefaceResult(int i3) {
            this.f34214a = null;
            this.f34215b = i3;
        }

        boolean a() {
            return this.f34215b == 0;
        }

        TypefaceResult(Typeface typeface) {
            this.f34214a = typeface;
            this.f34215b = 0;
        }
    }
}
