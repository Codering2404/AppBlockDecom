package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import java.util.Objects;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbjt extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbjv zzb;

    zzbjt(zzbjv zzbjvVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzbjvVar);
        this.zzb = zzbjvVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbjv zzbjvVar = this.zzb;
            zzbjvVar.zzi().h(zzbjvVar.zze(this.zza, str).toString(), null);
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Error creating PACT Error Response JSON: ", e3);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String strB = queryInfo.b();
        try {
            zzbjv zzbjvVar = this.zzb;
            zzbjvVar.zzi().h(zzbjvVar.zzf(this.zza, strB).toString(), null);
        } catch (JSONException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Error creating PACT Signal Response JSON: ", e3);
        }
    }
}
