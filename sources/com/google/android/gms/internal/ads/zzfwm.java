package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfwm {
    private JSONObject zza;
    private final zzfwv zzb;

    public zzfwm(zzfwv zzfwvVar) {
        this.zzb = zzfwvVar;
    }

    public final void zza(JSONObject jSONObject, HashSet hashSet, long j3) {
        this.zzb.zza(new zzfwy(this, hashSet, jSONObject, j3));
    }

    public final void zzb(JSONObject jSONObject, HashSet hashSet, long j3) {
        this.zzb.zza(new zzfwx(this, hashSet, jSONObject, j3));
    }

    public final void zzc() {
        this.zzb.zza(new zzfww(this));
    }

    public final JSONObject zzd() {
        return this.zza;
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
