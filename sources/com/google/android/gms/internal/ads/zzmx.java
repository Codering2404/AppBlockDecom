package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmx extends zzwy {
    private final zzbe zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzmx(zzmy zzmyVar, zzbf zzbfVar) {
        super(zzbfVar);
        Objects.requireNonNull(zzmyVar);
        this.zzc = new zzbe();
    }

    @Override // com.google.android.gms.internal.ads.zzwy, com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i3, zzbd zzbdVar, boolean z2) {
        zzbf zzbfVar = this.zzb;
        zzbd zzbdVarZzd = zzbfVar.zzd(i3, zzbdVar, z2);
        if (zzbfVar.zzb(zzbdVarZzd.zzc, this.zzc, 0L).zzb()) {
            zzbdVarZzd.zza(zzbdVar.zza, zzbdVar.zzb, zzbdVar.zzc, zzbdVar.zzd, 0L, zzc.zza, true);
            return zzbdVarZzd;
        }
        zzbdVarZzd.zzf = true;
        return zzbdVarZzd;
    }
}
