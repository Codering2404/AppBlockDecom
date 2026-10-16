package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzac extends zzae {
    final /* synthetic */ long zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzac(zzaf zzafVar, GoogleApiClient googleApiClient, long j3, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = j3;
        this.zzb = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        PendingIntent pendingIntent = this.zzb;
        zzg zzgVar = (zzg) anyClient;
        Preconditions.m(pendingIntent);
        long j3 = this.zza;
        Preconditions.b(j3 >= 0, "detectionIntervalMillis must be >= 0");
        ((zzv) zzgVar.getService()).zzh(j3, true, pendingIntent);
        setResult(Status.f71537g);
    }
}
