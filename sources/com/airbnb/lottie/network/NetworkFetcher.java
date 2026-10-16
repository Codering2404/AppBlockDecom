package com.airbnb.lottie.network;

import android.content.Context;
import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkCache f56942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LottieNetworkFetcher f56943b;

    public NetworkFetcher(NetworkCache networkCache, LottieNetworkFetcher lottieNetworkFetcher) {
        this.f56942a = networkCache;
        this.f56943b = lottieNetworkFetcher;
    }

    private LottieComposition a(Context context, String str, String str2) {
        NetworkCache networkCache;
        Pair pairA;
        if (str2 == null || (networkCache = this.f56942a) == null || (pairA = networkCache.a(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) pairA.first;
        InputStream inputStream = (InputStream) pairA.second;
        LottieResult lottieResultY = fileExtension == FileExtension.ZIP ? LottieCompositionFactory.y(context, new ZipInputStream(inputStream), str2) : LottieCompositionFactory.o(inputStream, str2);
        if (lottieResultY.b() != null) {
            return (LottieComposition) lottieResultY.b();
        }
        return null;
    }

    private LottieResult b(Context context, String str, String str2) {
        LottieResult lottieResult;
        Logger.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                LottieFetchResult lottieFetchResultA = this.f56943b.a(str);
                if (lottieFetchResultA.isSuccessful()) {
                    lottieResult = d(context, str, lottieFetchResultA.I0(), lottieFetchResultA.B0(), str2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Completed fetch from network. Success: ");
                    sb.append(lottieResult.b() != null);
                    Logger.a(sb.toString());
                } else {
                    lottieResult = new LottieResult((Throwable) new IllegalArgumentException(lottieFetchResultA.p()));
                }
                try {
                    lottieFetchResultA.close();
                    return lottieResult;
                } catch (IOException e3) {
                    Logger.d("LottieFetchResult close failed ", e3);
                    return lottieResult;
                }
            } catch (Exception e4) {
                LottieResult lottieResult2 = new LottieResult((Throwable) e4);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e5) {
                        Logger.d("LottieFetchResult close failed ", e5);
                    }
                }
                return lottieResult2;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            try {
                closeable.close();
                throw th;
            } catch (IOException e6) {
                Logger.d("LottieFetchResult close failed ", e6);
                throw th;
            }
        }
    }

    private LottieResult d(Context context, String str, InputStream inputStream, String str2, String str3) {
        LottieResult lottieResultF;
        FileExtension fileExtension;
        NetworkCache networkCache;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.a("Handling zip response.");
            FileExtension fileExtension2 = FileExtension.ZIP;
            lottieResultF = f(context, str, inputStream, str3);
            fileExtension = fileExtension2;
        } else {
            Logger.a("Received json response.");
            fileExtension = FileExtension.JSON;
            lottieResultF = e(str, inputStream, str3);
        }
        if (str3 != null && lottieResultF.b() != null && (networkCache = this.f56942a) != null) {
            networkCache.e(str, fileExtension);
        }
        return lottieResultF;
    }

    private LottieResult e(String str, InputStream inputStream, String str2) {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.f56942a) == null) ? LottieCompositionFactory.o(inputStream, null) : LottieCompositionFactory.o(new FileInputStream(networkCache.f(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }

    private LottieResult f(Context context, String str, InputStream inputStream, String str2) {
        NetworkCache networkCache;
        return (str2 == null || (networkCache = this.f56942a) == null) ? LottieCompositionFactory.y(context, new ZipInputStream(inputStream), null) : LottieCompositionFactory.y(context, new ZipInputStream(new FileInputStream(networkCache.f(str, inputStream, FileExtension.ZIP))), str);
    }

    public LottieResult c(Context context, String str, String str2) {
        LottieComposition lottieCompositionA = a(context, str, str2);
        if (lottieCompositionA != null) {
            return new LottieResult(lottieCompositionA);
        }
        Logger.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }
}
