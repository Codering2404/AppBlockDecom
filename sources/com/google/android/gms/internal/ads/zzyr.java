package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyr extends zzwy {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzyr(zzyu zzyuVar, zzbf zzbfVar) {
        super(zzbfVar);
        Objects.requireNonNull(zzyuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwy, com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i3, zzbe zzbeVar, long j3) {
        this.zzb.zzb(i3, zzbeVar, j3);
        zzbeVar.zzk = true;
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwy, com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i3, zzbd zzbdVar, boolean z2) {
        this.zzb.zzd(i3, zzbdVar, z2);
        zzbdVar.zzf = true;
        return zzbdVar;
    }
}
