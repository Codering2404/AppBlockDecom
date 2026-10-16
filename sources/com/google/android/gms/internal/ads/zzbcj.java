package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcj extends zzbdf {
    private final long zzh;

    public zzbcj(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, long j3, int i3, int i4) {
        super(zzbbsVar, "y0L1OSEMWW8/imV1M3pvQITWJfkGk5GAMqJuL5aNLdq8sTbK6BFpI8/D5pLc65zr", "dBSRUGPKY8JzIPoAEV0GB9RkRHGvAJPAM3BhqN1QQjE=", zzaxmVar, i3, 25);
        this.zzh = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zze.invoke(null, null)).longValue();
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            try {
                zzaxmVar.zzac(jLongValue);
                long j3 = this.zzh;
                if (j3 != 0) {
                    zzaxmVar.zzk(jLongValue - j3);
                    zzaxmVar.zzn(j3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
