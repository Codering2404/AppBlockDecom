package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzend implements zzdno {
    final /* synthetic */ zzcfw zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzenf zzc;

    zzend(zzenf zzenfVar, zzcfw zzcfwVar, zzfkf zzfkfVar) {
        this.zza = zzcfwVar;
        this.zzb = zzfkfVar;
        Objects.requireNonNull(zzenfVar);
        this.zzc = zzenfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z2, Context context, zzdde zzddeVar) {
        try {
            com.google.android.gms.ads.internal.zzt.f();
            com.google.android.gms.ads.internal.overlay.zzn.a(context, (AdOverlayInfoParcel) this.zza.get(), true, this.zzc.zzd());
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zzb;
    }
}
