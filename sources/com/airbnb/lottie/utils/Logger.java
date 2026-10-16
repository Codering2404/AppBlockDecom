package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LottieLogger f57088a = new LogcatLogger();

    public static void a(String str) {
        f57088a.c(str);
    }

    public static void b(String str, Throwable th) {
        f57088a.b(str, th);
    }

    public static void c(String str) {
        f57088a.a(str);
    }

    public static void d(String str, Throwable th) {
        f57088a.d(str, th);
    }
}
