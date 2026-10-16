package com.google.android.gms.internal.ads;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzayu extends zziee implements zzifq {
    private static final zzayu zze;
    private static volatile zzifx zzf;
    private int zza;
    private long zzb;
    private long zzc;
    private long zzd;

    static {
        zzayu zzayuVar = new zzayu();
        zze = zzayuVar;
        zziee.zzbu(zzayu.class, zzayuVar);
    }

    private zzayu() {
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
                                zzifx zzifxVar = zzf;
                                if (zzifxVar == null) {
                                    synchronized (zzayu.class) {
                                        try {
                                            zzidzVar = zzf;
                                            if (zzidzVar == null) {
                                                zzidzVar = new zzidz(zze);
                                                zzf = zzidzVar;
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
                        return zze;
                    }
                    return new zzayt(bArr);
                }
                return new zzayu();
            }
            return zziee.zzbv(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zza", bfIdKSjLOVjG.tdMyTwg, "zzc", "zzd"});
        }
        return (byte) 1;
    }
}
