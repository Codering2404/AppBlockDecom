package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdol implements zzbpq {
    private final WeakReference zza;
    private final WeakReference zzb;

    /* synthetic */ zzdol(zzdon zzdonVar, View view, byte[] bArr) {
        this.zza = new WeakReference(zzdonVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzot)).booleanValue()) {
            this.zzb = new WeakReference(view);
        } else {
            this.zzb = new WeakReference(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        zzdon zzdonVar = (zzdon) this.zza.get();
        if (zzdonVar == null) {
            return;
        }
        zzdonVar.zzC().zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzot)).booleanValue()) {
            zzdonVar.zzB((View) this.zzb.get());
        }
    }
}
