package com.google.android.gms.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc {
    public static AdSize a(int i3, int i4, String str) {
        return new AdSize(i3, i4, str);
    }

    public static AdSize b(int i3, int i4) {
        AdSize adSize = new AdSize(i3, i4);
        adSize.j(true);
        adSize.k(i4);
        return adSize;
    }

    public static AdSize c(int i3, int i4) {
        AdSize adSize = new AdSize(i3, i4);
        adSize.n(true);
        adSize.p(i4);
        return adSize;
    }

    public static boolean d(AdSize adSize) {
        return adSize.m();
    }

    public static int e(AdSize adSize) {
        return adSize.o();
    }

    public static boolean f(AdSize adSize) {
        return adSize.g();
    }

    public static boolean g(AdSize adSize) {
        return adSize.i();
    }

    public static int h(AdSize adSize) {
        return adSize.l();
    }

    public static boolean i(AdSize adSize) {
        return adSize.h();
    }
}
