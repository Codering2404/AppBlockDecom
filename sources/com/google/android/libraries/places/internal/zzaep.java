package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaep extends zzbdq implements zzbey {
    private static final zzaep zzm;
    private static volatile zzbff zzn;
    private int zzb;
    private int zze;
    private int zzf;
    private long zzg;
    private int zzh;
    private boolean zzi;
    private long zzj;
    private zzya zzk;
    private zzbea zzl = zzbdq.s();

    static {
        zzaep zzaepVar = new zzaep();
        zzm = zzaepVar;
        zzbdq.D(zzaep.class, zzaepVar);
    }

    private zzaep() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003ဂ\u0002\u0004င\u0003\u0005ဇ\u0004\u0006ဂ\u0005\u0007ဉ\u0006\b\u001b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzya.class});
        }
        if (i4 == 3) {
            return new zzaep();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaeo(bArr);
        }
        if (i4 == 5) {
            return zzm;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzn;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaep.class) {
            try {
                zzbdlVar = zzn;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzm);
                    zzn = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
