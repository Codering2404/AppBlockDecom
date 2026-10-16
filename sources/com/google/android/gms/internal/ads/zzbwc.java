package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbwc implements MediationAdLoadCallback {
    final /* synthetic */ zzbvi zza;
    final /* synthetic */ zzbwd zzb;

    zzbwc(zzbwd zzbwdVar, zzbvi zzbviVar) {
        this.zza = zzbviVar;
        Objects.requireNonNull(zzbwdVar);
        this.zzb = zzbwdVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            String canonicalName = this.zzb.zzb().getClass().getCanonicalName();
            int iA = adError.a();
            String strC = adError.c();
            String strB = adError.b();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41 + String.valueOf(iA).length() + 17 + String.valueOf(strC).length() + 16 + String.valueOf(strB).length());
            sb.append(canonicalName);
            sb.append("failed to load mediation ad: ErrorCode = ");
            sb.append(iA);
            sb.append(". ErrorMessage = ");
            sb.append(strC);
            sb.append(". ErrorDomain = ");
            sb.append(strB);
            com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
            zzbvi zzbviVar = this.zza;
            zzbviVar.zzx(adError.d());
            zzbviVar.zzw(adError.a(), adError.c());
            zzbviVar.zzg(adError.a());
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        try {
            this.zzb.zzU((MediationAppOpenAd) obj);
            this.zza.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e3);
        }
        return new zzbvt(this.zza);
    }
}
