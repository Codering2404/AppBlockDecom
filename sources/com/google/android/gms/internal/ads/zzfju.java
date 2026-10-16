package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfju implements OnAdMetadataChangedListener {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdn zza;
    final /* synthetic */ zzfjw zzb;

    zzfju(zzfjw zzfjwVar, com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        this.zza = zzdnVar;
        Objects.requireNonNull(zzfjwVar);
        this.zzb = zzfjwVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        if (this.zzb.zzw() != null) {
            try {
                this.zza.zze();
            } catch (RemoteException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            }
        }
    }
}
