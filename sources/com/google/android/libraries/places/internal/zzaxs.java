package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaxs extends zzbdq implements zzbey {
    private static final zzaxs zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzbea zze = zzbdq.s();
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();
    private zzaxh zzh;

    static {
        zzaxs zzaxsVar = new zzaxs();
        zzi = zzaxsVar;
        zzbdq.D(zzaxs.class, zzaxsVar);
    }

    private zzaxs() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဉ\u0000", new Object[]{"zzb", "zze", zzbau.class, "zzf", zzaym.class, "zzg", zzaxr.class, "zzh"});
        }
        if (i4 == 3) {
            return new zzaxs();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaxf(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaxs.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
