package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbb extends com.google.android.gms.analytics.zzj {
    private final Map zza = new HashMap();

    public final String toString() {
        return com.google.android.gms.analytics.zzj.zza(this.zza);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbb zzbbVar = (zzbb) zzjVar;
        Preconditions.m(zzbbVar);
        zzbbVar.zza.putAll(this.zza);
    }

    public final Map zzd() {
        return Collections.unmodifiableMap(this.zza);
    }

    public final void zze(String str, String str2) {
        Preconditions.g(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        Preconditions.h(str, "Name can not be empty or \"&\"");
        this.zza.put(str, str2);
    }
}
