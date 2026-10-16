package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfwt extends zzfwu {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfwt(zzfwm zzfwmVar, HashSet hashSet, JSONObject jSONObject, long j3) {
        super(zzfwmVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j3;
    }
}
