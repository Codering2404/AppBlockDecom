package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.MuteThisAdListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdd extends zzdb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MuteThisAdListener f69848a;

    public zzdd(MuteThisAdListener muteThisAdListener) {
        this.f69848a = muteThisAdListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdc
    public final void zze() {
        this.f69848a.a();
    }
}
