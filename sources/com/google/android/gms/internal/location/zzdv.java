package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdv extends com.google.android.gms.location.zzv {
    private final zzdr zza;

    zzdv(zzdr zzdrVar) {
        this.zza = zzdrVar;
    }

    final zzdv zzc(ListenerHolder listenerHolder) {
        this.zza.zzb(listenerHolder);
        return this;
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzd(LocationResult locationResult) throws RemoteException {
        this.zza.zza().c(new zzds(this, locationResult));
    }

    @Override // com.google.android.gms.location.zzw
    public final void zze(LocationAvailability locationAvailability) throws RemoteException {
        this.zza.zza().c(new zzdt(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.zzw
    public final void zzf() {
        this.zza.zza().c(new zzdu(this));
    }

    final void zzg() {
        this.zza.zza().a();
    }

    final /* synthetic */ zzdr zzh() {
        return this.zza;
    }
}
