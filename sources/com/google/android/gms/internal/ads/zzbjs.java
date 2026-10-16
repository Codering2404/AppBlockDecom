package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbjs extends CustomTabsCallback {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final List zzb = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlo)).split(","));
    private final zzbjv zzc;
    private final CustomTabsCallback zzd;
    private final zzdzq zze;

    zzbjs(zzbjv zzbjvVar, CustomTabsCallback customTabsCallback, zzdzq zzdzqVar) {
        this.zzd = customTabsCallback;
        this.zzc = zzbjvVar;
        this.zze = zzdzqVar;
    }

    private final void zzb(String str) {
        com.google.android.gms.ads.nonagon.signalgeneration.zzv.e(this.zze, null, "pact_action", new Pair("pe", str));
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void extraCallback(String str, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.extraCallback(str, bundle);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            return customTabsCallback.extraCallbackWithResult(str, bundle);
        }
        return null;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onActivityResized(int i3, int i4, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onActivityResized(i3, i4, bundle);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onMessageChannelReady(Bundle bundle) {
        this.zza.set(false);
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onMessageChannelReady(bundle);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i3, Bundle bundle) {
        this.zza.set(false);
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onNavigationEvent(i3, bundle);
        }
        zzbjv zzbjvVar = this.zzc;
        zzbjvVar.zzg(com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        List list = this.zzb;
        if (list == null || !list.contains(String.valueOf(i3))) {
            return;
        }
        zzbjvVar.zzc();
        zzb("pact_reqpmc");
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onPostMessage(String str, Bundle bundle) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("gpa", -1) == 0) {
                this.zza.set(true);
                zzb("pact_con");
                this.zzc.zzd(jSONObject.getString("paw_id"));
            }
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Message is not in JSON format: ", e3);
        }
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onPostMessage(str, bundle);
        }
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onRelationshipValidationResult(int i3, Uri uri, boolean z2, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onRelationshipValidationResult(i3, uri, z2, bundle);
        }
    }

    public final Boolean zza() {
        return Boolean.valueOf(this.zza.get());
    }
}
