package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbw extends zzbdq implements zzbey {
    private static final zzbw zzm;
    private static volatile zzbff zzn;
    private int zzb;
    private zzcp zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private int zzi;
    private boolean zzj;
    private int zzk;
    private int zzl;

    static {
        zzbw zzbwVar = new zzbw();
        zzm = zzbwVar;
        zzbdq.D(zzbw.class, zzbwVar);
    }

    private zzbw() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005င\u0004\u0006ဇ\u0005\u0007င\u0007\bင\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzl", "zzk"});
        }
        if (i4 == 3) {
            return new zzbw();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbv(bArr);
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
        synchronized (zzbw.class) {
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
