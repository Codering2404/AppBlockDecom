package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfo extends zzdp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnPaidEventListener f69946a;

    public zzfo(OnPaidEventListener onPaidEventListener) {
        this.f69946a = onPaidEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void p4(zzt zztVar) {
        OnPaidEventListener onPaidEventListener = this.f69946a;
        if (onPaidEventListener != null) {
            onPaidEventListener.a(AdValue.a(zztVar.f70021b, zztVar.f70022c, zztVar.f70023d));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final boolean zzf() {
        return this.f69946a == null;
    }
}
