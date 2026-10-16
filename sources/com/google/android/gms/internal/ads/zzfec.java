package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfec implements zzfck {
    private final JSONObject zza;

    zzfec(Context context) {
        this.zza = zzcaz.zzc(context, VersionInfoParcel.M());
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznu)).booleanValue() ? zzhbw.zza(zzfea.zza) : zzhbw.zza(new zzfci() { // from class: com.google.android.gms.internal.ads.zzfeb
            @Override // com.google.android.gms.internal.ads.zzfci
            public final /* synthetic */ void zza(Object obj) {
                this.zza.zzc((JSONObject) obj);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 46;
    }

    final /* synthetic */ void zzc(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zza);
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zze.k("Failed putting version constants.");
        }
    }
}
