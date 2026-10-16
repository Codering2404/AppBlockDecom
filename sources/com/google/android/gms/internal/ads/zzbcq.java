package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcq extends zzbdf {
    private final zzbav zzh;
    private final long zzi;
    private final long zzj;

    public zzbcq(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, zzbav zzbavVar, long j3, long j4) {
        super(zzbbsVar, "0RGuaC1LZ8p4RZIWK5IFPvVh1XqX7pdLKGQgqTXZ1mkub6VwNtebK8xyUGpHkvMn", "mIcXOfgrOloP6pQFjXZ3aL2iJ7mq+own2SaqzDvu6Tk=", zzaxmVar, i3, 11);
        this.zzh = zzbavVar;
        this.zzi = j3;
        this.zzj = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzbav zzbavVar = this.zzh;
        if (zzbavVar != null) {
            zzbat zzbatVar = new zzbat((String) this.zze.invoke(null, zzbavVar.zzb(), Long.valueOf(this.zzi), Long.valueOf(this.zzj)));
            zzaxm zzaxmVar = this.zzd;
            synchronized (zzaxmVar) {
                try {
                    zzaxmVar.zzf(zzbatVar.zza.longValue());
                    if (zzbatVar.zzb.longValue() >= 0) {
                        zzaxmVar.zzW(zzbatVar.zzb.longValue());
                    }
                    if (zzbatVar.zzc.longValue() >= 0) {
                        zzaxmVar.zzX(zzbatVar.zzc.longValue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
