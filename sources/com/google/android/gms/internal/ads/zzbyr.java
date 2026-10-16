package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyr extends zzbnr {
    private final NativeAd.UnconfirmedClickListener zza;

    public zzbyr(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbns
    public final void zze(String str) {
        this.zza.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbns
    public final void zzf() {
        this.zza.b();
    }
}
