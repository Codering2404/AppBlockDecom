package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbxl implements MediationAdLoadCallback {
    final /* synthetic */ zzbwm zza;
    final /* synthetic */ zzbvi zzb;
    final /* synthetic */ zzbxo zzc;

    zzbxl(zzbxo zzbxoVar, zzbwm zzbwmVar, zzbvi zzbviVar) {
        this.zza = zzbwmVar;
        this.zzb = zzbviVar;
        Objects.requireNonNull(zzbxoVar);
        this.zzc = zzbxoVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zza.zzg(adError.d());
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationAppOpenAd mediationAppOpenAd = (MediationAppOpenAd) obj;
        if (mediationAppOpenAd != null) {
            try {
                this.zzc.zzu(mediationAppOpenAd);
                this.zza.zze();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
            }
            return new zzbxp(this.zzb);
        }
        com.google.android.gms.ads.internal.util.client.zzo.f("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
        try {
            this.zza.zzf("Adapter returned null.");
            return null;
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e4);
            return null;
        }
    }
}
