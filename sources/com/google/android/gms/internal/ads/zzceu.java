package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzceu implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcfw zzb;

    zzceu(zzcev zzcevVar, Context context, zzcfw zzcfwVar) {
        this.zza = context;
        this.zzb = zzcfwVar;
        Objects.requireNonNull(zzcevVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e3) {
            this.zzb.zzd(e3);
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception while getting advertising Id info", e3);
        }
    }
}
