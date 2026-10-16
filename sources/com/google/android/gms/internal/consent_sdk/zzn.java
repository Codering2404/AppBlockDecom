package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzn {
    private final Application zza;
    private final zzaq zzb;

    zzn(Application application, zzaq zzaqVar) {
        this.zza = application;
        this.zzb = zzaqVar;
    }

    final zzcl zzc(Activity activity, ConsentRequestParameters consentRequestParameters) throws zzg {
        ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
        if (consentDebugSettings == null) {
            consentDebugSettings = new ConsentDebugSettings.Builder(this.zza).build();
        }
        return zzp.zza(new zzp(this, activity, consentDebugSettings, consentRequestParameters, null));
    }
}
