package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzos {
    public static final /* synthetic */ int zza = 0;
    private static final zzos zzb = new zzos();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzox zzc = new zzoa();

    private zzos() {
    }

    public static zzos zza() {
        return zzb;
    }

    public final zzow zzb(Class cls) {
        zznl.zzc(cls, "messageType");
        zzow zzowVar = (zzow) this.zzd.get(cls);
        if (zzowVar != null) {
            return zzowVar;
        }
        zzow zzowVarZza = this.zzc.zza(cls);
        zznl.zzc(cls, "messageType");
        zzow zzowVar2 = (zzow) this.zzd.putIfAbsent(cls, zzowVarZza);
        return zzowVar2 == null ? zzowVarZza : zzowVar2;
    }
}
