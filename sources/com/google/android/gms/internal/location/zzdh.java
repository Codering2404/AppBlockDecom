package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdh extends LocationCallback {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzdz zzb;

    zzdh(zzdz zzdzVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        this.zzb = zzdzVar;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public final void onLocationResult(LocationResult locationResult) {
        this.zza.trySetResult(locationResult.M());
        try {
            this.zzb.zzw(ListenerHolders.c(this, "GetCurrentLocation"), false, new TaskCompletionSource());
        } catch (RemoteException unused) {
        }
    }
}
