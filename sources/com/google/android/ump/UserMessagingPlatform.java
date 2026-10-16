package com.google.android.ump;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzbq;
import com.google.android.gms.internal.consent_sdk.zzcz;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import java.util.Objects;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class UserMessagingPlatform {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnConsentFormLoadFailureListener {
        void onConsentFormLoadFailure(FormError formError);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnConsentFormLoadSuccessListener {
        void onConsentFormLoadSuccess(ConsentForm consentForm);
    }

    public static ConsentInformation getConsentInformation(Context context) {
        return com.google.android.gms.internal.consent_sdk.zza.zza(context).zzb();
    }

    public static void loadAndShowConsentFormIfRequired(final Activity activity, final ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        com.google.android.gms.internal.consent_sdk.zza zzaVarZza = com.google.android.gms.internal.consent_sdk.zza.zza(activity);
        if (zzaVarZza.zzb().canRequestAds()) {
            onConsentFormDismissedListener.onConsentFormDismissed(null);
            return;
        }
        zzaVarZza.zzd().zzc();
        zzbq zzbqVarZzc = zzaVarZza.zzc();
        zzcz.zza();
        OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener = new OnConsentFormLoadSuccessListener() { // from class: com.google.android.gms.internal.consent_sdk.zzbo
            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
            public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
                consentForm.show(activity, onConsentFormDismissedListener);
            }
        };
        Objects.requireNonNull(onConsentFormDismissedListener);
        zzbqVarZzc.zzb(onConsentFormLoadSuccessListener, new OnConsentFormLoadFailureListener() { // from class: com.google.android.gms.internal.consent_sdk.zzbp
            @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
            public final void onConsentFormLoadFailure(FormError formError) {
                onConsentFormDismissedListener.onConsentFormDismissed(formError);
            }
        }, true);
    }

    public static void loadConsentForm(Context context, OnConsentFormLoadSuccessListener onConsentFormLoadSuccessListener, OnConsentFormLoadFailureListener onConsentFormLoadFailureListener) {
        com.google.android.gms.internal.consent_sdk.zza zzaVarZza = com.google.android.gms.internal.consent_sdk.zza.zza(context);
        ((Queue) zzaVarZza.zzd().zzb.get()).add(Long.valueOf(System.currentTimeMillis()));
        zzaVarZza.zzc().zzb(onConsentFormLoadSuccessListener, onConsentFormLoadFailureListener, false);
    }

    public static void showPrivacyOptionsForm(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        com.google.android.gms.internal.consent_sdk.zza.zza(activity).zzc().zze(activity, onConsentFormDismissedListener);
    }
}
