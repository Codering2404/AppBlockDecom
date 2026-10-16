package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaoy extends zzbdq implements zzbey {
    private static final zzaoy zze;
    private static volatile zzbff zzf;
    private zzbdy zzb = zzbdq.p();

    static {
        zzaoy zzaoyVar = new zzaoy();
        zze = zzaoyVar;
        zzbdq.D(zzaoy.class, zzaoyVar);
    }

    private zzaoy() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001ࠞ", new Object[]{"zzb", zzarm.f75783a});
        }
        if (i4 == 3) {
            return new zzaoy();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaox(bArr);
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
        synchronized (zzaoy.class) {
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
