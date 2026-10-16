package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqz extends zzbdq implements zzbey {
    private static final zzaqz zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private int zze;
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();

    static {
        zzaqz zzaqzVar = new zzaqz();
        zzh = zzaqzVar;
        zzbdq.D(zzaqz.class, zzaqzVar);
    }

    private zzaqz() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001င\u0000\u0002\u001a\u0003\u001b", new Object[]{"zzb", "zze", "zzf", "zzg", zzarb.class});
        }
        if (i4 == 3) {
            return new zzaqz();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqy(bArr);
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
        synchronized (zzaqz.class) {
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
