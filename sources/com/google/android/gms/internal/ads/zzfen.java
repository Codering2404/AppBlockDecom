package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfen implements zzfci {
    private final Bundle zza;

    public zzfen(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.zza;
        if (bundle != null) {
            try {
                com.google.android.gms.ads.internal.util.zzbp.h(com.google.android.gms.ads.internal.util.zzbp.h(jSONObject, DeviceRequestsHelper.DEVICE_INFO_DEVICE), "play_store").put("parental_controls", com.google.android.gms.ads.internal.client.zzay.a().y(bundle));
            } catch (JSONException unused) {
                com.google.android.gms.ads.internal.util.zze.k("Failed putting parental controls bundle.");
            }
        }
    }
}
