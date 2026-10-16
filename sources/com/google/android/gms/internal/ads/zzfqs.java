package com.google.android.gms.internal.ads;

import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfqs extends zziee implements zzifq {
    private static final zzfqs zzb;
    private static volatile zzifx zzc;
    private String zza = "";

    static {
        zzfqs zzfqsVar = new zzfqs();
        zzb = zzfqsVar;
        zziee.zzbu(zzfqs.class, zzfqsVar);
    }

    private zzfqs() {
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
                                zzifx zzifxVar = zzc;
                                if (zzifxVar == null) {
                                    synchronized (zzfqs.class) {
                                        try {
                                            zzidzVar = zzc;
                                            if (zzidzVar == null) {
                                                zzidzVar = new zzidz(zzb);
                                                zzc = zzidzVar;
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
                        return zzb;
                    }
                    return new zzfqr(bArr);
                }
                return new zzfqs();
            }
            return zziee.zzbv(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{jTYhJgqLBN.FXGvmsG});
        }
        return (byte) 1;
    }
}
