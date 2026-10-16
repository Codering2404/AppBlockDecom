package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdy extends com.google.android.gms.location.zzy {
    private final zzdr zza;

    zzdy(zzdr zzdrVar) {
        this.zza = zzdrVar;
    }

    final zzdy zzc(ListenerHolder listenerHolder) {
        this.zza.zzb(listenerHolder);
        return this;
    }

    @Override // com.google.android.gms.location.zzz
    public final void zzd(Location location) {
        this.zza.zza().c(new zzdw(this, location));
    }

    @Override // com.google.android.gms.location.zzz
    public final void zze() {
        this.zza.zza().c(new zzdx(this));
    }

    final void zzf() {
        this.zza.zza().a();
    }

    final /* synthetic */ zzdr zzg() {
        return this.zza;
    }
}
