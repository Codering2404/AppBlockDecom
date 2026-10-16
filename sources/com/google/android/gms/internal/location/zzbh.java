package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbh implements RemoteCall, zzdr {
    final /* synthetic */ zzbi zza;
    private final zzbg zzb;
    private ListenerHolder zzc;
    private boolean zzd = true;

    zzbh(zzbi zzbiVar, ListenerHolder listenerHolder, zzbg zzbgVar) {
        this.zza = zzbiVar;
        this.zzc = listenerHolder;
        this.zzb = zzbgVar;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) throws RemoteException {
        ListenerHolder.ListenerKey listenerKeyB;
        boolean z2;
        zzdz zzdzVar = (zzdz) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        synchronized (this) {
            listenerKeyB = this.zzc.b();
            z2 = this.zzd;
            this.zzc.a();
        }
        if (listenerKeyB == null) {
            taskCompletionSource.setResult(Boolean.FALSE);
        } else {
            this.zzb.zza(zzdzVar, listenerKeyB, z2, taskCompletionSource);
        }
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final synchronized ListenerHolder zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final synchronized void zzb(ListenerHolder listenerHolder) {
        ListenerHolder listenerHolder2 = this.zzc;
        if (listenerHolder2 != listenerHolder) {
            listenerHolder2.a();
            this.zzc = listenerHolder;
        }
    }

    @Override // com.google.android.gms.internal.location.zzdr
    public final void zzc() {
        ListenerHolder.ListenerKey<?> listenerKeyB;
        synchronized (this) {
            this.zzd = false;
            listenerKeyB = this.zzc.b();
        }
        if (listenerKeyB != null) {
            this.zza.doUnregisterEventListener(listenerKeyB, 2441);
        }
    }
}
