package com.google.android.gms.ads.internal.overlay;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzq implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f70131a;

    zzq(long j3) {
        this.f70131a = j3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        if (AdOverlayInfoParcel.A.remove(Long.valueOf(this.f70131a)) == null) {
            return null;
        }
        com.google.android.gms.ads.internal.zzt.l().zzg(new Exception("Key was non-null in AdOverlayObjectsCleanupTask"), "AdOverlayObjectsCleanupTask");
        return null;
    }
}
