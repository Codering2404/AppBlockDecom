package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfq extends zzhet {
    private final zzhfx zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzhfq(zzhfx zzhfxVar, zzibb zzibbVar, zziaz zziazVar, Integer num, byte[] bArr) {
        this.zza = zzhfxVar;
        this.zzb = zzibbVar;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    public static zzhfp zzd() {
        return new zzhfp(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhet, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhet
    public final zziaz zzc() {
        return this.zzc;
    }

    public final zzibb zze() {
        return this.zzb;
    }

    public final zzhfx zzf() {
        return this.zza;
    }
}
