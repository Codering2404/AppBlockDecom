package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbs extends zzbdq implements zzbey {
    private static final zzbs zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private int zze = 1;
    private zzbu zzf;
    private zzbn zzg;
    private zzcy zzh;
    private zzbp zzi;
    private zzbw zzj;

    static {
        zzbs zzbsVar = new zzbs();
        zzk = zzbsVar;
        zzbdq.D(zzbs.class, zzbsVar);
    }

    private zzbs() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005", new Object[]{"zzb", "zze", zzbr.f76691a, "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzbs();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbq(bArr);
        }
        if (i4 == 5) {
            return zzk;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzl;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbs.class) {
            try {
                zzbdlVar = zzl;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzk);
                    zzl = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
