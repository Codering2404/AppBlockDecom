package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LogcatLogger implements LottieLogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set f57087a = new HashSet();

    @Override // com.airbnb.lottie.LottieLogger
    public void a(String str) {
        d(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void b(String str, Throwable th) {
        if (L.f56253a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void c(String str) {
        e(str, null);
    }

    @Override // com.airbnb.lottie.LottieLogger
    public void d(String str, Throwable th) {
        Set set = f57087a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    public void e(String str, Throwable th) {
        if (L.f56253a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
