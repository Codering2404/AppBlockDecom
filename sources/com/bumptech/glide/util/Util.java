package com.bumptech.glide.util;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bumptech.glide.load.model.Model;
import com.bumptech.glide.request.BaseRequestOptions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f67295a = "0123456789abcdef".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f67296b = new char[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Handler f67297c;

    /* JADX INFO: renamed from: com.bumptech.glide.util.Util$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67298a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f67298a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67298a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67298a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67298a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67298a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void a() {
        if (!s()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!t()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(BaseRequestOptions baseRequestOptions, BaseRequestOptions baseRequestOptions2) {
        return baseRequestOptions == null ? baseRequestOptions2 == null : baseRequestOptions.J(baseRequestOptions2);
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj instanceof Model ? ((Model) obj).a(obj2) : obj.equals(obj2);
    }

    public static boolean e(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static String f(byte[] bArr, char[] cArr) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b3 = bArr[i3];
            int i4 = i3 * 2;
            char[] cArr2 = f67295a;
            cArr[i4] = cArr2[(b3 & 255) >>> 4];
            cArr[i4 + 1] = cArr2[b3 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static Queue g(int i3) {
        return new ArrayDeque(i3);
    }

    public static int h(int i3, int i4, Bitmap.Config config) {
        return i3 * i4 * j(config);
    }

    public static int i(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int j(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i3 = AnonymousClass1.f67298a[config.ordinal()];
        int i4 = 1;
        if (i3 != 1) {
            i4 = 2;
            if (i3 != 2 && i3 != 3) {
                return i3 != 4 ? 4 : 8;
            }
        }
        return i4;
    }

    public static List k(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static Handler l() {
        if (f67297c == null) {
            synchronized (Util.class) {
                try {
                    if (f67297c == null) {
                        f67297c = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f67297c;
    }

    public static int m(float f3) {
        return n(f3, 17);
    }

    public static int n(float f3, int i3) {
        return p(Float.floatToIntBits(f3), i3);
    }

    public static int o(int i3) {
        return p(i3, 17);
    }

    public static int p(int i3, int i4) {
        return (i4 * 31) + i3;
    }

    public static int q(Object obj, int i3) {
        return p(obj == null ? 0 : obj.hashCode(), i3);
    }

    public static int r(boolean z2, int i3) {
        return p(z2 ? 1 : 0, i3);
    }

    public static boolean s() {
        return !t();
    }

    public static boolean t() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean u(int i3) {
        return i3 > 0 || i3 == Integer.MIN_VALUE;
    }

    public static boolean v(int i3, int i4) {
        return u(i3) && u(i4);
    }

    public static void w(Runnable runnable) {
        l().postAtFrontOfQueue(runnable);
    }

    public static void x(Runnable runnable) {
        l().post(runnable);
    }

    public static void y(Runnable runnable) {
        l().removeCallbacks(runnable);
    }

    public static String z(byte[] bArr) {
        String strF;
        char[] cArr = f67296b;
        synchronized (cArr) {
            strF = f(bArr, cArr);
        }
        return strF;
    }
}
