package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzahn extends zzbdq implements zzbey {
    private static final zzahn zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private float zze;
    private float zzf;
    private zzahj zzg;
    private zzahj zzh;
    private zzago zzi;
    private zzago zzj;
    private long zzk;

    static {
        zzahn zzahnVar = new zzahn();
        zzl = zzahnVar;
        zzbdq.D(zzahn.class, zzahnVar);
    }

    private zzahn() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဂ\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzahn();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzahm(bArr);
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
        synchronized (zzahn.class) {
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
