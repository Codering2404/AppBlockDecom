package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfhp implements zzgta {
    final /* synthetic */ zzfhs zza;

    zzfhp(zzfhs zzfhsVar) {
        Objects.requireNonNull(zzfhsVar);
        this.zza = zzfhsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzcbd zzcbdVar = (zzcbd) obj;
        zzfhq zzfhqVar = new zzfhq(zzcbdVar, new zzfmz(zzcbdVar.zzj), null);
        zzfhs zzfhsVar = this.zza;
        zzfhsVar.zzd(zzfhqVar);
        return zzfhsVar.zzc();
    }
}
