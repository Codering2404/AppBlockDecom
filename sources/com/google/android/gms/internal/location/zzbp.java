package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzbp implements RemoteCall {
    private final /* synthetic */ CurrentLocationRequest zza;
    private final /* synthetic */ CancellationToken zzb;

    /* synthetic */ zzbp(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken) {
        this.zza = currentLocationRequest;
        this.zzb = cancellationToken;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        Api api = zzbi.zzb;
        ((zzdz) obj).zzr(this.zza, this.zzb, (TaskCompletionSource) obj2);
    }
}
