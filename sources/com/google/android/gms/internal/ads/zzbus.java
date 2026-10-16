package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbus implements zzbqg {
    private final zzcfw zza;

    public zzbus(zzbuu zzbuuVar, zzcfw zzcfwVar) {
        Objects.requireNonNull(zzbuuVar);
        this.zza = zzcfwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zza(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e3) {
            this.zza.zzd(e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzb(String str) {
        try {
            if (str == null) {
                this.zza.zzd(new zzbtx());
            } else {
                this.zza.zzd(new zzbtx(str));
            }
        } catch (IllegalStateException unused) {
        }
    }
}
