package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdo extends zzeq {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzfb zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdo(zzfb zzfbVar, Bundle bundle) {
        super(zzfbVar, true);
        this.zza = bundle;
        Objects.requireNonNull(zzfbVar);
        this.zzb = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        ((zzcr) Preconditions.m(this.zzb.zzQ())).setConsentThirdParty(this.zza, this.zzh);
    }
}
