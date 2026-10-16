package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfho implements zzgta {
    final /* synthetic */ zzfhs zza;

    zzfho(zzfhs zzfhsVar) {
        Objects.requireNonNull(zzfhsVar);
        this.zza = zzfhsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.d("", (zzegr) obj);
        com.google.android.gms.ads.internal.util.zze.k("Failed to get a cache key, reverting to legacy flow.");
        zzfhs zzfhsVar = this.zza;
        zzfhsVar.zzd(new zzfhq(null, zzfhsVar.zzb(), null));
        return zzfhsVar.zzc();
    }
}
