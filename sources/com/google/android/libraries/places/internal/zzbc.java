package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbc extends zzbdq implements zzbey {
    private static final zzbc zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzbdy zzj = zzbdq.p();
    private int zzk;

    static {
        zzbc zzbcVar = new zzbc();
        zzl = zzbcVar;
        zzbdq.D(zzbc.class, zzbcVar);
    }

    private zzbc() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzbdw zzbdwVar = zzav.f75901a;
            zzbdw zzbdwVar2 = zzbb.f75984a;
            return zzbdq.m(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004င\u0003\u0005င\u0004\u0006ࠞ\u0007᠌\u0005", new Object[]{"zzb", "zze", zzbdwVar, "zzf", "zzg", "zzh", "zzi", "zzj", zzbdwVar2, "zzk", zzbdwVar2});
        }
        if (i4 == 3) {
            return new zzbc();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzba(bArr);
        }
        if (i4 == 5) {
            return zzl;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzm;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbc.class) {
            try {
                zzbdlVar = zzm;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzl);
                    zzm = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
