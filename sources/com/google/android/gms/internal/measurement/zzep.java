package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzep extends zzeq {
    final /* synthetic */ Long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ zzfb zzg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzep(zzfb zzfbVar, Long l3, String str, String str2, Bundle bundle, boolean z2, boolean z3) {
        super(zzfbVar, true);
        this.zza = l3;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bundle;
        this.zze = z2;
        this.zzf = z3;
        Objects.requireNonNull(zzfbVar);
        this.zzg = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        Long l3 = this.zza;
        ((zzcr) Preconditions.m(this.zzg.zzQ())).logEvent(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, l3 == null ? this.zzh : l3.longValue());
    }
}
