package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfrf extends zziee implements zzifq {
    private static final zzfrf zzg;
    private static volatile zzifx zzh;
    private int zzb;
    private int zzc;
    private boolean zzd;
    private boolean zzf;
    private String zza = "";
    private String zze = "";

    static {
        zzfrf zzfrfVar = new zzfrf();
        zzg = zzfrfVar;
        zziee.zzbu(zzfrf.class, zzfrfVar);
    }

    private zzfrf() {
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
                                    synchronized (zzfrf.class) {
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
                    return new zzfre(bArr);
                }
                return new zzfrf();
            }
            return zziee.zzbv(zzg, "\u0004\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u0007\u0005Ȉ\u0006\u0007", new Object[]{"zza", cJfnYMIyomoWf.SYKgZIYKXNKy, "zzc", muQRKXGtpOhe.rSt, "zze", "zzf"});
        }
        return (byte) 1;
    }
}
