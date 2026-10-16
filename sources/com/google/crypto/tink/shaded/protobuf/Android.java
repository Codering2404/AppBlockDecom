package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class Android {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f86644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f86645b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f86646c;

    static {
        f86646c = (f86644a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class b() {
        return f86645b;
    }

    static boolean c() {
        if (f86644a) {
            return true;
        }
        return (f86645b == null || f86646c) ? false : true;
    }
}
