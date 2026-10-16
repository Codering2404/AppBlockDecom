package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzam {
    private final Context zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();

    zzam(Application application) {
        this.zza = application.getApplicationContext();
    }

    public final Object zza(String str) {
        Object obj;
        AtomicReference atomicReference = this.zzf;
        if (atomicReference.get() == null || (obj = ((Bundle) atomicReference.get()).get(str)) == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final void zzb(Context context) {
        AtomicReference atomicReference = this.zzf;
        if (atomicReference.get() == null) {
            try {
                atomicReference.set(Wrappers.a(context).c(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData);
            } catch (PackageManager.NameNotFoundException | NullPointerException e3) {
                Log.w("UserMessagingPlatform", "Failed to get metadata. ", e3);
            }
        }
    }

    public final void zzc(Map map) {
        Log.d("UserMessagingPlatform", "Update Firebase: ".concat(map.toString()));
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            try {
                map2.put((Enum) ((Method) this.zze.get()).invoke(null, str), (Enum) ((Method) this.zzd.get()).invoke(null, map.get(str)));
            } catch (Exception e3) {
                Log.w("UserMessagingPlatform", "Failed to invoke the Firebase static method.", e3);
            }
        }
        AtomicReference atomicReference = this.zzc;
        if (atomicReference.get() == null || map2.isEmpty()) {
            return;
        }
        try {
            ((Method) atomicReference.get()).invoke(this.zzb.get(), map2);
        } catch (Exception e4) {
            Log.w("UserMessagingPlatform", "Failed to invoke Firebase method. ", e4);
        }
    }

    public final boolean zzd() {
        AtomicReference atomicReference = this.zzg;
        if (atomicReference.get() != null) {
            return ((Boolean) atomicReference.get()).booleanValue();
        }
        Context context = this.zza;
        if (context == null) {
            atomicReference.set(Boolean.FALSE);
            return false;
        }
        try {
            this.zzb.set(FirebaseAnalytics.class.getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            this.zzc.set(FirebaseAnalytics.class.getDeclaredMethod("setConsent", Map.class));
            FirebaseAnalytics.ConsentStatus consentStatus = FirebaseAnalytics.ConsentStatus.GRANTED;
            FirebaseAnalytics.ConsentType consentType = FirebaseAnalytics.ConsentType.AD_STORAGE;
            Method declaredMethod = FirebaseAnalytics.ConsentStatus.class.getDeclaredMethod("valueOf", String.class);
            Method declaredMethod2 = FirebaseAnalytics.ConsentType.class.getDeclaredMethod("valueOf", String.class);
            this.zzd.set(declaredMethod);
            this.zze.set(declaredMethod2);
            this.zzg.set(Boolean.TRUE);
            return true;
        } catch (Exception e3) {
            Log.w("UserMessagingPlatform", "No Firebase class found. ", e3);
            this.zzg.set(Boolean.FALSE);
            return false;
        }
    }
}
