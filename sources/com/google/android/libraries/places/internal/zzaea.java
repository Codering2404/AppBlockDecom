package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaea extends zzbdq implements zzbey {
    private static final zzaea zze;
    private static volatile zzbff zzf;
    private zzbea zzb = zzbdq.s();

    static {
        zzaea zzaeaVar = new zzaea();
        zze = zzaeaVar;
        zzbdq.D(zzaea.class, zzaeaVar);
    }

    private zzaea() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzafx.class});
        }
        if (i4 == 3) {
            return new zzaea();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzadz(bArr);
        }
        if (i4 == 5) {
            return zze;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzf;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaea.class) {
            try {
                zzbdlVar = zzf;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zze);
                    zzf = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
