package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzczx {
    private final Object zza = new Object();
    private final ConcurrentHashMap zzb = new ConcurrentHashMap();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();
    private final ConcurrentHashMap zzd = new ConcurrentHashMap();

    public final void zza(String str) {
        synchronized (this.zza) {
            try {
                ConcurrentHashMap concurrentHashMap = this.zzb;
                Integer num = (Integer) concurrentHashMap.get(str);
                concurrentHashMap.put(str, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int zzb(String str) {
        Integer num = (Integer) this.zzb.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final long zzc(String str) {
        Long l3 = (Long) this.zzd.get(str);
        if (l3 == null) {
            return -1L;
        }
        return l3.longValue();
    }

    public final void zzd(String str, long j3) {
        this.zzc.put(str, Long.valueOf(j3));
    }

    public final void zze(String str, String str2, long j3) {
        ConcurrentHashMap concurrentHashMap = this.zzc;
        Long l3 = (Long) concurrentHashMap.get(str2);
        if (l3 == null) {
            return;
        }
        concurrentHashMap.remove(str2);
        this.zzd.put(str, Long.valueOf(j3 - l3.longValue()));
    }
}
