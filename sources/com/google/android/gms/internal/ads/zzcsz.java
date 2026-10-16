package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.glance.color.Tq.KqqtdetwHMIO;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcsz implements zzddm {
    private final zzflw zza;

    public zzcsz(zzflw zzflwVar) {
        this.zza = zzflwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zza(Context context) {
        try {
            this.zza.zzi();
        } catch (zzflf e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke onPause for the mediation adapter.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzc(Context context) {
        try {
            this.zza.zzf();
        } catch (zzflf e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Cannot invoke onDestroy for the mediation adapter.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzb(Context context) {
        try {
            zzflw zzflwVar = this.zza;
            zzflwVar.zzj();
            if (context != null) {
                zzflwVar.zzp(context);
            }
        } catch (zzflf e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.g(KqqtdetwHMIO.unOTTvrWJMOS, e3);
        }
    }
}
