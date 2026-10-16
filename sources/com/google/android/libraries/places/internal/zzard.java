package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzard extends zzbdq implements zzbey {
    private static final zzard zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private int zze;
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();
    private zzbea zzh = zzbdq.s();

    static {
        zzard zzardVar = new zzard();
        zzi = zzardVar;
        zzbdq.D(zzard.class, zzardVar);
    }

    private zzard() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001င\u0000\u0002\u001a\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zze", "zzf", "zzg", zzarf.class, "zzh", zzaky.class});
        }
        if (i4 == 3) {
            return new zzard();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzarc(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzard.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
