package com.google.android.gms.ads.internal.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f70296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f70297b = Long.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f70298c = new Object();

    public zzbu(long j3) {
        this.f70296a = j3;
    }

    public final boolean a() {
        synchronized (this.f70298c) {
            try {
                long jA = com.google.android.gms.ads.internal.zzt.o().a();
                if (this.f70297b + this.f70296a > jA) {
                    return false;
                }
                this.f70297b = jA;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(long j3) {
        synchronized (this.f70298c) {
            this.f70296a = j3;
        }
    }
}
