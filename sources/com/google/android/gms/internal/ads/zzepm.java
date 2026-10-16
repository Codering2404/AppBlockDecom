package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzepm {
    private zzepd zza;

    zzepm() {
    }

    public static zzepm zza(zzepd zzepdVar) {
        return new zzepm(zzepdVar);
    }

    public final zzepd zzb(Clock clock, zzepf zzepfVar, zzelx zzelxVar, zzfsc zzfscVar) {
        zzepd zzepdVar = this.zza;
        return zzepdVar != null ? zzepdVar : new zzepd(clock, zzepfVar, zzelxVar, zzfscVar);
    }

    private zzepm(zzepd zzepdVar) {
        this.zza = zzepdVar;
    }
}
