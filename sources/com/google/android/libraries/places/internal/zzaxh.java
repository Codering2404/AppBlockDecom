package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaxh extends zzbdq implements zzbey {
    private static final zzaxh zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzbhv zze;
    private zzbea zzf = zzbdq.s();

    static {
        zzaxh zzaxhVar = new zzaxh();
        zzg = zzaxhVar;
        zzbdq.D(zzaxh.class, zzaxhVar);
    }

    private zzaxh() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"zzb", "zze", "zzf", zzbau.class});
        }
        if (i4 == 3) {
            return new zzaxh();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaxg(bArr);
        }
        if (i4 == 5) {
            return zzg;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzh;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaxh.class) {
            try {
                zzbdlVar = zzh;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzg);
                    zzh = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
