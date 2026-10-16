package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum zzjj {
    STORAGE(zzjk.AD_STORAGE, zzjk.ANALYTICS_STORAGE),
    DMA(zzjk.AD_USER_DATA);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzjk[] f74008a;

    zzjj(zzjk... zzjkVarArr) {
        this.f74008a = zzjkVarArr;
    }

    public final zzjk[] a() {
        return this.f74008a;
    }

    final /* synthetic */ zzjk[] b() {
        return this.f74008a;
    }
}
