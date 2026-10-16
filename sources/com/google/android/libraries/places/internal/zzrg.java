package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzrg extends ThreadLocal {
    zzrg() {
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        zzrt zzrtVar = new zzrt(zzqw.a(Thread.currentThread()));
        Thread threadCurrentThread = Thread.currentThread();
        synchronized (zzrh.f78507c) {
            zzrh.f78507c.put(threadCurrentThread, zzrtVar);
        }
        return zzrtVar;
    }
}
