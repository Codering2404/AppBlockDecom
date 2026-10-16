package com.google.android.gms.ads.h5;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbqx;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class H5AdsRequestHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbqx f69738a;

    public H5AdsRequestHandler(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        this.f69738a = new zzbqx(context, onH5AdsEventListener);
    }

    public void a() {
        this.f69738a.zzb();
    }

    public boolean b(String str) {
        return this.f69738a.zza(str);
    }
}
