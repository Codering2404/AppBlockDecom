package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhey extends zzhet {
    private final zzhfg zza;
    private final zzibb zzb;
    private final zzibb zzc;
    private final zziaz zzd;

    @Nullable
    private final Integer zze;

    /* synthetic */ zzhey(zzhfg zzhfgVar, zzibb zzibbVar, zzibb zzibbVar2, zziaz zziazVar, Integer num, byte[] bArr) {
        this.zza = zzhfgVar;
        this.zzb = zzibbVar;
        this.zzc = zzibbVar2;
        this.zzd = zziazVar;
        this.zze = num;
    }

    public static zzhex zzd() {
        return new zzhex(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhet, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhet
    public final zziaz zzc() {
        return this.zzd;
    }

    public final zzibb zze() {
        return this.zzb;
    }

    public final zzibb zzf() {
        return this.zzc;
    }

    public final zzhfg zzg() {
        return this.zza;
    }
}
