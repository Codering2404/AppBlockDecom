package com.airbnb.lottie;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class LottieResult<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f56383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Throwable f56384b;

    public LottieResult(Object obj) {
        this.f56383a = obj;
        this.f56384b = null;
    }

    public Throwable a() {
        return this.f56384b;
    }

    public Object b() {
        return this.f56383a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        if (b() != null && b().equals(lottieResult.b())) {
            return true;
        }
        if (a() == null || lottieResult.a() == null) {
            return false;
        }
        return a().toString().equals(a().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{b(), a()});
    }

    public LottieResult(Throwable th) {
        this.f56384b = th;
        this.f56383a = null;
    }
}
