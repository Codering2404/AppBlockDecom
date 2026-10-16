package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzec extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzec(zzfb zzfbVar, boolean z2, int i3, String str, Object obj, Object obj2, Object obj3) {
        super(zzfbVar, false);
        this.zza = str;
        this.zzb = obj;
        Objects.requireNonNull(zzfbVar);
        this.zzc = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        ((zzcr) Preconditions.m(this.zzc.zzQ())).logHealthData(5, this.zza, ObjectWrapper.i5(this.zzb), ObjectWrapper.i5(null), ObjectWrapper.i5(null));
    }
}
