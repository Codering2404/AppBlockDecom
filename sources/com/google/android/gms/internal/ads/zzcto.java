package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcto implements zzhbt {
    final /* synthetic */ zzctv zza;

    zzcto(zzctv zzctvVar) {
        Objects.requireNonNull(zzctvVar);
        this.zza = zzctvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzctv zzctvVar = this.zza;
        zzctvVar.zzu().zzb(zzctvVar.zzt().zzb(zzctvVar.zzr(), zzctvVar.zzs(), false, "", (String) obj, zzctvVar.zzs().zzc, null, null), true == com.google.android.gms.ads.internal.zzt.l().zzs(zzctvVar.zzq()) ? 2 : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }
}
