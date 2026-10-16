package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwe extends zzbvk {
    private final MediationInterscrollerAd zza;

    public zzbwe(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zza = mediationInterscrollerAd;
    }

    @Override // com.google.android.gms.internal.ads.zzbvl
    public final IObjectWrapper zze() {
        return ObjectWrapper.i5(this.zza.a());
    }

    @Override // com.google.android.gms.internal.ads.zzbvl
    public final boolean zzf() {
        return this.zza.b();
    }
}
