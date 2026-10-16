package com.google.android.gms.internal.ads;

import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhuy extends zzhxk {
    private final zzhuu zza;
    private final ECPoint zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzhuy(zzhuu zzhuuVar, ECPoint eCPoint, zziaz zziazVar, Integer num, byte[] bArr) {
        this.zza = zzhuuVar;
        this.zzb = eCPoint;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    public static zzhux zzc() {
        return new zzhux(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhxk, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    public final ECPoint zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhxk
    public final zziaz zze() {
        return this.zzc;
    }

    public final zzhuu zzf() {
        return this.zza;
    }
}
