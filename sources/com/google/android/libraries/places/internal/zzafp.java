package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzafp extends zzbdq implements zzbey {
    private static final zzafp zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private int zze;
    private long zzf;
    private int zzg;
    private long zzh;
    private long zzi;
    private long zzj;

    static {
        zzafp zzafpVar = new zzafp();
        zzk = zzafpVar;
        zzbdq.D(zzafp.class, zzafpVar);
    }

    private zzafp() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001\u0003င\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzafp();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzafo(bArr);
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
        synchronized (zzafp.class) {
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
