package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzcd implements zzbg {
    static final /* synthetic */ zzcd zza = new zzcd();

    private /* synthetic */ zzcd() {
    }

    @Override // com.google.android.gms.internal.location.zzbg
    public final /* synthetic */ void zza(zzdz zzdzVar, ListenerHolder.ListenerKey listenerKey, boolean z2, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdzVar.zzv(listenerKey, z2, taskCompletionSource);
    }
}
