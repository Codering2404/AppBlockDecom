package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfz extends zzhet {
    private final zzhgg zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzhfz(zzhgg zzhggVar, zzibb zzibbVar, zziaz zziazVar, Integer num, byte[] bArr) {
        this.zza = zzhggVar;
        this.zzb = zzibbVar;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    public static zzhfy zzd() {
        return new zzhfy(null);
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

    public final zzhgg zzf() {
        return this.zza;
    }
}
