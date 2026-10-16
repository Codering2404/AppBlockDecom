package com.google.android.gms.internal.ads;

import com.facebook.share.HKJ.pnxuebdT;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpt extends zziee implements zzifq {
    private static final zzfpt zzg;
    private static volatile zzifx zzh;
    private long zza;
    private zziem zzb = zziee.zzbC();
    private zzieq zzc = zziee.zzbM();
    private zzieq zzd = zziee.zzbM();
    private zzieq zze = zziee.zzbM();
    private zzieq zzf = zziee.zzbM();

    static {
        zzfpt zzfptVar = new zzfpt();
        zzg = zzfptVar;
        zziee.zzbu(zzfpt.class, zzfptVar);
    }

    private zzfpt() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    byte[] bArr = null;
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            if (iOrdinal == 6) {
                                zzifx zzifxVar = zzh;
                                if (zzifxVar == null) {
                                    synchronized (zzfpt.class) {
                                        try {
                                            zzidzVar = zzh;
                                            if (zzidzVar == null) {
                                                zzidzVar = new zzidz(zzg);
                                                zzh = zzidzVar;
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    return zzidzVar;
                                }
                                return zzifxVar;
                            }
                            throw null;
                        }
                        return zzg;
                    }
                    return new zzfps(bArr);
                }
                return new zzfpt();
            }
            return zziee.zzbv(zzg, "\u0004\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0005\u0000\u0001\u0002\u0002,\u0003Ț\u0004Ț\u0005Ț\u0006Ț", new Object[]{"zza", "zzb", "zzc", "zzd", pnxuebdT.JYggNioFzxkqBC, "zzf"});
        }
        return (byte) 1;
    }
}
