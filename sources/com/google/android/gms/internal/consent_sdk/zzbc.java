package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbc implements UserMessagingPlatform.OnConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener {
    private final UserMessagingPlatform.OnConsentFormLoadSuccessListener zza;
    private final UserMessagingPlatform.OnConsentFormLoadFailureListener zzb;

    /* synthetic */ zzbc(UserMessagingPlatform.OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener onConsentFormLoadFailureListener, zzbd zzbdVar) {
        this.zza = onConsentFormLoadSuccessListener;
        this.zzb = onConsentFormLoadFailureListener;
    }

    @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
    public final void onConsentFormLoadFailure(FormError formError) {
        this.zzb.onConsentFormLoadFailure(formError);
    }

    @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.zza.onConsentFormLoadSuccess(consentForm);
    }
}
