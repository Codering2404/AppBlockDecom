package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.util.Log;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzj implements ConsentInformation {
    private final zzaq zza;
    private final zzw zzb;
    private final zzbq zzc;
    private final zzcr zzf;
    private final Object zzd = new Object();
    private final Object zze = new Object();
    private boolean zzg = false;
    private boolean zzh = false;
    private ConsentRequestParameters zzi = new ConsentRequestParameters.Builder().build();

    public zzj(zzaq zzaqVar, zzw zzwVar, zzbq zzbqVar, zzcr zzcrVar) {
        this.zza = zzaqVar;
        this.zzb = zzwVar;
        this.zzc = zzbqVar;
        this.zzf = zzcrVar;
    }

    @Override // com.google.android.ump.ConsentInformation
    public final boolean canRequestAds() {
        zzaq zzaqVar = this.zza;
        if (!zzaqVar.zzk()) {
            int iZza = !zzc() ? 0 : zzaqVar.zza();
            if (iZza != 1 && iZza != 3) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.ump.ConsentInformation
    public final int getConsentStatus() {
        if (zzc()) {
            return this.zza.zza();
        }
        return 0;
    }

    @Override // com.google.android.ump.ConsentInformation
    public final ConsentInformation.PrivacyOptionsRequirementStatus getPrivacyOptionsRequirementStatus() {
        return !zzc() ? ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN : this.zza.zzb();
    }

    @Override // com.google.android.ump.ConsentInformation
    public final boolean isConsentFormAvailable() {
        return this.zzc.zzf();
    }

    @Override // com.google.android.ump.ConsentInformation
    public final void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        synchronized (this.zzd) {
            this.zzg = true;
        }
        this.zzi = consentRequestParameters;
        this.zzf.zzh();
        this.zzb.zzc(activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener);
    }

    @Override // com.google.android.ump.ConsentInformation
    public final void reset() {
        this.zzc.zzd(null);
        this.zza.zze();
        synchronized (this.zzd) {
            this.zzg = false;
        }
    }

    public final void zza(Activity activity) {
        if (zzc() && !zzd()) {
            zzb(true);
            this.zzb.zzc(activity, this.zzi, new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: com.google.android.gms.internal.consent_sdk.zzh
                @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
                public final void onConsentInfoUpdateSuccess() {
                    this.zza.zzb(false);
                }
            }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: com.google.android.gms.internal.consent_sdk.zzi
                @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
                public final void onConsentInfoUpdateFailure(FormError formError) {
                    this.zza.zzb(false);
                }
            });
            return;
        }
        Log.w("UserMessagingPlatform", "Retry request is not executed. consentInfoUpdateHasBeenCalled=" + zzc() + ", retryRequestIsInProgress=" + zzd());
    }

    public final void zzb(boolean z2) {
        synchronized (this.zze) {
            this.zzh = z2;
        }
    }

    public final boolean zzc() {
        boolean z2;
        synchronized (this.zzd) {
            z2 = this.zzg;
        }
        return z2;
    }

    public final boolean zzd() {
        boolean z2;
        synchronized (this.zze) {
            z2 = this.zzh;
        }
        return z2;
    }
}
