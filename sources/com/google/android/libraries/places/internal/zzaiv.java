package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaiv extends zzbdq implements zzbey {
    private static final zzaiv zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private int zze;
    private boolean zzf;
    private long zzg;

    static {
        zzaiv zzaivVar = new zzaiv();
        zzh = zzaivVar;
        zzbdq.D(zzaiv.class, zzaivVar);
    }

    private zzaiv() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဂ\u0002", new Object[]{"zzb", "zze", zzaiu.f75636a, "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzaiv();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzait(bArr);
        }
        if (i4 == 5) {
            return zzh;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzi;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaiv.class) {
            try {
                zzbdlVar = zzi;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzh);
                    zzi = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
