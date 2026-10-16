package com.airbnb.lottie;

import android.content.Context;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f56253a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f56254b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f56255c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f56256d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String[] f56257e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long[] f56258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f56259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f56260h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static LottieNetworkFetcher f56261i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static LottieNetworkCacheProvider f56262j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile NetworkFetcher f56263k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile NetworkCache f56264l;

    public static void a(String str) {
        if (f56254b) {
            int i3 = f56259g;
            if (i3 == 20) {
                f56260h++;
                return;
            }
            f56257e[i3] = str;
            f56258f[i3] = System.nanoTime();
            TraceCompat.a(str);
            f56259g++;
        }
    }

    public static float b(String str) {
        int i3 = f56260h;
        if (i3 > 0) {
            f56260h = i3 - 1;
            return 0.0f;
        }
        if (!f56254b) {
            return 0.0f;
        }
        int i4 = f56259g - 1;
        f56259g = i4;
        if (i4 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f56257e[i4])) {
            TraceCompat.b();
            return (System.nanoTime() - f56258f[f56259g]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f56257e[f56259g] + ".");
    }

    public static boolean c() {
        return f56256d;
    }

    public static NetworkCache d(Context context) {
        NetworkCache networkCache;
        if (!f56255c) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        NetworkCache networkCache2 = f56264l;
        if (networkCache2 != null) {
            return networkCache2;
        }
        synchronized (NetworkCache.class) {
            try {
                networkCache = f56264l;
                if (networkCache == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = f56262j;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new LottieNetworkCacheProvider() { // from class: com.airbnb.lottie.L.1
                            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
                            public File a() {
                                return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    networkCache = new NetworkCache(lottieNetworkCacheProvider);
                    f56264l = networkCache;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return networkCache;
    }

    public static NetworkFetcher e(Context context) {
        NetworkFetcher networkFetcher;
        NetworkFetcher networkFetcher2 = f56263k;
        if (networkFetcher2 != null) {
            return networkFetcher2;
        }
        synchronized (NetworkFetcher.class) {
            try {
                networkFetcher = f56263k;
                if (networkFetcher == null) {
                    NetworkCache networkCacheD = d(context);
                    LottieNetworkFetcher defaultLottieNetworkFetcher = f56261i;
                    if (defaultLottieNetworkFetcher == null) {
                        defaultLottieNetworkFetcher = new DefaultLottieNetworkFetcher();
                    }
                    networkFetcher = new NetworkFetcher(networkCacheD, defaultLottieNetworkFetcher);
                    f56263k = networkFetcher;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return networkFetcher;
    }
}
