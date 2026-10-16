package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzo extends zzbdq implements zzbey {
    private static final zzo zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private zzcp zze;
    private long zzf;
    private int zzg;
    private boolean zzh;
    private zzau zzi;

    static {
        zzo zzoVar = new zzo();
        zzj = zzoVar;
        zzbdq.D(zzo.class, zzoVar);
    }

    private zzo() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0005ဉ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", zzp.f78382a, "zzh", "zzi"});
        }
        if (i4 == 3) {
            return new zzo();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzn(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzk;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzo.class) {
            try {
                zzbdlVar = zzk;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzj);
                    zzk = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
