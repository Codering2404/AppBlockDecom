package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieCompositionFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f56315a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f56316b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f56317c = {80, 75, 3, 4};

    private static boolean A(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean B(BufferedSource bufferedSource) {
        try {
            BufferedSource bufferedSourcePeek = bufferedSource.peek();
            for (byte b3 : f56317c) {
                if (bufferedSourcePeek.readByte() != b3) {
                    return Boolean.FALSE;
                }
            }
            bufferedSourcePeek.close();
            return Boolean.TRUE;
        } catch (Exception e3) {
            Logger.b("Failed to check zip file header", e3);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    private static void C(boolean z2) {
        ArrayList arrayList = new ArrayList(f56316b);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ((LottieTaskIdleListener) arrayList.get(i3)).a(z2);
        }
    }

    private static String D(Context context, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(A(context) ? "_night_" : "_day_");
        sb.append(i3);
        return sb.toString();
    }

    public static /* synthetic */ LottieResult a(WeakReference weakReference, Context context, int i3, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i3, str);
    }

    public static /* synthetic */ LottieResult b(Context context, String str, String str2) {
        LottieResult lottieResultC = L.e(context).c(context, str, str2);
        if (str2 != null && lottieResultC.b() != null) {
            LottieCompositionCache.b().c(str2, (LottieComposition) lottieResultC.b());
        }
        return lottieResultC;
    }

    public static /* synthetic */ void c(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map map = f56315a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            C(true);
        }
    }

    public static /* synthetic */ void f(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map map = f56315a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            C(true);
        }
    }

    public static /* synthetic */ LottieResult g(LottieComposition lottieComposition) {
        return new LottieResult(lottieComposition);
    }

    private static LottieTask h(final String str, Callable callable) {
        final LottieComposition lottieCompositionA = str == null ? null : LottieCompositionCache.b().a(str);
        if (lottieCompositionA != null) {
            return new LottieTask(new Callable() { // from class: com.airbnb.lottie.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return LottieCompositionFactory.g(lottieCompositionA);
                }
            });
        }
        if (str != null) {
            Map map = f56315a;
            if (map.containsKey(str)) {
                return (LottieTask) map.get(str);
            }
        }
        LottieTask lottieTask = new LottieTask(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask.d(new LottieListener() { // from class: com.airbnb.lottie.h
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.f(str, atomicBoolean, (LottieComposition) obj);
                }
            });
            lottieTask.c(new LottieListener() { // from class: com.airbnb.lottie.i
                @Override // com.airbnb.lottie.LottieListener
                public final void onResult(Object obj) {
                    LottieCompositionFactory.c(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map map2 = f56315a;
                map2.put(str, lottieTask);
                if (map2.size() == 1) {
                    C(false);
                }
            }
        }
        return lottieTask;
    }

    private static LottieImageAsset i(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset lottieImageAsset : lottieComposition.j().values()) {
            if (lottieImageAsset.b().equals(str)) {
                return lottieImageAsset;
            }
        }
        return null;
    }

    public static LottieTask j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static LottieTask k(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: com.airbnb.lottie.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.m(applicationContext, str, str2);
            }
        });
    }

    public static LottieResult l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static LottieResult m(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return o(context.getAssets().open(str), str2);
            }
            return y(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e3) {
            return new LottieResult((Throwable) e3);
        }
    }

    public static LottieTask n(final InputStream inputStream, final String str) {
        return h(str, new Callable() { // from class: com.airbnb.lottie.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.o(inputStream, str);
            }
        });
    }

    public static LottieResult o(InputStream inputStream, String str) {
        return p(inputStream, str, true);
    }

    private static LottieResult p(InputStream inputStream, String str, boolean z2) {
        try {
            return q(JsonReader.z(Okio.d(Okio.l(inputStream))), str);
        } finally {
            if (z2) {
                Utils.c(inputStream);
            }
        }
    }

    public static LottieResult q(JsonReader jsonReader, String str) {
        return r(jsonReader, str, true);
    }

    private static LottieResult r(JsonReader jsonReader, String str, boolean z2) {
        try {
            try {
                LottieComposition lottieCompositionA = LottieCompositionMoshiParser.a(jsonReader);
                if (str != null) {
                    LottieCompositionCache.b().c(str, lottieCompositionA);
                }
                LottieResult lottieResult = new LottieResult(lottieCompositionA);
                if (z2) {
                    Utils.c(jsonReader);
                }
                return lottieResult;
            } catch (Exception e3) {
                LottieResult lottieResult2 = new LottieResult((Throwable) e3);
                if (z2) {
                    Utils.c(jsonReader);
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (z2) {
                Utils.c(jsonReader);
            }
            throw th;
        }
    }

    public static LottieTask s(Context context, int i3) {
        return t(context, i3, D(context, i3));
    }

    public static LottieTask t(Context context, final int i3, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: com.airbnb.lottie.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.a(weakReference, applicationContext, i3, str);
            }
        });
    }

    public static LottieResult u(Context context, int i3) {
        return v(context, i3, D(context, i3));
    }

    public static LottieResult v(Context context, int i3, String str) {
        try {
            BufferedSource bufferedSourceD = Okio.d(Okio.l(context.getResources().openRawResource(i3)));
            return B(bufferedSourceD).booleanValue() ? y(context, new ZipInputStream(bufferedSourceD.H2()), str) : o(bufferedSourceD.H2(), str);
        } catch (Resources.NotFoundException e3) {
            return new LottieResult((Throwable) e3);
        }
    }

    public static LottieTask w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static LottieTask x(final Context context, final String str, final String str2) {
        return h(str2, new Callable() { // from class: com.airbnb.lottie.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LottieCompositionFactory.b(context, str, str2);
            }
        });
    }

    public static LottieResult y(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return z(context, zipInputStream, str);
        } finally {
            Utils.c(zipInputStream);
        }
    }

    private static LottieResult z(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            LottieComposition lottieComposition = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    lottieComposition = (LottieComposition) r(JsonReader.z(Okio.d(Okio.l(zipInputStream))), null, false).b();
                } else if (name.contains(".png") || name.contains(".webp") || name.contains(".jpg") || name.contains(".jpeg")) {
                    String[] strArrSplit = name.split("/");
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else if (name.contains(".ttf") || name.contains(".otf")) {
                    String[] strArrSplit2 = name.split("/");
                    String str2 = strArrSplit2[strArrSplit2.length - 1];
                    String str3 = str2.split("\\.")[0];
                    File file = new File(context.getCacheDir(), str2);
                    new FileOutputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        Logger.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                    }
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i3 = zipInputStream.read(bArr);
                            if (i3 == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i3);
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            Logger.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                        }
                        map2.put(str3, typefaceCreateFromFile);
                    } catch (Throwable th2) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (lottieComposition == null) {
                return new LottieResult((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                LottieImageAsset lottieImageAssetI = i(lottieComposition, (String) entry.getKey());
                if (lottieImageAssetI != null) {
                    lottieImageAssetI.f(Utils.k((Bitmap) entry.getValue(), lottieImageAssetI.e(), lottieImageAssetI.c()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z2 = false;
                for (Font font : lottieComposition.g().values()) {
                    if (font.a().equals(entry2.getKey())) {
                        font.e((Typeface) entry2.getValue());
                        z2 = true;
                    }
                }
                if (!z2) {
                    Logger.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (map.isEmpty()) {
                Iterator it = lottieComposition.j().entrySet().iterator();
                while (it.hasNext()) {
                    LottieImageAsset lottieImageAsset = (LottieImageAsset) ((Map.Entry) it.next()).getValue();
                    if (lottieImageAsset == null) {
                        return null;
                    }
                    String strB = lottieImageAsset.b();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                            lottieImageAsset.f(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException e3) {
                            Logger.d("data URL did not have correct base64 format.", e3);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry entry3 : lottieComposition.j().entrySet()) {
                if (((LottieImageAsset) entry3.getValue()).a() == null) {
                    return new LottieResult((Throwable) new IllegalStateException("There is no image for " + ((LottieImageAsset) entry3.getValue()).b()));
                }
            }
            if (str != null) {
                LottieCompositionCache.b().c(str, lottieComposition);
            }
            return new LottieResult(lottieComposition);
        } catch (IOException e4) {
            return new LottieResult((Throwable) e4);
        }
    }
}
