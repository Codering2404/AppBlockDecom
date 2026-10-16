package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzalg extends zzbdq implements zzbey {
    private static final zzalg zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzbdy zze = zzbdq.p();
    private int zzf;

    static {
        zzalg zzalgVar = new zzalg();
        zzg = zzalgVar;
        zzbdq.D(zzalg.class, zzalgVar);
    }

    private zzalg() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ࠞ\u0002င\u0000", new Object[]{"zzb", "zze", zzale.f75671a, "zzf"});
        }
        if (i4 == 3) {
            return new zzalg();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzalf(bArr);
        }
        if (i4 == 5) {
            return zzg;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzh;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzalg.class) {
            try {
                zzbdlVar = zzh;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzg);
                    zzh = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
